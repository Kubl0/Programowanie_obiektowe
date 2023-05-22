import java.time.LocalDate;

final public class Flat extends Property {
    private int floor;
    private int flatNumber;

    public Flat(String street, int number, String city, String postalCode, double area, double price, LocalDate offerDate, int floor, int flatNumber) {
        super(street, number, city, postalCode, area, price, offerDate);
        this.floor = floor;
        this.flatNumber = flatNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " Piętro: " + this.floor + " Numer mieszkania: " + this.flatNumber;
    }

    public int getFloor() {
        return floor;
    }
}
