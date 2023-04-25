package dat.backend.model.entities;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BMICalculator {

    public double calculateBMI (double weightInKg, double heightInCm){

        double heightInM = heightInCm / 100;

        double bmi = weightInKg / (heightInM * heightInM);

        DecimalFormat df = new DecimalFormat("#.00");

        return Double.parseDouble(df.format(bmi));
    }



}
