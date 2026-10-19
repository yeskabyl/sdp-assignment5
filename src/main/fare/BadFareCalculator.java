package fare;

import external.WeatherService;
import external.FakeWeatherService;

public class BadFareCalculator {
    public double calculate(String type, double basePrice, String destination, WeatherService weather) {
        if (type.equals("STANDARD")) {
            return basePrice;
        } else if (type.equals("SURGE")) {
            return basePrice * weather.getWeatherRiskMultiplier(destination) * 1.2;
        } else if (type.equals("LOYALTY")) {
            return basePrice * 0.8;
        }
        return basePrice;
    }
}
