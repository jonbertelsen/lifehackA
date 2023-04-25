package dat.backend.model.entities;

public class AlcoholCalculator {

    // Formel til beregning af promille:
    // https://www.sundhed.dk/borger/patienthaandbogen/psyke/sygdomme/alkohol/alkoholpromille-beregning/

    public float balCalc(float weight, String gender, float time, float units) {

        if (gender.equalsIgnoreCase("male")) {
            return balCalcMale(weight, time, units);
        }
        else if(gender.equalsIgnoreCase("female")) {
            return balCalcFemale(weight, time, units);
        }
        return 100000;
    }

    private float balCalcMale(float weight, float time, float units) {
        float bal = (float) ((units * 12) / (weight *0.7) - (0.15 * time));
        return bal;
    }

    private float balCalcFemale(float weight, float time, float units) {
        float bal = (float) ((units * 12) / (weight *0.6) - (0.15 * time));
        return bal;
    }
}
