import java.time.LocalTime;

public class Meeting {
    public static final LocalTime MIN_MEETING_TIME = LocalTime.of(8,30);

    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private int priority;

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
        return (this.description + " " + this.startTime + "-" + this.endTime + " Priorytet: " + this.priority).toString();
    }
}
