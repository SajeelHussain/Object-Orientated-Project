//Osamah Alsumaitti
package src;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.converter.LadderConverter;
import javafx.css.converter.StringConverter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.sound.midi.Soundbank;
import javax.swing.plaf.TreeUI;
import java.util.*;

/***
*This class contains all the front end coding for this project
 */
public class Frontend extends Application {
/**
Declaring Static variables for connecting backend with front end
 */
    public static int ch1,ch2;
    public static String bedType, NumberOfBeds , ac , breakfast;
    public static String LDRNo[] = new String[10], DDRNo[] = new String[20], LSRNo[] = new String[10], DSRNo[] = new String[20];
    public static int charges, LDRAvailable , DDRAvailable , LSRAvailable, DSRAvailable;
    public static int myCase;
    public static String usedBy;
    public static boolean letsCheckout=false;
    public static int rtype;
    public static int roomNum;
    public static String roomBill ="";
    public static boolean toCancel = false;
    public static Map<String, String> dict = new HashMap<>();
    public static int id = 110;

    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color; -fx-font-size: 15px; " ;
    private static final String DEFAULT_BUTTON_STYLE ="-fx-background-color: rgb(42,54,104) ; -fx-text-fill: white; -fx-border-color:white; -fx-border-width: 1 1 1 1; -fx-border-radius: 5px; -fx-font-size: 15px;" ;
    @Override
    public void start(Stage stage) throws Exception {
/***
Declaring all scenes and Group for all windows
 */
        Group root1 = new Group();
        Group root2 = new Group();
        Scene scene1 = new Scene(root1, 900 , 550, Color.rgb(20,33,65));
        Scene scene2 = new Scene(root2, 900 , 550, Color.rgb(20,33,65));
        Group rootRoomDetails = new Group();
        Scene sceneRoomDetails = new Scene(rootRoomDetails, 900, 550, Color.rgb(20, 33, 65));

        Group rootRoomDetails1st = new Group();
        Scene sceneRoomDetails1st = new Scene(rootRoomDetails1st, 900, 550, Color.rgb(20, 33, 65));

        Group rootRoomAvail= new Group();
        Scene sceneRoomAvail = new Scene(rootRoomAvail, 900, 550, Color.rgb(20, 33, 65));

        Group rootRoomBookMenu = new Group();
        Scene sceneRoomBookMenu = new Scene(rootRoomBookMenu, 900, 550, Color.rgb(20, 33, 65));

        Group rootRoomBooking = new Group();
        Scene sceneRoomBooking = new Scene(rootRoomBooking, 900, 550, Color.rgb(20, 33, 65));

        Group rootRoomCheckoutPre = new Group();
        Scene sceneRoomCheckoutPre = new Scene(rootRoomCheckoutPre, 900, 550, Color.rgb(20, 33, 65));

        Group rootBill = new Group();
        Scene sceneBill = new Scene(rootBill, 900, 550, Color.rgb(20, 33, 65));

        Group rootRoomBooked = new Group();
        Scene sceneRoomBooked = new Scene(rootRoomBooked, 900, 550, Color.rgb(20, 33, 65));

        Group rootRoomCancel = new Group();
        Scene sceneRoomCancel = new Scene(rootRoomCancel, 900, 550, Color.rgb(20, 33, 65));
        String css = this.getClass().getResource("myTable.css").toExternalForm();
        sceneRoomCancel.getStylesheets().add(css);

        Group rootRoomCanceledSuccess = new Group();
        Scene sceneRoomCanceledSuccess = new Scene(rootRoomCanceledSuccess, 900, 550, Color.rgb(20, 33, 65));
        /***
        Setting title of window
         */
        stage.setTitle("Hotel Management System");
        /***
        Setting window not resizable
         */
        stage.setResizable(false);



        //obj of main
        Main mainObj = new Main();


        /***
        Title label for main screen
         */
        Label titleLbl = new Label("Hotel Management");
        titleLbl.setTranslateX(300);
        titleLbl.setTranslateY(100);
        titleLbl.setBackground(Background.fill(Color.rgb(42,54,104)));
        titleLbl.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 25));
        titleLbl.setTextFill(Color.WHITE);
        titleLbl.setMinHeight(50);
        titleLbl.setMinWidth(310);
        titleLbl.setAlignment(Pos.CENTER);


        /***
        "Please Enter Pin Label
         */
        Label pinLbl = new Label("Please Enter pin");
        pinLbl.setTranslateX(360);
        pinLbl.setTranslateY(250);
        pinLbl.setBackground(Background.fill(Color.rgb(42,54,104)));
        pinLbl.setFont(Font.font("Helvetica", 15));
        pinLbl.setTextFill(Color.WHITE);
        pinLbl.setMinHeight(30);
        pinLbl.setMinWidth(200);
        pinLbl.setAlignment(Pos.CENTER);


        /***
        Invalid label
         */
        Label invalidLbl = new Label("Invalid Pin !!!");
        invalidLbl.setTranslateX(390);
        invalidLbl.setTranslateY(330);
        invalidLbl.setBackground(Background.fill(Color.ORANGERED));
        invalidLbl.setFont(Font.font("Helvetica", 15));
        invalidLbl.setTextFill(Color.WHITE);
        invalidLbl.setMinHeight(30);
        invalidLbl.setMinWidth(100);
        invalidLbl.setAlignment(Pos.CENTER);
        invalidLbl.setVisible(false);


        /***
        making Password Text field
         */
        PasswordField pinTxt =  new PasswordField();
        pinTxt.setTranslateX(365);
        pinTxt.setTranslateY(290);

        /***
        Designing Go button
         */
        Button goBtn = new Button("GO");
        goBtn.setTranslateX(520);
        goBtn.setTranslateY(290);
        /***
        Css properties for Go button
         */
        goBtn.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
        /***
        Action Event for Go Button
         */
        EventHandler<ActionEvent> goEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(pinTxt.getText().equals("123")) {

                    stage.setScene(scene2);
                    pinTxt.clear();
                }
                else {
                    invalidLbl.setVisible(true);
                }
            }
        };
        goBtn.setOnAction(goEvent);

        /***
        Adding children to First window
         */
        root1.getChildren().add(pinTxt);
        root1.getChildren().add(goBtn);
        root1.getChildren().add(titleLbl);
        root1.getChildren().add(invalidLbl);
        root1.getChildren().add(pinLbl);


        /***
        Title label for scene 2
         */
        Label titleLbls2 = new Label("Hotel Management");
        titleLbls2.setTranslateX(300);
        titleLbls2.setTranslateY(100);
        titleLbls2.setBackground(Background.fill(Color.rgb(42,54,104)));
        titleLbls2.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 25));
        titleLbls2.setTextFill(Color.WHITE);
        titleLbls2.setMinHeight(50);
        titleLbls2.setMinWidth(310);
        titleLbls2.setAlignment(Pos.CENTER);

        /***
        Designing Room Details button
         */
        Button roomDetailBtn = new Button("Room Details");
        roomDetailBtn.setMinWidth(150);
        roomDetailBtn.setMinHeight(40);
        roomDetailBtn.setBackground(Background.fill(Color.rgb(42,54,104)));
        roomDetailBtn.setStyle(DEFAULT_BUTTON_STYLE);
        roomDetailBtn.setOnMouseEntered(e -> roomDetailBtn.setStyle(HOVERED_BUTTON_STYLE));
        roomDetailBtn.setOnMouseExited(e -> roomDetailBtn.setStyle(DEFAULT_BUTTON_STYLE));
        //button hover css https://stackoverflow.com/questions/30680570/javafx-button-border-and-hover
        roomDetailBtn.setTranslateY(180);
        roomDetailBtn.setTranslateX(380);
        /***
        Action Event for room details button
         */
        EventHandler<ActionEvent> detailsEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(sceneRoomDetails1st);
            }
        };
        roomDetailBtn.setOnAction(detailsEvent);




        /***
        Desigining book room button
         */
        Button bookRoomBtn = new Button("BookRoom");
        bookRoomBtn.setMinWidth(150);
        bookRoomBtn.setMinHeight(40);
        bookRoomBtn.setBackground(Background.fill(Color.rgb(42,54,104)));
        bookRoomBtn.setStyle(DEFAULT_BUTTON_STYLE);
        bookRoomBtn.setOnMouseEntered(e -> bookRoomBtn.setStyle(HOVERED_BUTTON_STYLE));
        bookRoomBtn.setOnMouseExited(e -> bookRoomBtn.setStyle(DEFAULT_BUTTON_STYLE));
        bookRoomBtn.setTranslateY(300);
        bookRoomBtn.setTranslateX(380);
        /***
        Action event for book room button
         */
        EventHandler<ActionEvent> bookRoomEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(sceneRoomBookMenu);
            }
        };
        bookRoomBtn.setOnAction(bookRoomEvent);


        /***
        Designing checkout button
         */
        Button checkoutBtn = new Button("Checkout");
        checkoutBtn.setMinWidth(130);
        checkoutBtn.setMinHeight(40);
        checkoutBtn.setBackground(Background.fill(Color.rgb(42,54,104)));
        checkoutBtn.setStyle(DEFAULT_BUTTON_STYLE);
        checkoutBtn.setOnMouseEntered(e -> checkoutBtn.setStyle(HOVERED_BUTTON_STYLE));
        checkoutBtn.setOnMouseExited(e -> checkoutBtn.setStyle(DEFAULT_BUTTON_STYLE));
        checkoutBtn.setTranslateY(360);
        checkoutBtn.setTranslateX(390);
        /***
        Action event for checkout button
         */
        EventHandler<ActionEvent> checkoutEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(sceneRoomCheckoutPre);
                letsCheckout=false;
            }
        };
        checkoutBtn.setOnAction(checkoutEvent);

        /***
         Designing cancel Booking button
         */
        Button cancelBookingBtn = new Button("Cancel Booking");
        cancelBookingBtn.setMinWidth(160);
        cancelBookingBtn.setMinHeight(40);
        cancelBookingBtn.setBackground(Background.fill(Color.rgb(42,54,104)));
        cancelBookingBtn.setStyle(DEFAULT_BUTTON_STYLE);
        cancelBookingBtn.setOnMouseEntered(e -> cancelBookingBtn.setStyle(HOVERED_BUTTON_STYLE));
        cancelBookingBtn.setOnMouseExited(e -> cancelBookingBtn.setStyle(DEFAULT_BUTTON_STYLE));
        cancelBookingBtn.setTranslateY(420);
        cancelBookingBtn.setTranslateX(375);

        /***
         Action event for checkout button
         */
        EventHandler<ActionEvent> cancelBookingEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(sceneRoomCancel);

                /**
                 * Table
                 */

                // use fully detailed type for Map.Entry<String, String>
                TableColumn<Map.Entry<String, String>, String> column1 = new TableColumn<>("Customer ID");
                column1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
                        // this callback returns property for just one cell, you can't use a loop here
                        // for first column we use key
                        return new SimpleStringProperty(p.getValue().getKey());
                    }
                });

                TableColumn<Map.Entry<String, String>, String> column2 = new TableColumn<>("Name");
                column2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
                        // for second column we use value
                        return new SimpleStringProperty(p.getValue().getValue());
                    }
                });

                ObservableList<Map.Entry<String, String>> items = FXCollections.observableArrayList(dict.entrySet());
                final TableView<Map.Entry<String,String>> table = new TableView<>(items);

                table.getColumns().setAll(column1, column2);
