import java.time.LocalTime;

abstract sealed class Event permits Meeting, Task{
    public static LocalTime MIN_START_TIME = LocalTime.of(8, 0);
    protected LocalTime startTime;
    protected LocalTime endTime;
    protected String description;

    public Event(LocalTime startTime, LocalTime endTime, String description) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public LocalTime getEndTime() {
        return this.endTime;
    }

    public String getDescription() { return this.description; }

}
