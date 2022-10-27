//Osamah Alsumaitti
package src;

import java.util.Scanner;

/**
 * Guest class extends person and contains the attributes of name, contact, gender and a booking id
 */
public class Guest extends Person {


    private int id;


    public Guest() {
    }

    Booking booking = new Booking();

    /**
     * The folowing are overloaded constructors.
     * @param id
     * @param name
     * @param contact
     * @param gender
     */
    public Guest(int id, String name, String contact, String gender) {
        setId(id);
        setName(name);
        setContact(contact);
        setGender(gender);
    }



    Guest(int id) {
        setId(id);
    }

    /**
     * Getters and setters
     * @return
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void guestDetails(int i, int rn) {
        Guest guest = new Guest();
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter customer name: ");
        guest.setName(sc.next());
        System.out.println("\nEnter customer contact: ");
        guest.setContact(sc.next());
        System.out.println("\nEnter customer gender: ");
        guest.setGender(sc.next());
        guest.setId(123);

    }
}