//        table.setBackground(Color.DEEPSKYBLUE);
                table.setTranslateX(250);
                table.setTranslateY(150);
                column1.setStyle("-fx-background-color: Black");
                column1.setStyle("-fx-border-color: red");
                column1.setStyle("-fx-table-cell-border-color:white;");
                column1.setMinWidth(120);
                column2.setMinWidth(280);
                table.setMaxHeight(300);;
                table.setId("tablex");
                rootRoomCancel.getChildren().add(table);

            }
        };
        cancelBookingBtn.setOnAction(cancelBookingEvent);



        /***
        Designing Exit button
         */
        Button exitBtn = new Button("EXIT");
        exitBtn.setMinWidth(100);
        exitBtn.setMinHeight(40);
        exitBtn.setBackground(Background.fill(Color.rgb(42,54,104)));
        exitBtn.setStyle("-fx-background-color: rgb(72, 61, 139) ; -fx-text-fill: white; -fx-border-color:white; -fx-border-width: 1 1 1 1; -fx-border-radius: 5px; -fx-font-size: 15px;");
        exitBtn.setOnMouseEntered(e -> exitBtn.setStyle("-fx-background-color: brown ; -fx-text-fill: white; -fx-border-color:white; -fx-border-width: 1 1 1 1; -fx-border-radius: 5px; -fx-font-size: 15px;"));
        exitBtn.setOnMouseExited(e -> exitBtn.setStyle("-fx-background-color: rgb(72, 61, 139) ; -fx-text-fill: white; -fx-border-color:white; -fx-border-width: 1 1 1 1; -fx-border-radius: 5px; -fx-font-size: 15px;"));
        exitBtn.setTranslateY(480);
        exitBtn.setTranslateX(405);
        /***
        Action event for exit button
         */
        exitBtn.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });


        /***
        Adding children to root 2
         */
        root2.getChildren().add(exitBtn);
        root2.getChildren().add(cancelBookingBtn);
        root2.getChildren().add(checkoutBtn);
        root2.getChildren().add(bookRoomBtn);
        root2.getChildren().add(roomDetailBtn);

        root2.getChildren().add(titleLbls2);



        /***
        Title label for Room details window
         */
        Label titleLbls4 = new Label("Room Details");
        titleLbls4.setTranslateX(300);
        titleLbls4.setTranslateY(70);
        titleLbls4.setBackground(Background.fill(Color.rgb(42,54,104)));
        titleLbls4.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 25));
        titleLbls4.setTextFill(Color.WHITE);
        titleLbls4.setMinHeight(50);
        titleLbls4.setMinWidth(310);
        titleLbls4.setAlignment(Pos.CENTER);







        /***
        room name label
         */
        Label roomNameLbl = new Label("");
        roomNameLbl.setTranslateX(300);
        roomNameLbl.setTranslateY(70);
        roomNameLbl.setBackground(Background.fill(Color.rgb(42,54,104)));
        roomNameLbl.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 25));
        roomNameLbl.setTextFill(Color.WHITE);
        roomNameLbl.setMinHeight(50);
        roomNameLbl.setMinWidth(310);
        roomNameLbl.setAlignment(Pos.CENTER);


        /***
        Bed Type label
         */
        Label bedTypeLbl = new Label("Bed Type");
        bedTypeLbl.setTranslateX(185);
        bedTypeLbl.setTranslateY(160);
        bedTypeLbl.setBackground(Background.fill(Color.DARKSLATEBLUE));
        bedTypeLbl.setFont(Font.font("Helvetica", 15));
        bedTypeLbl.setTextFill(Color.WHITE);
        bedTypeLbl.setMinHeight(30);
        bedTypeLbl.setMinWidth(200);
        bedTypeLbl.setAlignment(Pos.CENTER);

        /***
        Lable to print the type of bed
         */
        Label bedTypeLblB = new Label("");
        bedTypeLblB.setTranslateX(500);
        bedTypeLblB.setTranslateY(160);
        bedTypeLblB.setBackground(Background.fill(Color.WHITE));
        bedTypeLblB.setFont(Font.font("Helvetica", 15));
        bedTypeLblB.setTextFill(Color.BLACK);
        bedTypeLblB.setMinHeight(30);
        bedTypeLblB.setMinWidth(200);
        bedTypeLblB.setAlignment(Pos.CENTER);


        /**
        No of bed label
         */
        Label noOfBedLbl = new Label("Number of Beds");
        noOfBedLbl.setTranslateX(185);
        noOfBedLbl.setTranslateY(210);
        noOfBedLbl.setBackground(Background.fill(Color.DARKSLATEBLUE));
        noOfBedLbl.setFont(Font.font("Helvetica", 15));
        noOfBedLbl.setTextFill(Color.WHITE);
        noOfBedLbl.setMinHeight(30);
        noOfBedLbl.setMinWidth(200);
        noOfBedLbl.setAlignment(Pos.CENTER);

        /**
        Label for printing Number of beds
         */
        Label noOfBedLblB = new Label(NumberOfBeds);
        noOfBedLblB.setTranslateX(500);
        noOfBedLblB.setTranslateY(210);
        noOfBedLblB.setBackground(Background.fill(Color.WHITE));
        noOfBedLblB.setFont(Font.font("Helvetica", 15));
        noOfBedLblB.setTextFill(Color.BLACK);
        noOfBedLblB.setMinHeight(30);
        noOfBedLblB.setMinWidth(200);
        noOfBedLblB.setAlignment(Pos.CENTER);



        /**
        Ac label
         */
        Label ACLbl = new Label("AC");
        ACLbl.setTranslateX(185);
        ACLbl.setTranslateY(260);
        ACLbl.setBackground(Background.fill(Color.DARKSLATEBLUE));
        ACLbl.setFont(Font.font("Helvetica", 15));
        ACLbl.setTextFill(Color.WHITE);
        ACLbl.setMinHeight(30);
        ACLbl.setMinWidth(200);
        ACLbl.setAlignment(Pos.CENTER);

        /**
        Label for printing Ac availablty
         */
        Label ACLblB = new Label(ac);
        ACLblB.setTranslateX(500);
        ACLblB.setTranslateY(260);
        ACLblB.setBackground(Background.fill(Color.WHITE));
        ACLblB.setFont(Font.font("Helvetica", 15));
        ACLblB.setTextFill(Color.BLACK);
        ACLblB.setMinHeight(30);
        ACLblB.setMinWidth(200);
        ACLblB.setAlignment(Pos.CENTER);


        /**
        Breakfast label
         */
        Label breakfastLbl = new Label("Breakfast");
        breakfastLbl.setTranslateX(185);
        breakfastLbl.setTranslateY(310);
        breakfastLbl.setBackground(Background.fill(Color.DARKSLATEBLUE));
        breakfastLbl.setFont(Font.font("Helvetica", 15));
        breakfastLbl.setTextFill(Color.WHITE);
        breakfastLbl.setMinHeight(30);
        breakfastLbl.setMinWidth(200);
        breakfastLbl.setAlignment(Pos.CENTER);

        // LAbel for printing breakfast availability
        Label breakfastLblB = new Label(breakfast);
        breakfastLblB.setTranslateX(500);
        breakfastLblB.setTranslateY(310);
        breakfastLblB.setBackground(Background.fill(Color.WHITE));
        breakfastLblB.setFont(Font.font("Helvetica", 15));
        breakfastLblB.setTextFill(Color.BLACK);
        breakfastLblB.setMinHeight(30);
        breakfastLblB.setMinWidth(200);
        breakfastLblB.setAlignment(Pos.CENTER);



        // charges label
        Label chargesLbl = new Label("charges/day");
        chargesLbl.setTranslateX(185);
        chargesLbl.setTranslateY(360);
        chargesLbl.setBackground(Background.fill(Color.DARKSLATEBLUE));
        chargesLbl.setFont(Font.font("Helvetica", 15));
        chargesLbl.setTextFill(Color.WHITE);
        chargesLbl.setMinHeight(30);
        chargesLbl.setMinWidth(200);
        chargesLbl.setAlignment(Pos.CENTER);

        // charges labelB
        Label chargesLblB = new Label(String.valueOf(charges));
        chargesLblB.setTranslateX(500);
        chargesLblB.setTranslateY(360);
        chargesLblB.setBackground(Background.fill(Color.WHITE));
        chargesLblB.setFont(Font.font("Helvetica", 15));
        chargesLblB.setTextFill(Color.BLACK);
        chargesLblB.setMinHeight(30);
        chargesLblB.setMinWidth(200);
        chargesLblB.setAlignment(Pos.CENTER);




