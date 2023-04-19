import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Program do operacji na kalendarzu");
        int choice;
        boolean run = true;

        Calendar myCalendar = new Calendar();

        while(run){
            System.out.println("Jaka operacje chcesz wykonac? \n 1-Dodaj spotkanie \n 2-Usun spotkanie \n 3-Wyswietl spotkania z danego dnia \n 4-Wyswietl spotkania z danego dnia o wybranym priorytecie \n 0-Zakoncz");
            choice = input.nextInt();

            switch (choice) {
                case 0 -> {
                    System.out.println("Zakończono");
                    run = false;
                }
                case 1 -> {
                    addMeeting(myCalendar, input);
                }
                case 2 -> {
                    removeMeeting(myCalendar, input);
                }
                case 3 -> {
                    dayMeetings(myCalendar, input);
                }
                case 4 -> {
                    dayPriorityMeetings(myCalendar, input);
                }
                default -> System.out.println("Zła opcja");
            }
        }
    }
    public static void addMeeting(Calendar myCalendar, Scanner input){
        System.out.print("Podaj dzień spotkania >> ");
        int newDay = input.nextInt();
        System.out.println("Podaj opis spotkania >> ");
        String newDesc = input.next();
        System.out.println("Podaj godzine rozpoczecia >> ");
        String startTime = input.next();
        System.out.println("Podaj godzine zakonczenia >> ");
        String endTime = input.next();
        System.out.print("Podaj priorytet >> ");
        int priority = input.nextInt();
        if(LocalTime.parse(startTime).compareTo(Meeting.MIN_MEETING_TIME) > 0)
            myCalendar.addMeeting(newDay, new Meeting(newDesc, LocalTime.parse(startTime), LocalTime.parse(endTime), priority));
        else
            System.out.println("Godzina rozpoczecia jest za wczesna");
    }

    public static void removeMeeting(Calendar myCalendar, Scanner input){
        System.out.print("Podaj dzień spotkania (0-poniedzialek, 1-wtorek, 2-sroda, 3-czwartek, 4-piatek, 5-sobota, 6-niedziela)>> ");
        int newDay = input.nextInt();
        System.out.print("Podaj indeks spotkania >> ");
        int id = input.nextInt();
        myCalendar.removeMeeting(newDay, id);
    }

    public static void dayMeetings(Calendar myCalendar, Scanner input){
        System.out.print("Podaj dzień spotkania >> ");
        int newDay = input.nextInt();
        ArrayList<Meeting> result = myCalendar.dayMeetings(newDay);
        printResults(result);
    }

    public static void dayPriorityMeetings(Calendar myCalendar, Scanner input){
        System.out.print("Podaj dzień spotkania >> ");
        int newDay = input.nextInt();
        System.out.print("Podaj priorytet >> ");
        int priority = input.nextInt();
        ArrayList<Meeting> result = myCalendar.dayPriorityMeetings(newDay, priority);

        printResults(result);
    }

    public static void printResults(ArrayList<Meeting> result){
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i).getInfo());
        }
    }
}
