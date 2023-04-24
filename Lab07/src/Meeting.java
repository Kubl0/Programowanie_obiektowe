import java.time.LocalTime;

public class Meeting {
    public static final LocalTime MIN_MEETING_TIME = LocalTime.of(8,30);

    private final String description;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final int priority;

    public Meeting(String desc, LocalTime start, LocalTime end, int priority){
        this.description = desc;
        this.startTime = start;
        this.endTime = end;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public String getInfo(){
        return (this.description + " " + this.startTime + "-" + this.endTime + " Priorytet: " + this.priority);
    }
}
