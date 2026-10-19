package baggage;

public class PremiumStatusBaggageStrategy implements BaggagePricingStrategy {
    @Override
    public double calculateBaggageFee(int weightKg) {
        return 0.0; // Always free for premium
    }
}
