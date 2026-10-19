package fare;

public interface FareCalculationStrategy {
    double calculateFare(double basePrice, String destination);
}
