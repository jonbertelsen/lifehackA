package dat.backend.model.entities.temperatureconverter;

public class TemperatureConverter {

    public double temperatureConverterForCelciusToFahrenheit(double temp) {
        return (temp * 1.8) + 32;
    }

    public double temperatureConverterForFahrenheitToCelcius(double temp) {
        return (temp - 32) * 0.55555556;
    }
}
