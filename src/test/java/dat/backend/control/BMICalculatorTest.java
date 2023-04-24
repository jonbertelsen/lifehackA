package dat.backend.control;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;


class BMICalculatorTest {

    @Test
    void calculateBMI() {

        BMICalculator bmiCalculator = new BMICalculator();

        // simulates the user input
        String userInput = "100\n190\n";

        // lets the system read from inputStream instead of System.in.
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // expected BMI for a weight of 100 kg and a height of 190 cm
        double expectedBMI = 27.70;
        double calculatedBMI = bmiCalculator.calculateBMI();

        assertEquals(expectedBMI, calculatedBMI, 0.01);
    }
}