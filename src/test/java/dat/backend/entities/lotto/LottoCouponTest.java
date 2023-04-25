package dat.backend.entities.lotto;

import dat.backend.model.entities.lotto.LottoCoupon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LottoCouponTest {

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
        List<Integer> unwantedNumbers = lottoCoupon.getUnwantedNumbers();
        assertEquals(2, unwantedNumbers.size());
        assertTrue(unwantedNumbers.contains(10));
        assertTrue(unwantedNumbers.contains(20));
        assertFalse(unwantedNumbers.contains(30));
    }

    @Test
    void testGenerateTickets() {
        Map<Integer, List<Integer>> tickets = lottoCoupon.generateTickets();
        assertEquals(10, tickets.size());
        for (List<Integer> ticket : tickets.values()) {
            assertEquals(7, ticket.size());
            for (Integer number : ticket) {
                assertTrue(number >= 1 && number <= 36);
            }
        }
    }
}