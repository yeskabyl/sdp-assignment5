package fare;

import external.WeatherService;

public class DynamicSurgeFareStrategy implements FareCalculationStrategy {
    private final WeatherService weatherService;

    public DynamicSurgeFareStrategy(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    public double calculateFare(double basePrice, String destination) {
        double risk = weatherService.getWeatherRiskMultiplier(destination);
        return basePrice * risk * 1.2;
    }
}