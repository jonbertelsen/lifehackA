package dat.backend.model.entities;

import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {

    }
//
    public double calculateBMI (double weightInKg, double heightInCm){

        double heightInM = heightInCm / 100;

        double bmi = weightInKg / (heightInM * heightInM);

        return bmi;
    }


}
