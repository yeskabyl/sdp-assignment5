package external;

public class FakeWeatherService implements WeatherService {
    @Override
    public double getWeatherRiskMultiplier(String destination) {
        return "Oral".equalsIgnoreCase(destination) ? 1.5 : 1.0;
    }
}
