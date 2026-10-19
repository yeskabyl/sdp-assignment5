package fare;

public class CorporateLoyaltyFareStrategy implements FareCalculationStrategy {
    @Override
    public double calculateFare(double basePrice, String destination) {
        return basePrice * 0.8; // Flat 20% discount
    }
}
