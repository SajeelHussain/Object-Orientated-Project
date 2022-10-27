//Osamah Alsumaitti

package src;

import java.time.LocalDateTime;

/**
 * Action class can add or remove an employee with time stamps.
 */
public class Action {
    private Employee employee;
    private ActionType type;
    private LocalDateTime timeStamp;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