//Luxury Double room Details button
        Button LDRDetailBtn = new Button("Luxury Double Room");
        LDRDetailBtn.setMinWidth(150);
        LDRDetailBtn.setMinHeight(40);
        LDRDetailBtn.setBackground(Background.fill(Color.rgb(42,54,104)));
        LDRDetailBtn.setStyle(DEFAULT_BUTTON_STYLE);
        LDRDetailBtn.setOnMouseEntered(e -> LDRDetailBtn.setStyle(HOVERED_BUTTON_STYLE));
        LDRDetailBtn.setOnMouseExited(e -> LDRDetailBtn.setStyle(DEFAULT_BUTTON_STYLE));
        LDRDetailBtn.setTranslateY(180);
        LDRDetailBtn.setTranslateX(380);
        /**
        Action event for LDR Dedtails button
         */
        EventHandler<ActionEvent> LDRdetailEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(sceneRoomDetails);
                ch2 = 1;
                Hotel.features(1);

                roomNameLbl.setText("Luxury Double Room");
                bedTypeLblB.setText(bedType);
                noOfBedLblB.setText(NumberOfBeds);
                ACLblB.setText(ac);
                breakfastLblB.setText(breakfast);
                chargesLblB.setText(String.valueOf(charges));
                System.out.println(bedType);
                System.out.println(NumberOfBeds);
                System.out.println(ac);
                System.out.println(breakfast);
                System.out.println(String.valueOf(charges));
            }
        };
        LDRDetailBtn.setOnAction(LDRdetailEvent);



        //Delux double room Details button
        Button DDRDetailBtn = new Button("Deluxe Double Room");
        DDRDetailBtn.setMinWidth(150);
        DDRDetailBtn.setMinHeight(40);
        DDRDetailBtn.setBackground(Background.fill(Color.rgb(42,54,104)));
        DDRDetailBtn.setStyle(DEFAULT_BUTTON_STYLE);
        DDRDetailBtn.setOnMouseEntered(e -> DDRDetailBtn.setStyle(HOVERED_BUTTON_STYLE));
        DDRDetailBtn.setOnMouseExited(e -> DDRDetailBtn.setStyle(DEFAULT_BUTTON_STYLE));
        //button hover css https://stackoverflow.com/questions/30680570/javafx-button-border-and-hover
        DDRDetailBtn.setTranslateY(240);
        DDRDetailBtn.setTranslateX(380);
        /**
        Action event for DDR details button
         */
        EventHandler<ActionEvent> DDRdetailEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(sceneRoomDetails);
                Hotel.features(2);

                roomNameLbl.setText("Deluxe Double Room");
                bedTypeLblB.setText(bedType);
                noOfBedLblB.setText(NumberOfBeds);
                ACLblB.setText(ac);
                breakfastLblB.setText(breakfast);
                chargesLblB.setText(String.valueOf(charges));
                System.out.println(bedType);
                System.out.println(NumberOfBeds);
                System.out.println(ac);
                System.out.println(breakfast);
                System.out.println(String.valueOf(charges));
            }
        };
        DDRDetailBtn.setOnAction(DDRdetailEvent);



        //Luxury single room Details button
        Button LSRDetailBtn = new Button("Luxury Single Room");
        LSRDetailBtn.setMinWidth(150);
        LSRDetailBtn.setMinHeight(40);
        LSRDetailBtn.setBackground(Background.fill(Color.rgb(42,54,104)));
        LSRDetailBtn.setStyle(DEFAULT_BUTTON_STYLE);
        LSRDetailBtn.setOnMouseEntered(e -> LSRDetailBtn.setStyle(HOVERED_BUTTON_STYLE));
        LSRDetailBtn.setOnMouseExited(e -> LSRDetailBtn.setStyle(DEFAULT_BUTTON_STYLE));
        LSRDetailBtn.setTranslateY(300);
        LSRDetailBtn.setTranslateX(380);
        /**
        Action event for LSR details button
         */
        EventHandler<ActionEvent> LSRdetailEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(sceneRoomDetails);
                Hotel.features(2);

                roomNameLbl.setText("Luxury Single Room");
                bedTypeLblB.setText(bedType);
                noOfBedLblB.setText(NumberOfBeds);
                ACLblB.setText(ac);
                breakfastLblB.setText(breakfast);
                chargesLblB.setText(String.valueOf(charges));
                System.out.println(bedType);
                System.out.println(NumberOfBeds);
                System.out.println(ac);
                System.out.println(breakfast);
                System.out.println(String.valueOf(charges));
            }
        };
        LSRDetailBtn.setOnAction(LSRdetailEvent);



        //Delux single Room Details button
        Button DSRDetailBtn = new Button("Deluxe Single Room");
        DSRDetailBtn.setMinWidth(150);
        DSRDetailBtn.setMinHeight(40);
        DSRDetailBtn.setBackground(Background.fill(Color.rgb(42,54,104)));
        DSRDetailBtn.setStyle(DEFAULT_BUTTON_STYLE);
        DSRDetailBtn.setOnMouseEntered(e -> DSRDetailBtn.setStyle(HOVERED_BUTTON_STYLE));
        DSRDetailBtn.setOnMouseExited(e -> DSRDetailBtn.setStyle(DEFAULT_BUTTON_STYLE));
        DSRDetailBtn.setTranslateY(360);
        DSRDetailBtn.setTranslateX(380);
        /**
        Action event for DSR details button
         */
        EventHandler<ActionEvent> DSRdetailEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(sceneRoomDetails);
                Hotel.features(2);

                roomNameLbl.setText("Deluxe Single Room");
                bedTypeLblB.setText(bedType);
                noOfBedLblB.setText(NumberOfBeds);
                ACLblB.setText(ac);
                breakfastLblB.setText(breakfast);
                chargesLblB.setText(String.valueOf(charges));
                System.out.println(bedType);
                System.out.println(NumberOfBeds);
                System.out.println(ac);
                System.out.println(breakfast);
                System.out.println(String.valueOf(charges));
            }
        };
        DSRDetailBtn.setOnAction(DSRdetailEvent);



        rootRoomDetails1st.getChildren().add(DSRDetailBtn);
        rootRoomDetails1st.getChildren().add(LSRDetailBtn);
        rootRoomDetails1st.getChildren().add(DDRDetailBtn);
        rootRoomDetails1st.getChildren().add(LDRDetailBtn);
        rootRoomDetails1st.getChildren().add(titleLbls4);



//        --------------------------------------------------------------------------------------------------------

