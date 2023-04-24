package dat.backend.control;

import java.util.Scanner;

public class BMICalculator {

    public double calculateBMI (){

        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter your weight in kilograms");
        double weightInKg = userInput.nextDouble();
        System.out.println("Please enter your height in centimeters");
        double heightInCm = userInput.nextDouble();
        double heightInM = heightInCm / 100;

        double bmi = weightInKg / (heightInM * heightInM);
        System.out.println("your bmi is:" + bmi);
        return bmi;
    }
}
