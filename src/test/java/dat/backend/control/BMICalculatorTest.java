package dat.backend.control;

import dat.backend.model.entities.BMICalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

BMICalculator bmiCalculator;
DecimalFormat df;

    @BeforeEach
    void setUp() {
        bmiCalculator = new BMICalculator();
        df = new DecimalFormat("#.00");
    }

    @Test
    void calculateBMI() {
        double bmi = bmiCalculator.calculateBMI(90,185);

        double weightInKg = 90.0;
        double heightInCm = 185.0;
        double heightInM = heightInCm/100;

        double expectetBMI =weightInKg/((heightInM*heightInM));
        double expectetBMITwoDecimals = Double.parseDouble(df.format(expectetBMI));

        assertEquals(expectetBMITwoDecimals,bmi);
    }

    @Test
    void calculateBMIWithDecimalWeight(){
        double bmi = bmiCalculator.calculateBMI(90.1,185);

        double weightInKg = 90.1;
        double heightInCm = 185.0;
        double heightInM = heightInCm/100;

        double expectetBMI =weightInKg/((heightInM*heightInM));
        double expectetBMITwoDecimals = Double.parseDouble(df.format(expectetBMI));

        assertEquals(expectetBMITwoDecimals,bmi);
    }

    @Test
    void calculateBMIWithDecimalHeight(){
        double bmi = bmiCalculator.calculateBMI(90,185.1);

        double weightInKg = 90.0;
        double heightInCm = 185.1;
        double heightInM = heightInCm/100;

        double expectetBMI =weightInKg/((heightInM*heightInM));
        double expectetBMITwoDecimals = Double.parseDouble(df.format(expectetBMI));

        assertEquals(expectetBMITwoDecimals,bmi);
    }


}