//Root room availability.
        // Title label Scene 2
        Label roomAvailLbl = new Label("Room Availability");
        roomAvailLbl.setTranslateX(300);
        roomAvailLbl.setTranslateY(70);
        roomAvailLbl.setBackground(Background.fill(Color.rgb(42,54,104)));
        roomAvailLbl.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 25));
        roomAvailLbl.setTextFill(Color.WHITE);
        roomAvailLbl.setMinHeight(50);
        roomAvailLbl.setMinWidth(310);
        roomAvailLbl.setAlignment(Pos.CENTER);


        // LDR availability label
        Label LDRAvailLbl = new Label("Luxury Double Room");
        LDRAvailLbl.setTranslateX(185);
        LDRAvailLbl.setTranslateY(160);
        LDRAvailLbl.setBackground(Background.fill(Color.DARKSLATEBLUE));
        LDRAvailLbl.setFont(Font.font("Helvetica", 15));
        LDRAvailLbl.setTextFill(Color.WHITE);
        LDRAvailLbl.setMinHeight(30);
        LDRAvailLbl.setMinWidth(200);
        LDRAvailLbl.setAlignment(Pos.CENTER);

        // LAbel to print LDR Availabilty
        Label LDRAvailLblB = new Label();

        LDRAvailLblB.setTranslateX(500);
        LDRAvailLblB.setTranslateY(160);
        LDRAvailLblB.setBackground(Background.fill(Color.WHITE));
        LDRAvailLblB.setFont(Font.font("Helvetica", 15));
        LDRAvailLblB.setTextFill(Color.BLACK);
        LDRAvailLblB.setMinHeight(30);
        LDRAvailLblB.setMinWidth(200);
        LDRAvailLblB.setAlignment(Pos.CENTER);


        // DDR Availabilty Lbl
        Label DDRAvailLbl = new Label("Deluxe Double Room");
        DDRAvailLbl.setTranslateX(185);
        DDRAvailLbl.setTranslateY(210);
        DDRAvailLbl.setBackground(Background.fill(Color.DARKSLATEBLUE));
        DDRAvailLbl.setFont(Font.font("Helvetica", 15));
        DDRAvailLbl.setTextFill(Color.WHITE);
        DDRAvailLbl.setMinHeight(30);
        DDRAvailLbl.setMinWidth(200);
        DDRAvailLbl.setAlignment(Pos.CENTER);

        /** LAbel to print LDR Availabilty */
        Label DDRAvailLblB = new Label();
        DDRAvailLblB.setTranslateX(500);
        DDRAvailLblB.setTranslateY(210);
        DDRAvailLblB.setBackground(Background.fill(Color.WHITE));
        DDRAvailLblB.setFont(Font.font("Helvetica", 15));
        DDRAvailLblB.setTextFill(Color.BLACK);
        DDRAvailLblB.setMinHeight(30);
        DDRAvailLblB.setMinWidth(200);
        DDRAvailLblB.setAlignment(Pos.CENTER);



        /** LSR Availabilty Lbl */
        Label LSRAvailLbl = new Label("Luxury Single Room");
        LSRAvailLbl.setTranslateX(185);
        LSRAvailLbl.setTranslateY(260);
        LSRAvailLbl.setBackground(Background.fill(Color.DARKSLATEBLUE));
        LSRAvailLbl.setFont(Font.font("Helvetica", 15));
        LSRAvailLbl.setTextFill(Color.WHITE);
        LSRAvailLbl.setMinHeight(30);
        LSRAvailLbl.setMinWidth(200);
        LSRAvailLbl.setAlignment(Pos.CENTER);

        /** LAbel to print LsR Availabilty */
        Label LSRAvailLblB = new Label();
        LSRAvailLblB.setTranslateX(500);
        LSRAvailLblB.setTranslateY(260);
        LSRAvailLblB.setBackground(Background.fill(Color.WHITE));
        LSRAvailLblB.setFont(Font.font("Helvetica", 15));
        LSRAvailLblB.setTextFill(Color.BLACK);
        LSRAvailLblB.setMinHeight(30);
        LSRAvailLblB.setMinWidth(200);
        LSRAvailLblB.setAlignment(Pos.CENTER);


        /** LAbel to print DSR Availabilty */
        Label DSRAvailLbl = new Label("Deluxe Single Room");
        DSRAvailLbl.setTranslateX(185);
        DSRAvailLbl.setTranslateY(310);
        DSRAvailLbl.setBackground(Background.fill(Color.DARKSLATEBLUE));
        DSRAvailLbl.setFont(Font.font("Helvetica", 15));
        DSRAvailLbl.setTextFill(Color.WHITE);
        DSRAvailLbl.setMinHeight(30);
        DSRAvailLbl.setMinWidth(200);
        DSRAvailLbl.setAlignment(Pos.CENTER);

        /** LAbel to print DSR Availabilty */

        Label DSRAvailLblB = new Label(String.valueOf(DSRAvailable));
        DSRAvailLblB.setTranslateX(500);
        DSRAvailLblB.setTranslateY(310);
        DSRAvailLblB.setBackground(Background.fill(Color.WHITE));
        DSRAvailLblB.setFont(Font.font("Helvetica", 15));
        DSRAvailLblB.setTextFill(Color.BLACK);
        DSRAvailLblB.setMinHeight(30);
        DSRAvailLblB.setMinWidth(200);
        DSRAvailLblB.setAlignment(Pos.CENTER);


        /**adding childern to Room availability root*/
        rootRoomAvail.getChildren().add(roomAvailLbl);
        rootRoomAvail.getChildren().add(DDRAvailLblB);
        rootRoomAvail.getChildren().add(DDRAvailLbl);
        rootRoomAvail.getChildren().add(LSRAvailLbl);
        rootRoomAvail.getChildren().add(LSRAvailLblB);
        rootRoomAvail.getChildren().add(DSRAvailLbl);
        rootRoomAvail.getChildren().add(DSRAvailLblB);
        rootRoomAvail.getChildren().add(LDRAvailLbl);
        rootRoomAvail.getChildren().add(LDRAvailLblB);

        //Room Availability button
        Button roomAvailabilityBtn = new Button("Room Availability");
        roomAvailabilityBtn.setMinWidth(150);
        roomAvailabilityBtn.setMinHeight(40);
        roomAvailabilityBtn.setBackground(Background.fill(Color.rgb(42,54,104)));
        roomAvailabilityBtn.setStyle(DEFAULT_BUTTON_STYLE);
        roomAvailabilityBtn.setOnMouseEntered(e -> roomAvailabilityBtn.setStyle(HOVERED_BUTTON_STYLE));
        roomAvailabilityBtn.setOnMouseExited(e -> roomAvailabilityBtn.setStyle(DEFAULT_BUTTON_STYLE));
        roomAvailabilityBtn.setTranslateY(240);
        roomAvailabilityBtn.setTranslateX(380);
        /**
        Room Availability action event
         */
        EventHandler<ActionEvent> AvailabilityEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(sceneRoomAvail);
                Hotel.availability();
                System.out.println(String.valueOf(LDRAvailable));
                LDRAvailLblB.setText(String.valueOf(LDRAvailable));
                DDRAvailLblB.setText(String.valueOf(DDRAvailable));
                LSRAvailLblB.setText(String.valueOf(LSRAvailable));
                DSRAvailLblB.setText(String.valueOf(DSRAvailable));



            }

        };
        roomAvailabilityBtn.setOnAction(AvailabilityEvent);
        root2.getChildren().add(roomAvailabilityBtn);


        //Room Booking scene

        Label titleLbls6 = new Label("Room Booking");
        titleLbls6.setTranslateX(300);
        titleLbls6.setTranslateY(70);
        titleLbls6.setBackground(Background.fill(Color.rgb(42,54,104)));
        titleLbls6.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 25));
        titleLbls6.setTextFill(Color.WHITE);
        titleLbls6.setMinHeight(50);
        titleLbls6.setMinWidth(310);
        titleLbls6.setAlignment(Pos.CENTER);


        /**
        Room number combo box
         */
        Label roomNoCbLbl = new Label("Room No");
        roomNoCbLbl.setTranslateX(320);
        roomNoCbLbl.setTranslateY(140);
        roomNoCbLbl.setBackground(Background.fill(Color.DARKSLATEBLUE));
        roomNoCbLbl.setFont(Font.font("Helvetica", 15));
        roomNoCbLbl.setTextFill(Color.WHITE);
        roomNoCbLbl.setMinHeight(30);
        roomNoCbLbl.setMinWidth(100);
        roomNoCbLbl.setAlignment(Pos.CENTER);


        /**
        customer name label
         */
        Label custNameLbl = new Label("Customer Name");
        custNameLbl.setTranslateX(120);
        custNameLbl.setTranslateY(190);
        custNameLbl.setBackground(Background.fill(Color.DARKSLATEBLUE));
        custNameLbl.setFont(Font.font("Helvetica", 15));
        custNameLbl.setTextFill(Color.WHITE);
        custNameLbl.setMinHeight(30);
        custNameLbl.setMinWidth(150);
        custNameLbl.setAlignment(Pos.CENTER);


        /**
        customer name text field
         */
        TextField custNameTF = new TextField();
        custNameTF.setTranslateX(290);
        custNameTF.setTranslateY(192);

        /**
        gender label
         */
        Label genderLbl = new Label("Gender");
        genderLbl.setTranslateX(520);
        genderLbl.setTranslateY(190);
        genderLbl.setBackground(Background.fill(Color.DARKSLATEBLUE));
        genderLbl.setFont(Font.font("Helvetica", 15));
        genderLbl.setTextFill(Color.WHITE);
        genderLbl.setMinHeight(30);
        genderLbl.setMinWidth(100);
        genderLbl.setAlignment(Pos.CENTER);

        /**
        gender combo box
         */
        ComboBox genderCB = new ComboBox();
        genderCB.getItems().addAll("Male" , "Female" , "Others");
        genderCB.setTranslateX(650);
        genderCB.setTranslateY(190);
        genderCB.getSelectionModel().selectFirst();



        /**
        room no check box
         */

        ComboBox<String> roomNoCB = new ComboBox<>(FXCollections.observableArrayList());
        roomNoCB.setTranslateX(540);
        roomNoCB.setTranslateY(145);


