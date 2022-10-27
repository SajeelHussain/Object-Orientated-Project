//Osamah Alsumaitti
package src;

/**
 * Employee class extends person and have attributes of name, contact, gender and a login pin
 */

public class Employee extends Person {
    private String pin;

    Employee(String pin) {
        setPin(pin);
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
