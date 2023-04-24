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
            System.out.println("Jaka operacje chcesz wykonac? \n 1-Dodaj spotkanie \n 2-Usun spotkanie \n 3-Wyswietl spotkania z danego dnia \n 4-Wyswietl spotkania z danego dnia o wybranym priorytecie \n 0-Zakoncz");
            choice = inputInt.nextInt();

            switch (choice) {
                case 0 -> {
                    System.out.println("Zakończono");
                    run = false;
                }
                case 1 -> addMeeting(myCalendar, inputInt, inputString);
                case 2 -> removeMeeting(myCalendar, inputInt);
                case 3 -> dayMeetings(myCalendar, inputInt);
                case 4 -> dayPriorityMeetings(myCalendar, inputInt);
                default -> System.out.println("Zła opcja");
            }
        }
    }
    public static void addMeeting(Calendar myCalendar, Scanner inputInt, Scanner inputString){
        System.out.print("Podaj dzień spotkania >> ");
        int newDay = inputInt.nextInt() - 1;
        System.out.print("Podaj opis spotkania >> ");
        String newDesc = inputString.nextLine();
        System.out.print("Podaj godzine rozpoczecia >> ");
        String startTime = inputString.nextLine();
        while(LocalTime.parse(startTime).compareTo(Meeting.MIN_MEETING_TIME) < 0){
            System.out.print("Godzina rozpoczecia jest za wczesna, podaj nową >> ");
            startTime = inputString.nextLine();}
        System.out.print("Podaj godzine zakonczenia >> ");
        String endTime = inputString.nextLine();
        System.out.print("Podaj priorytet >> ");
        int priority = inputInt.nextInt();
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

    public static void dayPriorityMeetings(Calendar myCalendar, Scanner input){
        System.out.print("Podaj dzień spotkania >> ");
        int newDay = input.nextInt() - 1;
        System.out.print("Podaj priorytet >> ");
        int priority = input.nextInt();
        printResults(myCalendar.dayPriorityMeetings(newDay, priority));
    }

    public static void printResults(ArrayList<Meeting> result){
        for (Meeting meeting : result) {
            System.out.println(meeting.getInfo());
        }
    }
}