/**
contact label
 */
        Label contactLbl = new Label("Contact");
        contactLbl.setTranslateX(300);
        contactLbl.setTranslateY(240);
        contactLbl.setBackground(Background.fill(Color.DARKSLATEBLUE));
        contactLbl.setFont(Font.font("Helvetica", 15));
        contactLbl.setTextFill(Color.WHITE);
        contactLbl.setMinHeight(30);
        contactLbl.setMinWidth(150);
        contactLbl.setAlignment(Pos.CENTER);

        /**
        contact text field
         */
        TextField contactTF = new TextField();
        contactTF.setTranslateX(460);
        contactTF.setTranslateY(240);


        /**
        customer 2 label
         */
        Label custName2Lbl = new Label("Customer Name");
        custName2Lbl.setTranslateX(120);
        custName2Lbl.setTranslateY(350);
        custName2Lbl.setBackground(Background.fill(Color.DARKSLATEBLUE));
        custName2Lbl.setFont(Font.font("Helvetica", 15));
        custName2Lbl.setTextFill(Color.WHITE);
        custName2Lbl.setMinHeight(30);
        custName2Lbl.setMinWidth(150);
        custName2Lbl.setAlignment(Pos.CENTER);

        /**
        custoimer 2 name text field
         */

        TextField custName2TF = new TextField();
        custName2TF.setTranslateX(290);
        custName2TF.setTranslateY(352);

        /**
        gender 2 label
         */
        Label gender2Lbl = new Label("Gender");
        gender2Lbl.setTranslateX(520);
        gender2Lbl.setTranslateY(350);
        gender2Lbl.setBackground(Background.fill(Color.DARKSLATEBLUE));
        gender2Lbl.setFont(Font.font("Helvetica", 15));
        gender2Lbl.setTextFill(Color.WHITE);
        gender2Lbl.setMinHeight(30);
        gender2Lbl.setMinWidth(100);
        gender2Lbl.setAlignment(Pos.CENTER);


        /**
        gender 2 combobox
         */
        ComboBox gender2CB = new ComboBox();
        gender2CB.getItems().addAll("Male" , "Female" , "Others");
        gender2CB.setTranslateX(650);
        gender2CB.setTranslateY(350);
        gender2CB.getSelectionModel().selectFirst();

        /**
        customer 2 contact label
         */
        Label contact2Lbl = new Label("Contact");
        contact2Lbl.setTranslateX(300);
        contact2Lbl.setTranslateY(400);
        contact2Lbl.setBackground(Background.fill(Color.DARKSLATEBLUE));
        contact2Lbl.setFont(Font.font("Helvetica", 15));
        contact2Lbl.setTextFill(Color.WHITE);
        contact2Lbl.setMinHeight(30);
        contact2Lbl.setMinWidth(150);
        contact2Lbl.setAlignment(Pos.CENTER);


        /**
        contact 2 text field
         */
        TextField contact2TF = new TextField();
        contact2TF.setTranslateX(460);
        contact2TF.setTranslateY(402);


        /**
        submit button
         */
        Button submitBtn = new Button("Submit");
        submitBtn.setTranslateX(405);
        submitBtn.setTranslateY(480);
        submitBtn.setMinWidth(100);
        submitBtn.setMinHeight(30);
        submitBtn.setFont(Font.font("Helvetica", 15));
        submitBtn.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");

        /**
        action event submit button
         */
        EventHandler<ActionEvent> submitEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(myCase==1 || myCase==2){
                    stage.setScene(sceneRoomBooked);
                    Hotel.name = custNameTF.getText();
                    Hotel.contact = contactTF.getText();
                    Hotel.gender = genderCB.getValue().toString();

                    Hotel.rn =Integer.parseInt((String) roomNoCB.getValue())-1;
                    Hotel.name2 = custName2TF.getText();
                    Hotel.contact2 = contact2TF.getText();
                    Hotel.gender2 = gender2CB.getValue().toString();
                    System.out.println("Room no 1 : " +Hotel.rn);

                    Hotel.CustDetails(myCase, Hotel.rn);
                    System.out.println("Room no 2 : " +Hotel.rn);


                }
                else {
                    stage.setScene(sceneRoomBooked);
                    System.out.println("salam");
                    Hotel.name = custNameTF.getText();
                    Hotel.contact = contactTF.getText();
                    Hotel.gender = genderCB.getValue().toString();
                    Hotel.rn =Integer.parseInt((String) roomNoCB.getValue())-1 ;
                    System.out.println("room no " + Hotel.rn);
                    Hotel.CustDetails(myCase , Hotel.rn );
                    System.out.println("Salam2");


                }
                id++;
                dict.put(Integer.toString(id), custNameTF.getText());
                System.out.println("Print DIctionary");
                System.out.println(dict);

            }
        };
        submitBtn.setOnAction(submitEvent);


        /**
        adding childern to rootRoomBooking
         */
        rootRoomBooking.getChildren().add(roomNoCbLbl);
        rootRoomBooking.getChildren().add(titleLbls6);
        rootRoomBooking.getChildren().add(roomNoCB);
        rootRoomBooking.getChildren().add(custNameLbl);
        rootRoomBooking.getChildren().add(custNameTF);
        rootRoomBooking.getChildren().add(genderLbl);
        rootRoomBooking.getChildren().add(genderCB);
        rootRoomBooking.getChildren().add(contactLbl);
        rootRoomBooking.getChildren().add(contactTF);
        rootRoomBooking.getChildren().add(custName2Lbl);
        rootRoomBooking.getChildren().add(custName2TF);
        rootRoomBooking.getChildren().add(gender2Lbl);
        rootRoomBooking.getChildren().add(gender2CB);
        rootRoomBooking.getChildren().add(contact2Lbl);
        rootRoomBooking.getChildren().add(contact2TF);
        rootRoomBooking.getChildren().add(submitBtn);





        /**
        adding childern to rootRoomDetails
         */
        rootRoomDetails.getChildren().add(roomNameLbl);
        rootRoomDetails.getChildren().add(noOfBedLblB);
        rootRoomDetails.getChildren().add(noOfBedLbl);
        rootRoomDetails.getChildren().add(ACLbl);
        rootRoomDetails.getChildren().add(ACLblB);
        rootRoomDetails.getChildren().add(breakfastLbl);
        rootRoomDetails.getChildren().add(breakfastLblB);
        rootRoomDetails.getChildren().add(chargesLbl);
        rootRoomDetails.getChildren().add(chargesLblB);
        rootRoomDetails.getChildren().add(bedTypeLbl);
        rootRoomDetails.getChildren().add(bedTypeLblB);




        // Switch to main
        Button mainBtn1 = new Button("Main menu");
        mainBtn1.setTranslateX(800);
        mainBtn1.setTranslateY(30);
        mainBtn1.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
        EventHandler<ActionEvent> switchToMain = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               stage.setScene(scene2);
               pinTxt.clear();
               invalidLbl.setVisible(false);
                custName2TF.clear();
                custNameTF.clear();
                contact2TF.clear();
                contactTF.clear();
                roomNoCB.getItems().clear();
            }
        };

        /**
        adding main buttons to all windows
         */

        Button mainBtn2 = new Button("Main menu");
        mainBtn2.setTranslateX(800);
        mainBtn2.setTranslateY(30);
        mainBtn2.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");


        Button mainBtn3 = new Button("Main menu");
        mainBtn3.setTranslateX(800);
        mainBtn3.setTranslateY(30);
        mainBtn3.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");

        Button mainBtn4 = new Button("Main menu");
        mainBtn4.setTranslateX(800);
        mainBtn4.setTranslateY(30);
        mainBtn4.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");


        Button mainBtn5 = new Button("Main menu");
        mainBtn5.setTranslateX(800);
        mainBtn5.setTranslateY(30);
        mainBtn5.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");

        Button mainBtn6 = new Button("Main menu");
        mainBtn6.setTranslateX(800);
        mainBtn6.setTranslateY(30);
        mainBtn6.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");

        Button mainBtn7 = new Button("Main menu");
        mainBtn7.setTranslateX(800);
        mainBtn7.setTranslateY(30);
        mainBtn7.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");

        Button mainBtn8 = new Button("Main menu");
        mainBtn8.setTranslateX(800);
        mainBtn8.setTranslateY(30);
        mainBtn8.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");

        Button mainBtn9 = new Button("Main menu");
        mainBtn9.setTranslateX(800);
        mainBtn9.setTranslateY(30);
        mainBtn9.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");

        Button mainBtn10 = new Button("Main menu");
        mainBtn10.setTranslateX(800);
        mainBtn10.setTranslateY(30);
        mainBtn10.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");

        Button mainBtn11 = new Button("Main menu");
        mainBtn11.setTranslateX(800);
        mainBtn11.setTranslateY(30);
        mainBtn11.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
        /**
        setting on action for all main buttons
         */

        mainBtn1.setOnAction(switchToMain);
        mainBtn2.setOnAction(switchToMain);
        mainBtn3.setOnAction(switchToMain);
        mainBtn4.setOnAction(switchToMain);
        mainBtn5.setOnAction(switchToMain);
        mainBtn6.setOnAction(switchToMain);
        mainBtn7.setOnAction(switchToMain);
        mainBtn8.setOnAction(switchToMain);
        mainBtn9.setOnAction(switchToMain);
        mainBtn10.setOnAction(switchToMain);
        mainBtn11.setOnAction(switchToMain);







        /**
        adding main buttons to all roots
         */
