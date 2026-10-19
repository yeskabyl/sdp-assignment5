package fare;

public class StandardFareStrategy implements FareCalculationStrategy {
    @Override
    public double calculateFare(double basePrice, String destination) {
        return basePrice;
    }
}