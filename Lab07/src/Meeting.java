import java.time.LocalTime;

public class Meeting {
    public static final LocalTime MIN_MEETING_TIME = LocalTime.of(8,30);

    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private PriorityValues priority;

    public enum PriorityValues {
        LOW, MEDIUM, HIGH
    }


    public Meeting(String desc, LocalTime start, LocalTime end, String priority){
        this.description = desc;
        this.startTime = start;
        this.endTime = end;
        this.priority = PriorityValues.valueOf(priority);
    }

    public PriorityValues getPriority() {
        return this.priority;
    }

    public String toString(){
        return (this.description + " " + this.startTime + "-" + this.endTime + " Priorytet: " + this.priority);
    }

}
