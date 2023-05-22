import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    private static Scanner inputInt = new Scanner(System.in);
    private static Scanner inputString = new Scanner(System.in);
    private static Scanner inputDouble = new Scanner(System.in);
    private static OfferList myOfferList = new OfferList();

    public static void main(String[] args) {

        addInitialValues(myOfferList);

        int choice;
        boolean run = true;

        while (run) {
            System.out.println("""
                    Jaka operacje chcesz wykonac?\s
                     1-Dodaj ogloszenie\s
                     2-Wyswietl aktualne ogloszenia domow\s
                     3-Wyswietl aktualne ogloszenia mieszkan\s
                     4-Wyswietl domy w miejscowosci o powierzchnii nie mniejszej niż\s
                     5-Wyswietl mieszkania w miejscowosci, nie drozszych niz i od podanego pietra\s
                     0-Zakoncz""");

            choice = inputInt.nextInt();

            switch (choice) {
                case 0 -> {
                    System.out.println("Zakończono");
                    run = false;
                }
                case 1 -> addOffer(myOfferList);
                case 2 -> showAllHouses(myOfferList);
                case 3 -> showAllFlats(myOfferList);
                case 4 -> showHousesInCityWithArea(myOfferList);
                case 5 -> showFlatsInCityWithPrice(myOfferList);
                default -> System.out.println("Zła opcja");
            }
        }
    }

    public static void addOffer(OfferList offerList) {
        System.out.print("Dom czy mieszkanie (1-dom, 2-mieszkanie) >> ");
        int offer = inputInt.nextInt();
        while (offer != 1 && offer != 2) {
            System.out.print("Niepoprawna liczba, wpisz poprawna >> ");
            offer = inputInt.nextInt();
        }

        System.out.print("Podaj ulice >> ");
        String street = inputString.nextLine();
        System.out.print("Podaj numer >> ");
        int number = inputInt.nextInt();
        System.out.print("Podaj miasto >> ");
        String city = inputString.nextLine();
        System.out.print("Podaj kod pocztowy >> ");
        String postalCode = inputString.nextLine();
        System.out.print("Podaj powierzchnie >> ");
        double area = inputDouble.nextDouble();
        System.out.print("Podaj cene >> ");
        double price = inputDouble.nextDouble();
        System.out.print("Podaj date >> ");
        String date = inputString.nextLine();
        LocalDate offerDate = LocalDate.parse(date);

        if (offer == 1) {
            System.out.print("Podaj powierzchnie dzialki >> ");
            double plotArea = inputDouble.nextDouble();
            House house = new House(street, number, city, postalCode, area, price, offerDate, plotArea);
            offerList.addOffer(house);
        } else {
            System.out.print("Podaj pietro >> ");
            int floor = inputInt.nextInt();
            System.out.print("Podaj numer mieszkania >> ");
            int flatNumber = inputInt.nextInt();
            Flat flat = new Flat(street, number, city, postalCode, area, price, offerDate, floor, flatNumber);
            offerList.addOffer(flat);
        }
    }

    public static void showAllHouses(OfferList offerList) {
        Predicate<Property> isHouse = property -> property instanceof House;
        printResult(offerList.getOffers(isHouse));
    }

    public static void showAllFlats(OfferList offerList) {
        Predicate<Property> isFlat = property -> property instanceof Flat;
        printResult(offerList.getOffers(isFlat));
    }

    public static void showHousesInCityWithArea(OfferList offerList) {
        System.out.print("Podaj miasto >> ");
        String city = inputString.nextLine();
        System.out.print("Podaj powierzchnie >> ");
        double area = inputDouble.nextDouble();
        Predicate<Property> isHouse = property -> property instanceof House;
        Predicate<Property> isCity = property -> property.getCity().equals(city);
        Predicate<Property> isArea = property -> property.getArea() >= area;
        Predicate<Property> isCityWithArea = isHouse.and(isCity).and(isArea);
        printResult(offerList.getOffers(isCityWithArea));
    }

    public static void showFlatsInCityWithPrice(OfferList offerList) {
        System.out.print("Podaj miasto >> ");
        String city = inputString.nextLine();
        System.out.print("Podaj cene >> ");
        double price = inputDouble.nextDouble();
        System.out.print("Podaj pietro >> ");
        int floor = inputInt.nextInt();
        Predicate<Property> isFlat = property -> property instanceof Flat;
        Predicate<Property> isCity = property -> property.getCity().equals(city);
        Predicate<Property> isPrice = property -> property.getPrice() <= price;
        Predicate<Property> isFloor = property -> ((Flat) property).getFloor() >= floor;
        Predicate<Property> isCityWithPrice = isFlat.and(isCity).and(isPrice).and(isFloor);
        printResult(offerList.getOffers(isCityWithPrice));
    }

    public static void printResult(ArrayList<Property> offerList) {
        System.out.println();
        for (Property property : offerList) {
            System.out.println(property);
        }
        System.out.println();
    }

    public static void addInitialValues(OfferList offerList) {
        offerList.addOffer(new House("Kwiatowa", 1, "Gdansk", "80-180", 100, 100000, LocalDate.parse("2022-01-01"), 100));
        offerList.addOffer(new House("Kwiatowa", 2, "Gdansk", "80-180", 700, 200000, LocalDate.parse("2024-01-01"), 50));
        offerList.addOffer(new House("Kwiatowa", 3, "Gdansk", "80-180", 200, 300000, LocalDate.parse("2024-02-24"), 200));
        offerList.addOffer(new House("Kwiatowa", 3, "Krakow", "80-180", 200, 300000, LocalDate.parse("2024-02-24"), 200));
        offerList.addOffer(new Flat("Kwiatowa", 4, "Krakow", "80-180", 100, 100000, LocalDate.parse("2022-01-01"), 1, 1));
        offerList.addOffer(new Flat("Kwiatowa", 5, "Gdansk", "80-180", 100, 200000, LocalDate.parse("2024-01-01"), 2, 2));
        offerList.addOffer(new Flat("Kwiatowa", 6, "Gdansk", "80-180", 100, 100000, LocalDate.parse("2024-02-24"), 3, 3));
        offerList.addOffer(new Flat("Kwiatowa", 7, "Gdansk", "80-180", 100, 100000, LocalDate.parse("2024-02-24"), 4, 4));
    }
}