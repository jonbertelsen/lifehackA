package dat.backend.entities.lotto;

import dat.backend.model.entities.lotto.LottoNumber;
import dat.backend.model.entities.lotto.LottoRow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoRowTest {

    private LottoRow lottoRow;

    @BeforeEach
    void setUp() {
        lottoRow = new LottoRow();
    }

    @Test
    void testAddNumber() {
        lottoRow.addNumber(10);
        lottoRow.addNumber(20);
        lottoRow.addNumber(30);
        assertEquals(3, lottoRow.getNumbers().size());
    }

    @Test
    void testAddLottoNumber() {
        lottoRow.addNumber(new LottoNumber(10));
        lottoRow.addNumber(new LottoNumber(20));
        lottoRow.addNumber(new LottoNumber(30));
        assertEquals(3, lottoRow.getNumbers().size());
    }

    @Test
    void testGenerateRow() {
        lottoRow.generateRow(3, 1, 36, new HashSet<>());
        assertEquals(3, lottoRow.getNumbers().size());
        for (LottoNumber lottoNumber : lottoRow.getNumbers()) {
            int number = lottoNumber.getNumber();
            assertTrue(number >= 1 && number <= 36);
        }
    }
}