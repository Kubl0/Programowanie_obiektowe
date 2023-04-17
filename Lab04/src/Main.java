import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Program do operacji na ocneach");

        GradeList myGradeList = new GradeList();

        int choice;
        boolean run = true;

        while(run){
            System.out.println("Jaka operacje chcesz wykonac? \n 1-Dodaj ocene \n 2-Wyswietl srednia \n 3-Maksymalna ocena \n 4-Minimalna ocena \n 0-Zakoncz");
            choice = input.nextInt();

            switch (choice) {
                case 0 -> {
                    System.out.println("Zakończono");
                    run = false;
                }
                case 1 -> {
                    System.out.print("Podaj nową ocene >> ");
                    double newGrade = input.nextDouble();
                    if(newGrade >=2 && newGrade <= 5)
                        myGradeList.addGrade(newGrade);
                    else {System.out.println("Podano złą ocene");}
                }
                case 2 -> {
                    if(myGradeList.isEmpty())
                        System.out.println("Srednia: " + myGradeList.averageGrade());
                    else {System.out.println("Tablica jest pusta");}
                }
                case 3 -> {
                    if(myGradeList.isEmpty())
                        System.out.println("Maksymalna: " + myGradeList.maxGrade());
                    else {System.out.println("Tablica jest pusta");}
                }
                case 4 -> {
                    if(myGradeList.isEmpty())
                        System.out.println("Maksymalna: " + myGradeList.minGrade());
                    else {System.out.println("Tablica jest pusta");}
                }
                default -> System.out.println("Zła opcja");
            }
        }
    }
}