
//Osamah Alsumaitti
package src;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Booking class implements Serializable and stores the details of booking like start time, end time, room, action type etc.
 */
public class Booking implements  Serializable{
    private Guest guest;
    private Room room;
    private LocalDateTime start;
    private LocalDateTime end;
    private BookingStatus status;
    private ActionType actions;

    /**
     * These are overloaded constructors.
     */
    public Booking(){}
    public Booking(Guest guest, Room room, LocalDateTime start, LocalDateTime end, BookingStatus status, ActionType actions) {
        this.guest = guest;
        this.room = room;
        this.start = start;
        this.end = end;
        this.status = status;
        this.actions = actions;
    }

    /**
     * The following are getters and setters of this class
     * @return
     */
    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public ActionType getActions() {
        return actions;
    }

    public void setActions(ActionType actions) {
        this.actions = actions;
    }


}
