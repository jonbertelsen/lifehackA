package dat.backend.entities.lotto;

import dat.backend.model.entities.lotto.LottoCoupon;
import dat.backend.model.entities.lotto.LottoNumber;
import dat.backend.model.entities.lotto.LottoRow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LottoCouponTest {

    private LottoCoupon lottoCoupon;

    @BeforeEach
    void setUp() {
        lottoCoupon = new LottoCoupon();
        lottoCoupon.setNumberCount(7);
        lottoCoupon.setNumberIntervalMin(1);
        lottoCoupon.setNumberIntervalMax(36);
        lottoCoupon.setTicketCount(10);
    }

    @Test
    void testNumberCount() {
        assertEquals(7, lottoCoupon.getNumberCount());
        lottoCoupon.setNumberCount(10);
        assertEquals(10, lottoCoupon.getNumberCount());
    }

    @Test
    void testNumberIntervalMin() {
        assertEquals(1, lottoCoupon.getNumberIntervalMin());
        lottoCoupon.setNumberIntervalMin(10);
        assertEquals(10, lottoCoupon.getNumberIntervalMin());
    }

    @Test
    void testNumberIntervalMax() {
        assertEquals(36, lottoCoupon.getNumberIntervalMax());
        lottoCoupon.setNumberIntervalMax(10);
        assertEquals(10, lottoCoupon.getNumberIntervalMax());
    }

    @Test
    void testTicketCount() {
        assertEquals(10, lottoCoupon.getTicketCount());
        lottoCoupon.setTicketCount(100);
        assertEquals(100, lottoCoupon.getTicketCount());
    }

    @Test
    void testAddUnwantedNumber() {
        assertTrue(lottoCoupon.addUnwantedNumber(10));
        assertTrue(lottoCoupon.addUnwantedNumber(20));
        assertFalse(lottoCoupon.addUnwantedNumber(10));
        assertFalse(lottoCoupon.addUnwantedNumber(20));
    }

    @Test
    void testRemoveUnwantedNumber() {
        lottoCoupon.addUnwantedNumber(10);
        lottoCoupon.addUnwantedNumber(20);
        assertTrue(lottoCoupon.removeUnwantedNumber(10));
        assertTrue(lottoCoupon.removeUnwantedNumber(20));
        assertFalse(lottoCoupon.removeUnwantedNumber(10));
        assertFalse(lottoCoupon.removeUnwantedNumber(20));
    }

    @Test
    void testGetUnwantedNumbers() {
        lottoCoupon.addUnwantedNumber(10);
        lottoCoupon.addUnwantedNumber(20);
        Set<Integer> unwantedNumbers = lottoCoupon.getUnwantedNumbers();
        assertEquals(2, unwantedNumbers.size());
        assertTrue(unwantedNumbers.contains(10));
        assertTrue(unwantedNumbers.contains(20));
        assertFalse(unwantedNumbers.contains(30));
    }

    @Test
    void testGenerateCoupon() {
        Map<Integer, LottoRow> rows = lottoCoupon.generateCoupon().getRows();
        assertEquals(10, rows.size());
        for (LottoRow row : rows.values()) {
            assertEquals(7, row.getNumbers().size());
            for (LottoNumber number : row.getNumbers()) {
                assertTrue(number.getNumber() >= 1 && number.getNumber() <= 36);
            }
        }
    }
}