package dat.backend.model.entities;

import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {

    }
//
    public int calculateBMI (int weightInKg, int heightInCm){

        int heightInM = heightInCm / 100;

        int bmi = weightInKg / (heightInM * heightInM);

        return bmi;
    }


}
