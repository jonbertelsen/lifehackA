package dat.backend.model.entities.temperatureconverter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {
    private static TemperatureConverter temperatureConverter = new TemperatureConverter();
    private final static double CELCIUSTEST = 10;
    private final static double FAHRENHEITTEST = 10;

    @Test
    void temperatureConverterForCelciusToFahrenheit() {
        assertEquals(50, temperatureConverter.temperatureConverterForCelciusToFahrenheit(CELCIUSTEST));
    }

    @Test
    void temperatureConverterForFahrenheitToCelcius() {
        assertEquals(-12.2, temperatureConverter.temperatureConverterForFahrenheitToCelcius(FAHRENHEITTEST), 0.1);
    }
}