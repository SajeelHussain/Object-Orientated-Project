//Osamah Alsumaitti
package src;

/**
 * Person class contains the attributes of name, contact, and gender. It is further extended by guest and employee to add booking id and login pin
 */
public class Person {

    private String name;
    private String contact;
    private String gender;

    /**
     * Constructors
     */
    Person() {

    }
    Person(String name) {
        setName(name);
    }

    /**
     * Getters and Setters
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
