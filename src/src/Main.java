//Osamah Alsumaitti
package src;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;



/**
 * Main class of the program
 * It consists of a main function and in the main function the switch case statement is used which is used to implement the menu.
 */
public class Main {
    public static int ch, ch2;

    public static void main(String[] args){

        try {
            File f = new File("backup");
            if (f.exists()) {
                FileInputStream fin = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fin);
                Hotel.hotel_ob = (holder) ois.readObject();
            }
            /**
            *Scanner is used to take input from the user
             */
            Scanner sc = new Scanner(System.in);
            char wish;

            /**
             * the login pin is 123 it is necessary for the staff to login before adding or checking out a guest
             */

            int pin = 123;
            int login;
            do {
                System.out.println("Welcome Dear Staff Member\nEnter your pin to login to the system\n");
                login = sc.nextInt();
                login = 123;
            } while(login != pin);
            if (login == pin) {
                x:
                do {

                    System.out.println("\nEnter your choice :\n1.Display room details\n2.Display room availability \n3.Book\n4.Checkout\n5.Exit\n");
                    ch = sc.nextInt();
                    switch (ch) {
                        /**
                         * If user selects to display room details, he/she will be asked to select room type
                         */
                        case 1:
                            System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room \n4.Deluxe Single Room\n");
                            ch2 = sc.nextInt();
                            Hotel.features(ch2);
                            break;
                        case 2:
                            System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                            ch2 = sc.nextInt();
                            Hotel.availability();
                            break;
                        case 3:
                            System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                            ch2 = sc.nextInt();
                            Hotel.bookroom(ch2);
                            break;
                        case 4:
                            /**
                             * If user wants to checkout, he/she will be asked to enter room no.
                             */
                            System.out.print("Room Number -");
                            ch2 = sc.nextInt();
                            if (ch2 > 60)
                                System.out.println("Room doesn't exist");
                            else if (ch2 > 40)
                                Hotel.deallocate(ch2 - 41, 4);
                            else if (ch2 > 30)
                                Hotel.deallocate(ch2 - 31, 3);
                            else if (ch2 > 10)
                                Hotel.deallocate(ch2 - 11, 2);
                            else if (ch2 > 0)
                                Hotel.deallocate(ch2 - 1, 1);
                            else
                                System.out.println("Room doesn't exist");
                            break;
                        case 5:
                            break x;

                    }

                    /**
                     * After selecting any menu option and completing that operation, the user will be asked continue or not
                     * Based on that selection, he/she will be redirected to main menu or program will be closed.
                     */
                    System.out.println("\nContinue : (y/n)");
                    wish = sc.next().charAt(0);
                    if (!(wish == 'y' || wish == 'Y' || wish == 'n' || wish == 'N')) {
                        System.out.println("Invalid Option");
                        System.out.println("\nContinue : (y/n)");
                        wish = sc.next().charAt(0);
                    }

                } while (wish == 'y' || wish == 'Y');


            }
        }
        /**
         * If main function throws any exception like giving an invalid input, exception will be handled.
         */
        catch(Exception e)
        {
            System.out.println("Invalid Input");
        }
    }
}
