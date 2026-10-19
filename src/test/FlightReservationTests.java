import fare.*;
import baggage.*;
import external.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

class FlightReservationTests {
    private final WeatherService fakeWeather = new FakeWeatherService();

    @Test
    void testStandardFareStrategy() {
        FareCalculationStrategy strategy = new StandardFareStrategy();
        assertEquals(100.0, strategy.calculateFare(100.0, "Astana"));
    }

    @Test
    void testSurgeFareStrategyWithExternalData() {
        FareCalculationStrategy strategy = new DynamicSurgeFareStrategy(fakeWeather);
        assertEquals(180.0, strategy.calculateFare(100.0, "Oral"));
    }

    @Test
    void testFareSelectorRouting() {
        FareSelector selector = new FareSelector(fakeWeather);
        assertTrue(selector.selectStrategy(true, false) instanceof DynamicSurgeFareStrategy);
        assertTrue(selector.selectStrategy(false, true) instanceof CorporateLoyaltyFareStrategy);
    }

    @ParameterizedTest
    @MethodSource("provideBaggageStrategies")
    void baggageFeeIsNeverNegative(BaggagePricingStrategy strategy) {
        assertTrue(strategy.calculateBaggageFee(5) >= 0.0);
        assertTrue(strategy.calculateBaggageFee(50) >= 0.0);
    }

    static Stream<BaggagePricingStrategy> provideBaggageStrategies() {
        return Stream.of(
                new DomesticBasicEconomyStrategy(),
                new InternationalWeightConceptStrategy(),
                new PremiumStatusBaggageStrategy()
        );
    }
}