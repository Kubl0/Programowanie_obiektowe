import java.util.ArrayList;

public class Calendar {

    private final ArrayList<ArrayList<Meeting>> weekMeetings;

    public Calendar() {
        this.weekMeetings = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            weekMeetings.add(new ArrayList<>());
        }
    }

    public void addMeeting(int day, Meeting meeting) {
        this.weekMeetings.get(day).add(meeting);
    }

    public void removeMeeting(int day, int id) {
        this.weekMeetings.get(day).remove(id);
    }

    public ArrayList<Meeting> dayMeetings(int day) {
        return this.weekMeetings.get(day);
    }

    public ArrayList<Meeting> dayPriorityMeetings(int day, int priority) {
        ArrayList<Meeting> filteredByPriority = new ArrayList<>();

        for (int i = 0; i < this.weekMeetings.get(day).size(); i++) {
            if (this.weekMeetings.get(day).get(i).getPriority() == priority){
                filteredByPriority.add(this.weekMeetings.get(day).get(i));
            }
        }
        return filteredByPriority;
    }
}
