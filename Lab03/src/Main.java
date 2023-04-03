import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Program do operacji na obiekcie walec");

        Scanner input = new Scanner(System.in);

        System.out.println("Podaj wysokość walca >> ");
        double height = input.nextDouble();

        System.out.println("Podaj promień walca >> ");
        double radius = input.nextDouble();

        Cylinder myCylinder = new Cylinder(radius, height);

        int choice = 1;

        while(choice != 0){
            System.out.println("""
                    Co chcesz zrobic?\s
                     1-Policz pole podstawy\s
                     2-Policz pole boczne\s
                     3-Policz pole całkowite\s
                     4-Policz objętość\s
                     5-Wyswietl wartosci zmiennych walca\s
                     6-Zmien wartosci zmiennych walca\s
                     0-Zakończ program""");

            choice = input.nextInt();

            switch (choice) {
                case 0 -> {
                    System.out.println("Zakończono");
                    System.exit(0);
                }
                case 1 -> System.out.println("Pole podstawy wynosi: " + myCylinder.baseArea());
                case 2 -> System.out.println("Pole boczne wynosi: " + myCylinder.sideArea());
                case 3 -> System.out.println("Pole całkowite wynosi: " + myCylinder.area());
                case 4 -> System.out.println("Objętość wynosi: " + myCylinder.volume());
                case 5 ->
                        System.out.println("Wysokosc: " + myCylinder.getHeight() + " Promien: " + myCylinder.getRadius());
                case 6 -> {
                    System.out.println("Co chcesz zmienic? \n 1-Wysokosc \n 2-Promien \n 3-Oba");
                    choice = input.nextInt();
                    switch (choice) {
                        case 1 -> {
                            System.out.println("Podaj nowa wysokość >> ");
                            height = input.nextDouble();
                            myCylinder.setHeight(height);
                        }
                        case 2 -> {
                            System.out.println("Podaj nowy promien >> ");
                            radius = input.nextDouble();
                            myCylinder.setRadius(radius);
                        }
                        case 3 -> {
                            System.out.println("Podaj nowa wysokość >> ");
                            height = input.nextDouble();
                            myCylinder.setHeight(height);
                            System.out.println("Podaj nowy promien >> ");
                            radius = input.nextDouble();
                            myCylinder.setRadius(radius);
                        }
                        default -> System.out.println("Zła opcja");
                    }
                }
                default -> System.out.println("Zła opcja");
            }
        }
        }
    }

