import java.time.LocalTime;

final public class Meeting extends Event {

    private PriorityValues priority;

    public enum PriorityValues {
        LOW, MEDIUM, HIGH
    }

    public Meeting(String priority, String description, LocalTime startTime, LocalTime endTime) {
        super(startTime, endTime, description);
        this.priority = PriorityValues.valueOf(priority);
    }

    public PriorityValues getPriority() {
        return this.priority;
    }

    public String toString() {
        return (this.description + " " + this.startTime + "-" + this.endTime + " Priorytet: " + this.priority);
    }

}
