import dat.backend.control.unitConverter.converterCalc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class unitConverterTest {
    converterCalc converter;

    @BeforeEach
    void setUp(){
        converter = new converterCalc();
    }

    @Test
    void centiToMilli(){     //15 cm = 150 mm
        assertEquals(converter.calcuate(15,"cm","mm"),150);
    }
    @Test
    void milliToCenti(){     //150 mm = 15 cm
        assertEquals(converter.calcuate(150,"mm","cm"),15);
    }
    @Test
    void mileToKm(){         //21 miles = 33.7 km
        assertEquals(converter.calcuate(21,"miles","km"),33.796224);
    }
}
