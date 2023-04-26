package dat.backend.model.entities;

/**
 * This class serves as the mathematical part of the alcohol blood level calculator. It is implemented in AlcoholServlet.java.
 */
public class AlcoholCalculator {

    // Formel til beregning af promille:
    // https://www.sundhed.dk/borger/patienthaandbogen/psyke/sygdomme/alkohol/alkoholpromille-beregning/

    /**
     * The final calculation. Checks whether the gender is Male or Female, and chooses which calculation is needed.
     * @param weight
     * @param gender
     * @param time
     * @param units
     * @return
     */
    public float balCalc(float weight, String gender, float time, float units) {

        if (gender.equalsIgnoreCase("male")) {
            return balCalcMale(weight, time, units);
        }
        else if(gender.equalsIgnoreCase("female")) {
            return balCalcFemale(weight, time, units);
        }
        return 100000;
    }

    /**
     * Calculates the blood alcohol level for males. returns a float
     * @param weight
     * @param time
     * @param units
     * @return
     */
    private float balCalcMale(float weight, float time, float units) {
        return (float) ((units * 12) / (weight *0.7) - (0.15 * time));
    }

    /**
     * Calculates the blood alcohol level for females. returns a float
     * @param weight
     * @param time
     * @param units
     * @return
     */
    private float balCalcFemale(float weight, float time, float units) {
        return (float) ((units * 12) / (weight *0.6) - (0.15 * time));
    }
}
