import external.*;
import fare.*;
import baggage.*;

public class Main {
    static void main(String[] args) {
        WeatherService weatherAPI = new FakeWeatherService();
        double basePrice = 200.0;
        String destination = "Oral";

        System.out.println("--- Fare Processing (Same Input, Different Strategies) ---");
        FareContext context = new FareContext(new StandardFareStrategy());
        System.out.println("Standard: $" + context.executeCalculation(basePrice, destination));

        context.setStrategy(new DynamicSurgeFareStrategy(weatherAPI));
        System.out.println("Surge (Weather API): $" + context.executeCalculation(basePrice, destination));

        context.setStrategy(new CorporateLoyaltyFareStrategy());
        System.out.println("Loyalty: $" + context.executeCalculation(basePrice, destination));

        System.out.println("\n--- Selector Automatic Choice vs Runtime Switching ---");
        FareSelector selector = new FareSelector(weatherAPI);

        boolean isHoliday = true;
        FareCalculationStrategy autoStrategy = selector.selectStrategy(isHoliday, false);
        context.setStrategy(autoStrategy);
        System.out.println("Auto-Selected Holiday Fare: $" + context.executeCalculation(basePrice, destination));

        System.out.println("Agent overrides to Standard Fare at runtime...");
        context.setStrategy(new StandardFareStrategy());
        System.out.println("Overridden Fare: $" + context.executeCalculation(basePrice, destination));
    }
}
