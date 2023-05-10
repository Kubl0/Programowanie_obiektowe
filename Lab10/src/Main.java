import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputInt = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        System.out.println("Program do operacji na kalendarzu");
        int choice;
        boolean run = true;

        Calendar myCalendar = new Calendar();

        while(run){
            System.out.println("""
                    Jaka operacje chcesz wykonac?\s
                     1-Dodaj spotkanie\s
                     2-Usun spotkanie\s
                     3-Wyswietl spotkania z danego dnia\s
                     4-Wyswietl spotkania z danego dnia o wybranym priorytecie\s
                     5-Wyswietl spotkania z dnia od danej godziny\s
                     6-Wyswietl spotkania z danego dnia w przedziale
                     7-Wyswietl spotkania w przedziale z danym priorytetem
                     0-Zakoncz""");

            choice = inputInt.nextInt();

            switch (choice) {
                case 0 -> {
                    System.out.println("Zakończono");
                    run = false;
                }
                case 1 -> addMeeting(myCalendar, inputInt, inputString);
                case 2 -> removeMeeting(myCalendar, inputInt);
                case 3 -> dayMeetings(myCalendar, inputInt);
                case 4 -> dayPriorityMeetings(myCalendar, inputInt, inputString);
                case 5 -> dayMeetingsFrom(myCalendar, inputInt, inputString);
                case 6 -> dayMeetingsFromTo(myCalendar, inputInt,inputString);
                case 7 -> dayMeetingsPriorityFrom(myCalendar, inputInt, inputString);
                default -> System.out.println("Zła opcja");
            }
        }
    }

    public static void dayMeetingsFrom(Calendar myCalendar, Scanner inputInt, Scanner inputString){
        System.out.print("Podaj dzień spotkania >> ");
        int newDay = inputInt.nextInt() - 1;
        System.out.print("Podaj godzine rozpoczecia >> ");
        String startTime = inputString.nextLine();
        printResults(myCalendar.dayMeetings(newDay, myCalendar.getFromTime(LocalTime.parse(startTime))));
    }

    public static void dayMeetingsFromTo(Calendar myCalendar, Scanner inputInt, Scanner inputString){
        System.out.print("Podaj dzień spotkania >> ");
        int newDay = inputInt.nextInt() - 1;
        System.out.print("Podaj godzine rozpoczecia >> ");
        String startTime = inputString.nextLine();
        System.out.print("Podaj godzine zakonczenia >> ");
        String endTime = inputString.nextLine();
        printResults(myCalendar.dayMeetings(newDay, myCalendar.getFromTime(LocalTime.parse(startTime)).and(myCalendar.getToTime(LocalTime.parse(endTime)))));
    }

    public static void dayMeetingsPriorityFrom(Calendar myCalendar, Scanner inputInt, Scanner inputString){
        System.out.print("Podaj dzień spotkania >> ");
        int newDay = inputInt.nextInt() - 1;
        System.out.print("Podaj godzine rozpoczecia >> ");
        String startTime = inputString.nextLine();
        System.out.print("Podaj priorytet >> ");
        String priority = inputString.nextLine();
        printResults(myCalendar.dayMeetings(newDay, myCalendar.getFromTime(LocalTime.parse(startTime)).and(myCalendar.getPriority(priority))));
    }

    public static void addMeeting(Calendar myCalendar, Scanner inputInt, Scanner inputString){
        System.out.print("Podaj dzień spotkania >> ");
        int newDay = inputInt.nextInt() - 1;
        System.out.print("Podaj opis spotkania >> ");
        String newDesc = inputString.nextLine();
        System.out.print("Podaj godzine rozpoczecia >> ");
        String startTime = inputString.nextLine();
        while(LocalTime.parse(startTime).isBefore(Meeting.MIN_MEETING_TIME)){
            System.out.print("Godzina rozpoczecia jest za wczesna, podaj nową >> ");
            startTime = inputString.nextLine();}
        System.out.print("Podaj godzine zakonczenia >> ");
        String endTime = inputString.nextLine();
        System.out.print("Podaj priorytet >> ");
        String priority = inputString.nextLine();
        myCalendar.addMeeting(newDay, new Meeting(newDesc, LocalTime.parse(startTime), LocalTime.parse(endTime), priority));

    }

    public static void removeMeeting(Calendar myCalendar, Scanner input){
        System.out.print("Podaj dzień spotkania >> ");
        int newDay = input.nextInt() - 1;
        System.out.print("Podaj indeks spotkania >> ");
        int id = input.nextInt();
        myCalendar.removeMeeting(newDay, id);
    }

    public static void dayMeetings(Calendar myCalendar, Scanner input){
        System.out.print("Podaj dzień spotkania >> ");
        int newDay = input.nextInt() - 1;
        printResults(myCalendar.dayMeetings(newDay));
    }

    public static void dayPriorityMeetings(Calendar myCalendar, Scanner input, Scanner inputString ){
        System.out.print("Podaj dzień spotkania >> ");
        int newDay = input.nextInt() - 1;
        System.out.print("Podaj priorytet >> ");
        String priority = inputString.nextLine();
        printResults(myCalendar.dayMeetings(newDay, myCalendar.getPriority(priority)));
    }

    public static void printResults(ArrayList<Meeting> result){
        for (Meeting meeting : result) {
            System.out.println(meeting.toString());
        }
    }
}
