package fare;

import external.WeatherService;

public class FareSelector {
    private final WeatherService weatherService;

    public FareSelector(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public FareCalculationStrategy selectStrategy(boolean isHoliday, boolean isLoyalMember) {
        if (isHoliday) {
            return new DynamicSurgeFareStrategy(weatherService);
        } else if (isLoyalMember) {
            return new CorporateLoyaltyFareStrategy();
        }
        return new StandardFareStrategy();
    }
}