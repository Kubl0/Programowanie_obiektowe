import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

public class OfferList {

    private ArrayList<Property> offers;

    public OfferList() {
        this.offers = new ArrayList<>();
    }

    public void addOffer(Property offer) {
        this.offers.add(offer);
    }

    public ArrayList<Property> getOffers(Predicate<Property> predicate) {
        ArrayList<Property> result = new ArrayList<>();
        Predicate<Property> isActual = property -> !property.getOfferDate().isBefore(LocalDate.now());

        for (Property offer : this.offers) {
            if (predicate.and(isActual).test(offer)) {
                result.add(offer);
            }
        }
        return result;
    }
}
