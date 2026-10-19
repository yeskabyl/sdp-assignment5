package fare;

public class FareContext {
    private FareCalculationStrategy strategy;

    public FareContext(FareCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(FareCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public double executeCalculation(double basePrice, String destination) {
        return strategy.calculateFare(basePrice, destination);
    }
}
