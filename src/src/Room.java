//Osamah Alsumaitti
package src;

/**
 * Room class consists of attributes of room like room no., floor, area, rate, type etc.
 */
public class Room {
    private int number;
    private String floor;
    private String section;
    private double area;
    private double rate;
    private RoomType type;

    /**constructor
     *
     */
    public Room(){}

    Guest guest = new Guest();


    public Room(int id, String name, String contact, String gender, int number, String floor, double area, double rate, RoomType type) {
        this.number = number;
        this.floor = floor;
        this.area = area;
        this.rate = rate;
        this.type = type;
    }

    /**
     * Getters and setters
     * @param number
     */
    public Room(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }


}
