//Osamah Alsumaitti
package src;


import java.util.*;

/**
 * This is the most important class of the program. Whenever a menu is selected from main class, the relevent function is called from this class
 * It consists of various functions like CustDetails, checkAvailibility, bookRoom or checkOut etc.
 */

class Hotel {
    /**
     * This class uses mostly uses static attributes and functions
     */
    public static holder hotel_ob = new holder();
    static Scanner sc = new Scanner(System.in);

    /**
    * CustDetails generates the customer details.
    * It takes the input from the user and passes to the constructor.
     */

    public static String name, contact, gender;
    public static String name2 = null, contact2 = null;
    public static String gender2 = "";
    Dictionary dict = new Hashtable();
    static int id = 110;

    public static void CustDetails(int i, int rn) {
        /**
         * Based on user's selection, now room category will be selected and relevent constructor will be used.
         */
        switch (i) {
            case 1:
                hotel_ob.luxury_doublerrom[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
                break;
            case 2:
                hotel_ob.deluxe_doublerrom[rn-11] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
                break;
            case 3:
                System.out.println("Hi here");
                hotel_ob.luxury_singleerrom[rn-31] = new Singleroom(name, contact, gender);
                break;
            case 4:
                hotel_ob.deluxe_singleerrom[rn-41] = new Singleroom(name, contact, gender);
                break;
            default:
                System.out.println("Wrong option");
                break;
        }
    }

    /**
     *
     * @param i
     *
     * The following function books a room for the guest. I takes a parameter which is actually the type of room
     */
    public static int rn;
    static void bookroom(int i) {
        int j;
        int rn=0;
        for (int k = 0; k < 9; k++) {
            Arrays.fill(Frontend.LDRNo,"x");
        }
        System.out.println("\nChoose room number from : ");
        switch (i) {
            case 1:
                for (j = 0; j < hotel_ob.luxury_doublerrom.length; j++) {
                    if (hotel_ob.luxury_doublerrom[j] == null) {
                        System.out.print(j + 1 + ",");
                        Frontend.LDRNo[j]= String.valueOf(j+1);
                        for (String element: Frontend.LDRNo) {
                            System.out.println(element);
                        }
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    rn--;
                    if (hotel_ob.luxury_doublerrom[rn] != null) {
                        System.out.println("Heyaaaaa"+rn);
                        /**
                         * If room is not available, NotAvailable class will throw its exception
                         */
                        throw new NotAvailable();
                        /**
                         * If room is available, CustDetails will save user details
                         */
//                    CustDetails(i, rn);
                    }
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 2:
                for (j = 0; j < hotel_ob.deluxe_doublerrom.length; j++) {
                    System.out.println("Hi");
                    if (hotel_ob.deluxe_doublerrom[j] == null) {
                        System.out.println("Hello");
                        System.out.print(j + 11 + ",");
                        Frontend.DDRNo[j]=String.valueOf(j+11);
                    }
                    for (String element: Frontend.DDRNo) {
                        System.out.println(element);
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    rn = rn - 11;
                    if (hotel_ob.deluxe_doublerrom[rn] != null)
                        throw new NotAvailable();
//                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 3:
                for (j = 0; j < hotel_ob.luxury_singleerrom.length; j++) {
                    if (hotel_ob.luxury_singleerrom[j] == null) {
                        System.out.print(j + 31 + ",");
                        Frontend.LSRNo[j]=String.valueOf(j+31);
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    rn = rn - 31;
                    if (hotel_ob.luxury_singleerrom[rn] != null)
                        throw new NotAvailable();
//                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 4:
                for (j = 0; j < hotel_ob.deluxe_singleerrom.length; j++) {
                    if (hotel_ob.deluxe_singleerrom[j] == null) {
                        System.out.print(j + 41 + ",");
                        Frontend.DSRNo[j]= String.valueOf(j+41);
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    rn = rn - 41;
                    if (hotel_ob.deluxe_singleerrom[rn] != null)
                        throw new NotAvailable();
//                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Room Booked");
    }

    /**
     *
     * @param i
     * features function displays the details of room like does it have AC and how much to charge on each room per day
     */
    static void features(int i) {
        switch (i) {
            case 1:
                Frontend.bedType = "Double";
                Frontend.NumberOfBeds = "1";
                Frontend.ac = "Yes";
                Frontend.breakfast = "Yes";
                Frontend.charges=4000;
                System.out.println("Number of double beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:4000 ");
                break;
            case 2:
                Frontend.bedType = "Double";
                Frontend.NumberOfBeds = "1";
                Frontend.ac = "NO";
                Frontend.breakfast = "Yes";
                Frontend.charges=3000;
                System.out.println("Number of double beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:3000  ");
                break;
            case 3:
                Frontend.bedType = "Single";
                Frontend.NumberOfBeds = "1";
                Frontend.ac = "Yes";
                Frontend.breakfast = "Yes";
                Frontend.charges=2200;
                System.out.println("Number of single beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:2200  ");
                break;
            case 4:
                Frontend.bedType = "Single";
                Frontend.NumberOfBeds = "1";
                Frontend.ac = "NO";
                Frontend.breakfast = "Yes";
                Frontend.charges=1200;
                System.out.println("Number of single beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:1200 ");
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
    }

    /**
     *
     * @param i
     * availability checks if a room is available for booking or not
     */
    static void availability() {
        int j, count = 0;
        Frontend.LSRAvailable=0;
        Frontend.LDRAvailable=0;
        Frontend.DDRAvailable=0;
        Frontend.DSRAvailable=0;
                for (j = 0; j < 10; j++) {
                    if (hotel_ob.luxury_doublerrom[j] == null)
                        Frontend.LDRAvailable++;
                }
                for (j = 0; j < hotel_ob.deluxe_doublerrom.length; j++) {
                    if (hotel_ob.deluxe_doublerrom[j] == null)
                        Frontend.DDRAvailable++;
                }

                for (j = 0; j < hotel_ob.luxury_singleerrom.length; j++) {
                    if (hotel_ob.luxury_singleerrom[j] == null)
                        Frontend.LSRAvailable++;
                }
                for (j = 0; j < hotel_ob.deluxe_singleerrom.length; j++) {
                    if (hotel_ob.deluxe_singleerrom[j] == null)
                        Frontend.DSRAvailable++;
                }
    }

    /**
     *
     * @param rn
     * @param rtype
     * It takes room number and room type from the caller and generates the bill on that basis when guest wants to checkout.
     */
    static void bill(int rn, int rtype) {
        double amount = 0;
        String list[] = {"Sandwich", "Pasta", "Noodles", "Coke"};
        System.out.println("\n*******");
        System.out.println(" Bill:-");
        System.out.println("*******");

        switch (rtype) {
            case 1:
                amount += 4000;
                System.out.println("\nRoom Charge - " + 4000);
                System.out.println("\n===============");



                break;
            case 2:
                amount += 3000;
                System.out.println("Room Charge - " + 3000);

                break;
            case 3:
                amount += 2200;
                System.out.println("Room Charge - " + 2200);
                break;
            case 4:
                amount += 1200;
                System.out.println("Room Charge - " + 1200);


                break;
            default:
                System.out.println("Not valid");
        }
        System.out.println("\nTotal Amount- " + amount);
        Frontend.roomBill=String.valueOf(amount);
    }

    /**
     * It takes room number and room type and makes room empty when guest checksout
     * @param rn
     * @param rtype
     */
    static void deallocate(int rn, int rtype) {
        int j;
        char w;
        switch (rtype) {
            case 1:
                if(Frontend.letsCheckout==false) {
                    System.out.println("Hi here");
                    if (hotel_ob.luxury_doublerrom[rn] != null) {
                        Frontend.usedBy = hotel_ob.luxury_doublerrom[rn].name;
                        System.out.println("Room used by " + hotel_ob.luxury_doublerrom[rn].name);
                    } else {
                        Frontend.usedBy = "";
                        System.out.println("Empty Already");
                        return;
                    }
                }
                else if(Frontend.letsCheckout==true) {
                    if (!Frontend.toCancel)
                        bill(rn, rtype);
                    hotel_ob.luxury_doublerrom[rn] = null;
                    System.out.println("Deallocated succesfully");
                }

                break;
            case 2:
                if(Frontend.letsCheckout==false) {
                    if (hotel_ob.deluxe_doublerrom[rn-11] != null) {
                        Frontend.usedBy = hotel_ob.deluxe_doublerrom[rn-11].name;
                        System.out.println("Room used by " + hotel_ob.deluxe_doublerrom[rn-11].name);
                    } else {
                        Frontend.usedBy = "";
                        System.out.println("Empty Already");
                        return;
                    }
                }

                else if(Frontend.letsCheckout==true) {
                    if (!Frontend.toCancel)
                        bill(rn, rtype);
                    hotel_ob.deluxe_doublerrom[rn-11] = null;
                    System.out.println("Deallocated succesfully");
                }

                break;
            case 3:
                if(Frontend.letsCheckout==false) {
                    if (hotel_ob.luxury_singleerrom[rn-31] != null){
                        Frontend.usedBy= hotel_ob.luxury_singleerrom[rn-31].name;
                        System.out.println("Room used by " + hotel_ob.luxury_singleerrom[rn-31].name);
                    }
                    else {
                        Frontend.usedBy = "";
                        System.out.println("Empty Already");
                        return;
                    }
                }
                else if(Frontend.letsCheckout==true) {
                    if (!Frontend.toCancel)
                        bill(rn, rtype);
                    hotel_ob.luxury_singleerrom[rn-31] = null;
                    System.out.println("Deallocated succesfully");
                }

                break;
            case 4:
                if(Frontend.letsCheckout==false) {
                    if (hotel_ob.deluxe_singleerrom[rn - 41] != null) {
                        Frontend.usedBy=hotel_ob.deluxe_singleerrom[rn - 41].name;
                        System.out.println("Room used by " + hotel_ob.deluxe_singleerrom[rn - 41].name);

                    } else {
                        Frontend.usedBy = "";
                        System.out.println("Empty Already");
                        return;
                    }
                }

                else if(Frontend.letsCheckout==true) {
                    if (!Frontend.toCancel)
                        bill(rn, rtype);
                    hotel_ob.deluxe_singleerrom[rn-41] = null;
                    System.out.println("Deallocated succesfully");
                }
                break;
            default:
                System.out.println("\nEnter valid option : ");
                break;
        }
    }

}

