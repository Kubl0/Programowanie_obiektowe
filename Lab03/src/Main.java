import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Program do operacji na obiekcie walec");

        Cylinder myCylinder = new Cylinder();

        int choice;

        while(true){
            System.out.println("Jaka operacje chcesz wykonac? \n 1-Wyswietl wartosci zmiennych walca \n 2-Zmien wartości zmiennych walca \n 3-Wyswietl pola i objetosc \n 0-Zakoncz");
            choice = input.nextInt();

            switch (choice) {
                case 0 -> {
                    System.out.println("Zakończono");
                    System.exit(0);
                }
                case 1 -> System.out.println("Wysokość: " + myCylinder.getHeight() + " Promień: " + myCylinder.getRadius());
                case 2 -> {
                    System.out.print("Podaj nową wysokość >> ");
                    double newHeight = input.nextDouble();
                    System.out.print("Podaj nowy promień >> ");
                    double newRadius = input.nextDouble();

                    myCylinder.setHeight(newHeight);
                    myCylinder.setRadius(newRadius);
                }
                case 3 -> System.out.println("Pole podstawy: " + myCylinder.baseArea() + "\n Pole boczne: " + myCylinder.sideArea() + "\n Pole całkowite: " + myCylinder.area() + "\n Objetosc: " + myCylinder.volume());
                default -> System.out.println("Zła opcja");
            }
        }
    }
}
