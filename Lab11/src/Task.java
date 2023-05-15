import java.time.LocalTime;

final public class Task extends Event {
    private StatusValues status;

    public enum StatusValues {
        PLANNED, CONFIRMED, IN_PROGRESS, FINISHED
    }

    public Task(String status, LocalTime startTime, LocalTime endTime, String description) {
        super(startTime, endTime, description);
        this.status = StatusValues.valueOf(status);
    }


    public StatusValues getStatus() {
        return this.status;
    }

    public String toString() {
        return (this.description + " " + this.startTime + "-" + this.endTime + " Status: " + this.status);
    }


}
