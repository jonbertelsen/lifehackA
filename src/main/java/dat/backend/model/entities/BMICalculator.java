package dat.backend.model.entities;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BMICalculator {

    public double calculateBMI (double weightInKg, double heightInCm){
    double bmiTwoDecimals = 0;

            double heightInM = heightInCm / 100;

            double bmi = weightInKg / (heightInM * heightInM);

            DecimalFormat df = new DecimalFormat("#.00");
            bmiTwoDecimals = Double.parseDouble(df.format(bmi));

            return bmiTwoDecimals;
    }



}
