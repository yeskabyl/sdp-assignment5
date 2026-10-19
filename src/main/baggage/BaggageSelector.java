package baggage;

public class BaggageSelector {
    public BaggagePricingStrategy selectStrategy(String flightType, boolean isPremium) {
        if (isPremium) return new PremiumStatusBaggageStrategy();
        if ("INTERNATIONAL".equalsIgnoreCase(flightType)) return new InternationalWeightConceptStrategy();
        return new DomesticBasicEconomyStrategy();
    }
}
