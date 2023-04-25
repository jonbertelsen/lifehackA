package dat.backend.model.entities.temperatureconverter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {
    static TemperatureConverter temperatureConverter = new TemperatureConverter();
    static double CELCIUSTEST = 10;
    static double FAHRENHEITTEST = 10;

    @Test
    void temperatureConverterForCelciusToFahrenheit() {
        assertEquals(50, temperatureConverter.temperatureConverterForCelciusToFahrenheit(CELCIUSTEST));
    }

    @Test
    void temperatureConverterForFahrenheitToCelcius() {
        assertEquals(-12.2, temperatureConverter.temperatureConverterForFahrenheitToCelcius(FAHRENHEITTEST), 0.1);
    }
}