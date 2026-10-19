package baggage;

public class InternationalWeightConceptStrategy implements BaggagePricingStrategy {
    @Override
    public double calculateBaggageFee(int weightKg) {
        return weightKg > 23 ? (weightKg - 23) * 15.0 : 0.0;
    }
}