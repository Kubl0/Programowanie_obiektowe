import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

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
                     2-Usun wydarzenie\s
                     3-Wyswietl spotkania z danego dnia\s
                     4-Wyswietl zadania z danego dnia\s
                     5-Zadania z dnia z priorytetem\s
                     0-Zakoncz""");

            choice = inputInt.nextInt();

            switch (choice) {
                case 0 -> {
                    System.out.println("Zakończono");
                    run = false;
                }
                case 1 -> addEvent(myCalendar, inputInt, inputString);
                case 2 -> removeEvent(myCalendar, inputInt, inputString);
                case 3 -> dayEvents(myCalendar, inputInt, 1);
                case 4 -> dayEvents(myCalendar, inputInt, 2);
                case 5 -> dayMeetingsPriority(myCalendar, inputInt, inputString);
                default -> System.out.println("Zła opcja");
            }
        }
    }

    private static void dayMeetingsPriority(Calendar myCalendar, Scanner inputInt, Scanner inputString) {
        System.out.print("Podaj dzien >> ");
        int day = inputInt.nextInt();
        System.out.print("Podaj priorytet >> ");
        String priority = inputString.nextLine();
        Predicate<Event> getType = e -> e instanceof Meeting;
        Predicate<Event> getPriority = e -> ((Meeting) e).getPriority() == Meeting.PriorityValues.valueOf(priority);
        printResults(myCalendar.dayMeetings(day, getType.and(getPriority)));
    }

    public static void addEvent(Calendar myCalendar, Scanner inputInt, Scanner inputString){
        System.out.print("Zadanie czy spotkanie (1-zadanie, 2-spotkanie) >> ");
        int event = inputInt.nextInt();
        while(event!=1 && event != 2){
            System.out.print("Niepoprawna liczba, wpisz poprawna >> ");
            event = inputInt.nextInt();
        }
        System.out.print("Podaj dzień >> ");
        int newDay = inputInt.nextInt() - 1;
        System.out.print("Podaj opis >> ");
        String newDesc = inputString.nextLine();
        System.out.print("Podaj godzine rozpoczecia >> ");
        String startTime = inputString.nextLine();
        while(LocalTime.parse(startTime).isBefore(Meeting.MIN_START_TIME)){
            System.out.print("Godzina rozpoczecia jest za wczesna, podaj nową >> ");
            startTime = inputString.nextLine();}
        System.out.print("Podaj godzine zakonczenia >> ");
        String endTime = inputString.nextLine();
        if(event == 1){
            System.out.print("Podaj status zadania: ");
            String status = inputString.nextLine();
            myCalendar.addEvent(newDay, new Task(status, LocalTime.parse(startTime), LocalTime.parse(endTime), newDesc));
        }
        else{
            System.out.print("Podaj priorytet spotkania: ");
            String priority = inputString.nextLine();
            myCalendar.addEvent(newDay, new Meeting(priority, newDesc, LocalTime.parse(startTime), LocalTime.parse(endTime)));
        }
    }

    public static void removeEvent(Calendar myCalendar, Scanner input, Scanner inputS){
        System.out.print("Spotkanie czy zadanie (1-zadanie, 2-spotkanie) >> ");
        int choice = input.nextInt();
        System.out.print("Podaj dzień >> ");
        int newDay = input.nextInt() - 1;
        System.out.print("Podaj opis >> ");
        String desc = inputS.nextLine();
        Predicate<Event> condition = e -> e.getDescription().equals(desc);
        Predicate<Event> condition2 = e -> true;
                if(choice==1){
                    condition2 = e -> e instanceof Task;
                }
                if(choice==2){
                    condition2 = e -> e instanceof Meeting;
                }
        myCalendar.removeEvent(newDay, condition.and(condition2));
    }

    public static void dayEvents(Calendar myCalendar, Scanner input, int choice){
        System.out.print("Podaj dzień spotkania >> ");
        int newDay = input.nextInt() - 1;
        Predicate<Event> getDay = meeting -> true;
        Predicate<Event> getType = e -> true;
        if(choice==1) {
            getType = e -> e instanceof Meeting;
        }else{
            getType = e -> e instanceof Task;
        }
        printResults(myCalendar.dayMeetings(newDay, getDay.and(getType)));
    }

    public static void printResults(ArrayList<Event> result){
        for (Event event : result) {
            System.out.println(event);
        }
    }
}
