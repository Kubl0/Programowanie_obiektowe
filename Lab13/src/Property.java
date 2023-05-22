import java.time.LocalDate;

abstract sealed class Property permits House, Flat {

    private String street;
    private int number;
    private String city;
    private String postalCode;
    private double area;
    private double price;
    private LocalDate offerDate;

    public Property(String street, int number, String city, String postalCode, double area, double price, LocalDate offerDate) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.postalCode = postalCode;
        this.area = area;
        this.price = price;
        this.offerDate = offerDate;
    }

    @Override
    public String toString() {
        return "Adres: " + this.street + " " + this.number + ", " + this.city + " " + this.postalCode + " Powierzchnia: " + this.area + " Cena: " + this.price + " Data: " + this.offerDate;
    }

    public LocalDate getOfferDate() {
        return offerDate;
    }

    public String getCity() {
        return city;
    }

    public double getArea() {
        return area;
    }

    public double getPrice() {
        return price;
    }
}
