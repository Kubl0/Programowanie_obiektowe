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
            System.out.println("Co chcesz zrobic? \n 1-Policz pole podstawy \n 2-Policz pole boczne \n 3-Policz pole całkowite \n 4-Policz objętość \n 5-Wyswietl wartosci zmiennych walca \n" +
                    " 6-Zmien wartosci zmiennych walca \n 0-Zakończ program");
            choice = input.nextInt();

            if(choice == 0) {
                System.out.println("Zakończono");
                System.exit(0);
            } else if (choice == 1) {
                System.out.println("Pole podstawy wynosi: " + myCylinder.baseArea());
            } else if (choice == 2) {
                System.out.println("Pole boczne wynosi: " + myCylinder.sideArea());
            } else if (choice == 3) {
                System.out.println("Pole całkowite wynosi: " + myCylinder.area());
            } else if (choice == 4) {
                System.out.println("Objętość wynosi: " + myCylinder.volume());
            } else if (choice == 5) {
                System.out.println("Wysokosc: " + myCylinder.getHeight() + " Promien: " + myCylinder.getRadius());
            } else if (choice == 6) {
                System.out.println("Co chcesz zmienic? \n 1-Wysokosc \n 2-Promien \n 3-Oba");
                choice = input.nextInt();
                if(choice == 1){
                    System.out.println("Podaj nowa wysokość >> ");
                    height = input.nextDouble();
                    myCylinder.setHeight(height);
                } else if (choice == 2){
                    System.out.println("Podaj nowy promien >> ");
                    radius = input.nextDouble();
                    myCylinder.setRadius(radius);
                } else if (choice == 3) {
                    System.out.println("Podaj nowa wysokość >> ");
                    height = input.nextDouble();
                    myCylinder.setHeight(height);
                    System.out.println("Podaj nowy promien >> ");
                    radius = input.nextDouble();
                    myCylinder.setRadius(radius);
                } else {
                    System.out.println("Zła opcja");
                }
            }
            else {
                System.out.println("Zła opcja");
            }
            }
        }








    }

