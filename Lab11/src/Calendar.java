import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Calendar {

    private final ArrayList<ArrayList<Meeting>> weekMeetings;

    public Calendar(){
        this(7);
    }

    public Calendar(int numberOfDays){
        this.weekMeetings = new ArrayList<>();

        for (int i = 0; i < numberOfDays; i++) {
            weekMeetings.add(new ArrayList<>());
        }
    }

    public void addMeeting(int day, Meeting meeting) {
        this.weekMeetings.get(day).add(meeting);
    }

    public void removeMeeting(int day, int id) {
        this.weekMeetings.get(day).remove(id);
    }


    public ArrayList<Meeting> dayMeetings(int day, Predicate<Meeting> predicate) {
        ArrayList<Meeting> filtered = new ArrayList<>();

        for (Meeting meeting : this.weekMeetings.get(day)) {
            if (predicate.test(meeting)) {
                filtered.add(meeting);
            }
        }

        return filtered;
    }
}
