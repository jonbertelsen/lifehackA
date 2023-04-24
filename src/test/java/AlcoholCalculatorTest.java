import dat.backend.model.entities.AlcoholCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlcoholCalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void balCalc() {
        AlcoholCalculator calculator = new AlcoholCalculator();
        float expectedMale = (float) 0.92;
        float resultMale = calculator.balCalc(80, "male", 1F, 5);

        float expectedFemale = (float) 1.1;
        float resultFemale = calculator.balCalc(80, "female", 1F, 5);

        assertEquals(expectedFemale, resultFemale, 0.01);
        assertEquals(expectedMale, resultMale, 0.01);
    }

    @Test
    void invalidGenderBalCalc() {
        AlcoholCalculator calculator = new AlcoholCalculator();
        float expected = 100000;
        float result = calculator.balCalc(80, "car", 1F, 5);
        assertEquals(expected, result);
    }
}