//        root1.getChildren().add(mainBtn1);
        root2.getChildren().add(mainBtn2);
        rootRoomAvail.getChildren().add(mainBtn3);
        rootRoomDetails.getChildren().add(mainBtn4);
        rootRoomDetails1st.getChildren().add(mainBtn5);
        rootRoomBooking.getChildren().add(mainBtn6);
        rootBill.getChildren().add(mainBtn7);
        rootRoomBookMenu.getChildren().add(mainBtn8);
        rootRoomCheckoutPre.getChildren().add(mainBtn9);




        //LDR Book button
        Button LDRBookBtn = new Button("Luxury Double Room");
        LDRBookBtn.setMinWidth(150);
        LDRBookBtn.setMinHeight(40);
        LDRBookBtn.setBackground(Background.fill(Color.rgb(42,54,104)));
        LDRBookBtn.setStyle(DEFAULT_BUTTON_STYLE);
        LDRBookBtn.setOnMouseEntered(e -> LDRBookBtn.setStyle(HOVERED_BUTTON_STYLE));
        LDRBookBtn.setOnMouseExited(e -> LDRBookBtn.setStyle(DEFAULT_BUTTON_STYLE));
        LDRBookBtn.setTranslateY(180);
        LDRBookBtn.setTranslateX(380);
        EventHandler<ActionEvent> LDRBookEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                custName2Lbl.setVisible(true);
                custName2TF.setVisible(true);
                contact2Lbl.setVisible(true);
                contact2TF.setVisible(true);
                gender2CB.setVisible(true);
                gender2Lbl.setVisible(true);

                Hotel.bookroom(1);
                stage.setScene(sceneRoomBooking);
//                ObservableList<string> options =FXCollections.observableArrayList();
                ObservableList<String> options = FXCollections.observableArrayList(LDRNo);
                Iterator<String> it = options.iterator();
                while (it.hasNext()) {
                    String item = it.next();
                    if ("x".equals(item)) {
                        it.remove(); // this is how to do it!
                    }
                }
                roomNoCB.getItems().addAll(options);
                roomNoCB.getSelectionModel().selectFirst();
                myCase=1;
            }


        };
        LDRBookBtn.setOnAction(LDRBookEvent);



        //DDR book button
        Button DDRBookBtn = new Button("Deluxe Double Room");
        DDRBookBtn.setMinWidth(150);
        DDRBookBtn.setMinHeight(40);
        DDRBookBtn.setBackground(Background.fill(Color.rgb(42,54,104)));
        DDRBookBtn.setStyle(DEFAULT_BUTTON_STYLE);
        DDRBookBtn.setOnMouseEntered(e -> DDRBookBtn.setStyle(HOVERED_BUTTON_STYLE));
        DDRBookBtn.setOnMouseExited(e -> DDRBookBtn.setStyle(DEFAULT_BUTTON_STYLE));
        DDRBookBtn.setTranslateY(240);
        DDRBookBtn.setTranslateX(380);
        EventHandler<ActionEvent> DDRBookEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                custName2Lbl.setVisible(true);
                custName2TF.setVisible(true);
                contact2Lbl.setVisible(true);
                contact2TF.setVisible(true);
                gender2CB.setVisible(true);
                gender2Lbl.setVisible(true);
                stage.setScene(sceneRoomBooking);
                Hotel.bookroom(2);
                ObservableList<String> options = FXCollections.observableArrayList(DDRNo);
                Iterator<String> it = options.iterator();
                while (it.hasNext()) {
                    String item = it.next();
                    if ("x".equals(item)) {
                        it.remove(); // this is how to do it!
                    }
                }
                roomNoCB.getItems().addAll(options);
                roomNoCB.getSelectionModel().selectFirst();
                myCase =2;

            }
        };
        DDRBookBtn.setOnAction(DDRBookEvent);



        //LSR book button
        Button LSRBookBtn = new Button("Luxury Single Room");
        LSRBookBtn.setMinWidth(150);
        LSRBookBtn.setMinHeight(40);
        LSRBookBtn.setBackground(Background.fill(Color.rgb(42,54,104)));
        LSRBookBtn.setStyle(DEFAULT_BUTTON_STYLE);
        LSRBookBtn.setOnMouseEntered(e -> LSRBookBtn.setStyle(HOVERED_BUTTON_STYLE));
        LSRBookBtn.setOnMouseExited(e -> LSRBookBtn.setStyle(DEFAULT_BUTTON_STYLE));
        //button hover css https://stackoverflow.com/questions/30680570/javafx-button-border-and-hover
        LSRBookBtn.setTranslateY(300);
        LSRBookBtn.setTranslateX(380);
        EventHandler<ActionEvent> LSRBookEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(sceneRoomBooking);
                Hotel.bookroom(3);
                ObservableList<String> options = FXCollections.observableArrayList(LSRNo);
                Iterator<String> it = options.iterator();
                while (it.hasNext()) {
                    String item = it.next();
                    if ("x".equals(item)) {
                        it.remove(); // this is how to do it!
                    }
                }
                roomNoCB.getItems().addAll(options);
                roomNoCB.getSelectionModel().selectFirst();
                myCase=3;
                custName2Lbl.setVisible(false);
                custName2TF.setVisible(false);
                contact2Lbl.setVisible(false);
                contact2TF.setVisible(false);
                gender2CB.setVisible(false);
                gender2Lbl.setVisible(false);
            }
        };
        LSRBookBtn.setOnAction(LSRBookEvent);



        //DSR book button
        Button DSRBookBtn = new Button("Deluxe Single Room");
        DSRBookBtn.setMinWidth(150);
        DSRBookBtn.setMinHeight(40);
        DSRBookBtn.setBackground(Background.fill(Color.rgb(42,54,104)));
        DSRBookBtn.setStyle(DEFAULT_BUTTON_STYLE);
        DSRBookBtn.setOnMouseEntered(e -> DSRBookBtn.setStyle(HOVERED_BUTTON_STYLE));
        DSRBookBtn.setOnMouseExited(e -> DSRBookBtn.setStyle(DEFAULT_BUTTON_STYLE));
        //button hover css https://stackoverflow.com/questions/30680570/javafx-button-border-and-hover
        DSRBookBtn.setTranslateY(360);
        DSRBookBtn.setTranslateX(380);
        EventHandler<ActionEvent> DSRBookEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(sceneRoomBooking);
                Hotel.bookroom(4);
                ObservableList<String> options = FXCollections.observableArrayList(DSRNo);
                Iterator<String> it = options.iterator();
                while (it.hasNext()) {
                    String item = it.next();
                    if ("x".equals(item)) {
                        it.remove(); // this is how to do it!
                    }
                }
                roomNoCB.getItems().addAll(options);
                roomNoCB.getSelectionModel().selectFirst();
                myCase=4;
                custName2Lbl.setVisible(false);
                custName2TF.setVisible(false);
                contact2Lbl.setVisible(false);
                contact2TF.setVisible(false);
                gender2CB.setVisible(false);
                gender2Lbl.setVisible(false);
            }
        };
        DSRBookBtn.setOnAction(DSRBookEvent);


        /**
        book room title label
         */
        Label titleLbls5 = new Label("Book Room");
        titleLbls5.setTranslateX(300);
        titleLbls5.setTranslateY(70);
        titleLbls5.setBackground(Background.fill(Color.rgb(42,54,104)));
        titleLbls5.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 25));
        titleLbls5.setTextFill(Color.WHITE);
        titleLbls5.setMinHeight(50);
        titleLbls5.setMinWidth(310);
        titleLbls5.setAlignment(Pos.CENTER);

        rootRoomBookMenu.getChildren().add(DSRBookBtn);
        rootRoomBookMenu.getChildren().add(LSRBookBtn);
        rootRoomBookMenu.getChildren().add(DDRBookBtn);
        rootRoomBookMenu.getChildren().add(LDRBookBtn);
        rootRoomBookMenu.getChildren().add(titleLbls5);



        // Title label
        Label billLbl = new Label("Bill");
        billLbl.setTranslateX(380);
        billLbl.setTranslateY(110);
        billLbl.setBackground(Background.fill(Color.rgb(42,54,104)));
        billLbl.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 25));
        billLbl.setTextFill(Color.WHITE);
        billLbl.setMinHeight(50);
        billLbl.setMinWidth(130);
        billLbl.setAlignment(Pos.CENTER);

        Label finalCustName = new Label("Customer Name");
        finalCustName.setTranslateX(245);
        finalCustName.setTranslateY(190);
        finalCustName.setBackground(Background.fill(Color.DARKSLATEBLUE));
        finalCustName.setFont(Font.font("Helvetica", 15));
        finalCustName.setTextFill(Color.WHITE);
        finalCustName.setMinHeight(30);
        finalCustName.setMinWidth(200);
        finalCustName.setAlignment(Pos.CENTER);

        // bed labelB
        Label finalCustNameB = new Label();
        finalCustNameB.setTranslateX(450);
        finalCustNameB.setTranslateY(190);
        finalCustNameB.setBackground(Background.fill(Color.WHITE));
        finalCustNameB.setFont(Font.font("Helvetica", 15));
        finalCustNameB.setTextFill(Color.BLACK);
        finalCustNameB.setMinHeight(30);
        finalCustNameB.setMinWidth(200);
        finalCustNameB.setAlignment(Pos.CENTER);


        Label finalCharges = new Label("Charges");
        finalCharges.setTranslateX(245);
        finalCharges.setTranslateY(250);
        finalCharges.setBackground(Background.fill(Color.DARKSLATEBLUE));
        finalCharges.setFont(Font.font("Helvetica", 15));
        finalCharges.setTextFill(Color.WHITE);
        finalCharges.setMinHeight(30);
        finalCharges.setMinWidth(200);
        finalCharges.setAlignment(Pos.CENTER);

        // bed labelB
        Label finalChargesB = new Label();
        finalChargesB.setTranslateX(450);
        finalChargesB.setTranslateY(250);
        finalChargesB.setBackground(Background.fill(Color.WHITE));
        finalChargesB.setFont(Font.font("Helvetica", 15));
        finalChargesB.setTextFill(Color.BLACK);
        finalChargesB.setMinHeight(30);
        finalChargesB.setMinWidth(200);
        finalChargesB.setAlignment(Pos.CENTER);

        Label dealocatedSuccess = new Label("Deallocated Successfully ");
        dealocatedSuccess.setTranslateX(350);
        dealocatedSuccess.setTranslateY(350);
        dealocatedSuccess.setBackground(Background.fill(Color.DARKSLATEBLUE));
        dealocatedSuccess.setFont(Font.font("Helvetica", 15));
        dealocatedSuccess.setTextFill(Color.WHITE);
        dealocatedSuccess.setMinHeight(30);
        dealocatedSuccess.setMinWidth(200);
        dealocatedSuccess.setAlignment(Pos.CENTER);


        rootBill.getChildren().add(billLbl);
        rootBill.getChildren().add(finalCustName);
        rootBill.getChildren().add(finalCustNameB);
        rootBill.getChildren().add(finalCharges);
        rootBill.getChildren().add(finalChargesB);
        rootBill.getChildren().add(dealocatedSuccess);



