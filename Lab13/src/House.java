import java.time.LocalDate;

final public class House extends Property {
    private double plotArea;

    public House(String street, int number, String city, String postalCode, double area, double price, LocalDate offerDate, double plotArea) {
        super(street, number, city, postalCode, area, price, offerDate);
        this.plotArea = plotArea;
    }

    @Override
    public String toString() {
        return super.toString() + " Powierzchnia działki: " + this.plotArea;
    }
}
