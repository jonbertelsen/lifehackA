package dat.backend.model.entities;

import java.text.DecimalFormat;

/**
 * Purpose is to be a container for relevant methods for a BMI calculator.
 * Users are the devs
 */
public class BMICalculator {
    /**
     * @return it returns BMI with 2 decimals, the parameters affect the value.
     */
    public double calculateBMI(double weightInKg, double heightInCm) {
        double bmiTwoDecimals = 0;

        double heightInM = heightInCm / 100;

        double bmi = weightInKg / (heightInM * heightInM);

        return bmi;
    }
}