//        checkout pre
        //Title label
        Label titleLbls7 = new Label("Checkout");
        titleLbls7.setTranslateX(300);
        titleLbls7.setTranslateY(100);
        titleLbls7.setBackground(Background.fill(Color.rgb(42,54,104)));
        titleLbls7.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 25));
        titleLbls7.setTextFill(Color.WHITE);
        titleLbls7.setMinHeight(50);
        titleLbls7.setMinWidth(310);
        titleLbls7.setAlignment(Pos.CENTER);


        //Enter room no Label
        Label checkoutRN = new Label("Please Enter Room No");
        checkoutRN.setTranslateX(350);
        checkoutRN.setTranslateY(210);
        checkoutRN.setBackground(Background.fill(Color.rgb(42,54,104)));
        checkoutRN.setFont(Font.font("Helvetica", 15));
        checkoutRN.setTextFill(Color.WHITE);
        checkoutRN.setMinHeight(30);
        checkoutRN.setMinWidth(200);
        checkoutRN.setAlignment(Pos.CENTER);


        TextField checkoutTF = new TextField();
        checkoutTF.setTranslateX(370);
        checkoutTF.setTranslateY(250);





        //
        Label usedByLbl = new Label("Room Used by");
        usedByLbl.setTranslateX(230);
        usedByLbl.setTranslateY(350);
        usedByLbl.setBackground(Background.fill(Color.DARKSLATEBLUE));
        usedByLbl.setFont(Font.font("Helvetica", 15));
        usedByLbl.setTextFill(Color.WHITE);
        usedByLbl.setMinHeight(30);
        usedByLbl.setMinWidth(200);
        usedByLbl.setAlignment(Pos.CENTER);




        // breakfast labelB
        Label usedByLblB = new Label(String.valueOf(DSRAvailable));
        usedByLblB.setTranslateX(450);
        usedByLblB.setTranslateY(350);
        usedByLblB.setBackground(Background.fill(Color.WHITE));
        usedByLblB.setFont(Font.font("Helvetica", 15));
        usedByLblB.setTextFill(Color.BLACK);
        usedByLblB.setMinHeight(30);
        usedByLblB.setMinWidth(200);
        usedByLblB.setAlignment(Pos.CENTER);

        //Invalid label
        Label emptyLbl = new Label("Room Already Empty");
        emptyLbl.setTranslateX(350);
        emptyLbl.setTranslateY(370);
        emptyLbl.setBackground(Background.fill(Color.ORANGERED));
        emptyLbl.setFont(Font.font("Helvetica", 15));
        emptyLbl.setTextFill(Color.WHITE);
        emptyLbl.setMinHeight(30);
        emptyLbl.setMinWidth(180);
        emptyLbl.setAlignment(Pos.CENTER);
        emptyLbl.setVisible(false);




/**
checkout button
 */
        Button finalCheckoutBTN = new Button("checkout");
       finalCheckoutBTN.setTranslateX(390);
       finalCheckoutBTN.setTranslateY(400);
       finalCheckoutBTN.setMinWidth(100);
       finalCheckoutBTN.setMinHeight(30);
       finalCheckoutBTN.setFont(Font.font("Helvetica", 15));
       finalCheckoutBTN.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
        EventHandler<ActionEvent> finalCheckoutEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                toCancel=false;
                letsCheckout=true;
                if(Integer.parseInt(checkoutTF.getText())<11){
                    rtype=1;
                } else if (Integer.parseInt(checkoutTF.getText())<31) {
                    rtype=2;
                }else if (Integer.parseInt(checkoutTF.getText())<41) {
                    rtype=3;
                } else {
                    rtype=4;
                }
                Hotel.deallocate(Integer.parseInt(checkoutTF.getText()),rtype);
                stage.setScene(sceneBill);
                finalCustNameB.setText(usedBy);
                finalChargesB.setText(roomBill);

            }

        };
       finalCheckoutBTN.setOnAction(finalCheckoutEvent);

       /**
       proceed button
        */
        Button proceedCheckoutBTN = new Button("Proceed");
        proceedCheckoutBTN.setTranslateX(390);
        proceedCheckoutBTN.setTranslateY(300);
        proceedCheckoutBTN.setMinWidth(100);
        proceedCheckoutBTN.setMinHeight(30);
        proceedCheckoutBTN.setFont(Font.font("Helvetica", 15));
        proceedCheckoutBTN.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
        EventHandler<ActionEvent> proceedEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(Integer.parseInt(checkoutTF.getText())<11){
                    rtype=1;
                } else if (Integer.parseInt(checkoutTF.getText())<31) {
                    rtype=2;
                }else if (Integer.parseInt(checkoutTF.getText())<41) {
                    rtype=3;
                } else {
                    rtype=4;
                }
                Hotel.deallocate((Integer.parseInt(checkoutTF.getText())-1),rtype);
                if(!usedBy.isEmpty()){
                    usedByLblB.setText(usedBy);
                    emptyLbl.setVisible(false);
                    finalCheckoutBTN.setVisible(true);
                    usedByLbl.setVisible(true);
                    usedByLblB.setVisible(true);
                    if(dict.containsValue(usedBy)){
                        for (Map.Entry<String, String> emp : dict.entrySet()) {
                            if (emp.getValue().equals(usedBy)) {
                                String id=emp.getKey();
                                dict.remove(id);
                                break;
                            }
                        }
                    }
                }
                else {
                    emptyLbl.setVisible(true);
                    finalCheckoutBTN.setVisible(false);
                    usedByLbl.setVisible(false);
                    usedByLblB.setVisible(false);
                }
            }

        };
        proceedCheckoutBTN.setOnAction(proceedEvent);


        /**
        adding childern to rootRoomCheckoutPre
         */
        rootRoomCheckoutPre.getChildren().add(titleLbls7);
        rootRoomCheckoutPre.getChildren().add(checkoutRN);
        rootRoomCheckoutPre.getChildren().add(checkoutTF);
        rootRoomCheckoutPre.getChildren().add(proceedCheckoutBTN);
        rootRoomCheckoutPre.getChildren().add(usedByLbl);
        rootRoomCheckoutPre.getChildren().add(usedByLblB);
        rootRoomCheckoutPre.getChildren().add(emptyLbl);
        rootRoomCheckoutPre.getChildren().add(finalCheckoutBTN);


