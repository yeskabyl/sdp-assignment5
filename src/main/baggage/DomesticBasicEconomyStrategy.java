package baggage;

public class DomesticBasicEconomyStrategy implements BaggagePricingStrategy {
    @Override
    public double calculateBaggageFee(int weightKg) {
        return weightKg > 10 ? (weightKg - 10) * 5.0 : 0.0;
    }
}
