package dat.backend.entities.lotto;

import dat.backend.model.entities.lotto.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoNumberTest {

    private LottoNumber lottoNumber;

    @BeforeEach
    void setUp() {
        lottoNumber = new LottoNumber();
    }

    @Test
    void testNumber() {
        lottoNumber.setNumber(10);
        assertEquals(10, lottoNumber.getNumber());
        lottoNumber.setNumber(20);
        assertEquals(20, lottoNumber.getNumber());
    }

    @Test
    void testGenerateNumber() {
        lottoNumber.setNumber(10);
        assertEquals(10, lottoNumber.generateNumber(1, 36, new HashSet<>()).getNumber());
        int generateNumber = lottoNumber.generateNumber(12, 36, new HashSet<>()).getNumber();
        assertTrue(generateNumber >= 12 && generateNumber <= 36);
    }
}