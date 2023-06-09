import java.util.ArrayList;

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

    public ArrayList<Meeting> dayMeetings(int day) {
        return this.weekMeetings.get(day);
    }

    public ArrayList<Meeting> dayPriorityMeetings(int day, String priority) {
        ArrayList<Meeting> filteredByPriority = new ArrayList<>();

        for (int i = 0; i < this.weekMeetings.get(day).size(); i++) {
            if(this.weekMeetings.get(day).get(i).getPriority() == Meeting.PriorityValues.valueOf(priority)){
                filteredByPriority.add(this.weekMeetings.get(day).get(i));
            }
        }
        return filteredByPriority;
    }
}
