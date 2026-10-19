package baggage;

public class BaggageContext {
    private BaggagePricingStrategy strategy;

    public BaggageContext(BaggagePricingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(BaggagePricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double executeCalculation(int weightKg) {
        return strategy.calculateBaggageFee(weightKg);
    }
}
