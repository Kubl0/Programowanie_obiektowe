import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Calendar {

    private ArrayList<ArrayList<Meeting>> weekMeetings;

    public Calendar() {
        this.weekMeetings = new ArrayList<ArrayList<Meeting>>();

        for (int i = 0; i < 7; i++) {
            weekMeetings.add(new ArrayList<Meeting>());
        }
    }

    public void getCalendar() {
        System.out.println(weekMeetings);
    }

    public void addMeeting(int day, Meeting meeting) {
        this.weekMeetings.get(day).add(meeting);
    }

    public void removeMeeting(int day, int id) {
        this.weekMeetings.get(day).remove(id);
    }

    public ArrayList dayMeetings(int day) {
        return this.weekMeetings.get(day);
    }

    public ArrayList dayPriorityMeetings(int day, int priority) {
        ArrayList<Meeting> filtered = this.weekMeetings.get(day);

        for (int i = 0; i < filtered.size(); i++) {
            if (filtered.get(i).getPriority() != priority) {
                filtered.remove(i);
            }
        }
        return filtered;
    }
}