//booked label
        Label bookedLbl = new Label("Room Booked");
        bookedLbl.setTranslateX(300);
        bookedLbl.setTranslateY(100);
        bookedLbl.setBackground(Background.fill(Color.rgb(42,54,104)));
        bookedLbl.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 25));
        bookedLbl.setTextFill(Color.WHITE);
        bookedLbl.setMinHeight(50);
        bookedLbl.setMinWidth(310);
        bookedLbl.setAlignment(Pos.CENTER);

        Button menuBtn = new Button("Main Menu");
        menuBtn.setMinWidth(150);
        menuBtn.setMinHeight(40);
        menuBtn.setBackground(Background.fill(Color.rgb(42,54,104)));
        menuBtn.setStyle(DEFAULT_BUTTON_STYLE);
        menuBtn.setOnMouseEntered(e -> menuBtn.setStyle(HOVERED_BUTTON_STYLE));
        menuBtn.setOnMouseExited(e -> menuBtn.setStyle(DEFAULT_BUTTON_STYLE));
        //button hover css https://stackoverflow.com/questions/30680570/javafx-button-border-and-hover
        menuBtn.setTranslateY(240);
        menuBtn.setTranslateX(380);
        EventHandler<ActionEvent> mainBtnEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(scene1);
            }

        };
        menuBtn.setOnAction(switchToMain);

        rootRoomBooked.getChildren().add(bookedLbl);
        rootRoomBooked.getChildren().add(menuBtn);

        /**
         * root Booking cancel
         */
        /***
         Title label for Room details window
         */
        Label cancelBookingTitle = new Label("Cancel Booking");
        cancelBookingTitle.setTranslateX(300);
        cancelBookingTitle.setTranslateY(70);
        cancelBookingTitle.setBackground(Background.fill(Color.rgb(42,54,104)));
        cancelBookingTitle.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 25));
        cancelBookingTitle.setTextFill(Color.WHITE);
        cancelBookingTitle.setMinHeight(50);
        cancelBookingTitle.setMinWidth(310);
        cancelBookingTitle.setAlignment(Pos.CENTER);
        rootRoomCancel.getChildren().add(cancelBookingTitle);

//        /**
//         * Table
//         */
//
//        // use fully detailed type for Map.Entry<String, String>
//        TableColumn<Map.Entry<String, String>, String> column1 = new TableColumn<>("Customer ID");
//        column1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {
//
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
//                // this callback returns property for just one cell, you can't use a loop here
//                // for first column we use key
//                return new SimpleStringProperty(p.getValue().getKey());
//            }
//        });
//
//        TableColumn<Map.Entry<String, String>, String> column2 = new TableColumn<>("Name");
//        column2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {
//
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
//                // for second column we use value
//                return new SimpleStringProperty(p.getValue().getValue());
//            }
//        });
//
//        ObservableList<Map.Entry<String, String>> items = FXCollections.observableArrayList(dict.entrySet());
//        final TableView<Map.Entry<String,String>> table = new TableView<>(items);
//
//        table.getColumns().setAll(column1, column2);
////        table.setBackground(Color.DEEPSKYBLUE);
//        table.setTranslateX(250);
//        table.setTranslateY(150);
//        column1.setStyle("-fx-background-color: Black");
//        column1.setStyle("-fx-border-color: red");
//        column1.setStyle("-fx-table-cell-border-color:white;");
//        column1.setMinWidth(120);
//        column2.setMinWidth(280);
//        table.setMaxHeight(300);;
//        table.setId("tablex");


        /**
         customer id text field
         */
        TextField custIdTF = new TextField();
        custIdTF.setTranslateX(500);
        custIdTF.setTranslateY(460);

        /***
         Enter customer Id Label
         */
        Label idLbl = new Label("Enter customer Id");
        idLbl.setTranslateX(260);
        idLbl.setTranslateY(460);
        idLbl.setBackground(Background.fill(Color.rgb(42,54,104)));
        idLbl.setFont(Font.font("Helvetica", 15));
        idLbl.setTextFill(Color.WHITE);
        idLbl.setMinHeight(30);
        idLbl.setMinWidth(200);
        idLbl.setAlignment(Pos.CENTER);

        rootRoomCancel.getChildren().add(custIdTF);
        rootRoomCancel.getChildren().add(idLbl);



        Label dealocatedSuccess2 = new Label("Deallocated Successfully ");
        dealocatedSuccess2.setTranslateX(350);
        dealocatedSuccess2.setTranslateY(350);
        dealocatedSuccess2.setBackground(Background.fill(Color.DARKSLATEBLUE));
        dealocatedSuccess2.setFont(Font.font("Helvetica", 15));
        dealocatedSuccess2.setTextFill(Color.WHITE);
        dealocatedSuccess2.setMinHeight(30);
        dealocatedSuccess2.setMinWidth(200);
        dealocatedSuccess2.setAlignment(Pos.CENTER);

        /***
         Title label for Room details window
         */
        Label cancelBookingTitle2 = new Label("Cancel Booking");
        cancelBookingTitle2.setTranslateX(300);
        cancelBookingTitle2.setTranslateY(70);
        cancelBookingTitle2.setBackground(Background.fill(Color.rgb(42,54,104)));
        cancelBookingTitle2.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 25));
        cancelBookingTitle2.setTextFill(Color.WHITE);
        cancelBookingTitle2.setMinHeight(50);
        cancelBookingTitle2.setMinWidth(310);
        cancelBookingTitle2.setAlignment(Pos.CENTER);



        rootRoomCanceledSuccess.getChildren().add(cancelBookingTitle2);
        rootRoomCanceledSuccess.getChildren().add(dealocatedSuccess2);
        rootRoomCanceledSuccess.getChildren().add(mainBtn11);

        /**
         cancel booking final button
         */
        Button cancelBookingFinalBtn = new Button("Cancel Booking");
        cancelBookingFinalBtn.setTranslateX(405);
        cancelBookingFinalBtn.setTranslateY(500);
        cancelBookingFinalBtn.setMinWidth(100);
        cancelBookingFinalBtn.setMinHeight(30);
        cancelBookingFinalBtn.setFont(Font.font("Helvetica", 15));
        cancelBookingFinalBtn.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
        EventHandler<ActionEvent> cancelBookingFinalEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                toCancel = true;
                if (dict.containsKey(custIdTF.getText())) {
                    String customerName = dict.get(custIdTF.getText());
                    for (int i = 0; i < 9; i++) {
                        if (Hotel.hotel_ob.luxury_doublerrom[i] != null && Hotel.hotel_ob.luxury_doublerrom[i].name == customerName) {
                            roomNum = i;
                            rtype = 1;
                        } else if (Hotel.hotel_ob.luxury_singleerrom[i] != null && Hotel.hotel_ob.luxury_singleerrom[i].name == customerName) {
                            roomNum = i + 31;
                            rtype = 3;
                        }
                    }
                    for (int i = 0; i < 19; i++) {
                        if (Hotel.hotel_ob.deluxe_doublerrom[i] != null && Hotel.hotel_ob.deluxe_doublerrom[i].name == customerName) {
                            roomNum = i + 11;
                            rtype = 2;
                        } else if (Hotel.hotel_ob.deluxe_singleerrom[i] != null && Hotel.hotel_ob.deluxe_singleerrom[i].name == customerName) {
                            roomNum = i + 41;
                            rtype = 4;
                        }
                    }
                    Hotel.deallocate(roomNum, rtype);
                    dict.remove(custIdTF.getText());
                    System.out.println("printing finsl Dictionary");
                    System.out.println(dict);
                    stage.setScene(sceneRoomCanceledSuccess);

                }
            }
        };




        cancelBookingFinalBtn.setOnAction(cancelBookingFinalEvent);
        rootRoomCancel.getChildren().add(cancelBookingFinalBtn);
        rootRoomCancel.getChildren().add(mainBtn10);




        /**
        setting first scene on stage
         */
        stage.setScene(scene1);
        stage.show();

    }


    public static void main(String args[]){
        launch(args);
    }
}
