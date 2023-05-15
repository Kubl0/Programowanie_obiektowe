import java.util.ArrayList;
import java.util.function.Predicate;

public class Calendar {

    private final ArrayList<ArrayList<Event>> weekEvents;

    public Calendar() {
        this(7);
    }

    public Calendar(int numberOfDays) {
        this.weekEvents = new ArrayList<>();

        for (int i = 0; i < numberOfDays; i++) {
            weekEvents.add(new ArrayList<>());
        }
    }

    public void addEvent(int day, Meeting meeting) {
        this.weekEvents.get(day).add(meeting);
    }

    public void addEvent(int day, Task task) {
        this.weekEvents.get(day).add(task);
    }

    public void removeEvent(int day, Predicate<Event> condition) {
        for(int i =0; i<this.weekEvents.get(day).size(); i++){
            if(condition.test(this.weekEvents.get(day).get(i)))
                this.weekEvents.get(day).remove(i);
        }
    }

    public ArrayList<Event> dayMeetings(int day, Predicate<Event> predicate) {
        ArrayList<Event> filtered = new ArrayList<>();

        for (Event event : this.weekEvents.get(day)) {
            if (predicate.test(event)) {
                filtered.add(event);
            }
        }

        return filtered;
    }


}
