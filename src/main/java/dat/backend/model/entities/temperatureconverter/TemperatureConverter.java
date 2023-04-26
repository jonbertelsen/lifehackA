package dat.backend.model.entities.temperatureconverter;

/**
 * This class converts units of temperatures.
 */
public class TemperatureConverter {

    /**
     * This method converts celcius to fahrenheit.
     * @param temp is the user input provided through the temperatureConverter.jsp.
     * @return returns the user input converted to fahrenheit.
     * @author havvand
     */
    public double temperatureConverterForCelciusToFahrenheit(double temp) {
        return (temp * 1.8) + 32;
    }

    /**
     * This method converts fahrenheit to celcius.
     * @param temp is the user input provided through the temperatureConverter.jsp.
     * @return returns the user input converted to celcius.
     * @author havvand
     */
    public double temperatureConverterForFahrenheitToCelcius(double temp) {
        return (temp - 32) * 0.55555556;
    }
}
