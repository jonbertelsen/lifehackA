package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCoupon {

    private final List<Integer> unwantedNumbers = new ArrayList<>();

    private int numberCount = 7;
    private int numberIntervalMin = 1;
    private int numberIntervalMax = 36;
    private int ticketCount = 10;

    public LottoCoupon() { }

    public int getNumberCount() {
        return this.numberCount;
    }

    public void setNumberCount(int numberCount) {
        this.numberCount = numberCount;
    }

    public int getNumberIntervalMin() {
        return this.numberIntervalMin;
    }

    public void setNumberIntervalMin(int numberIntervalMin) {
        this.numberIntervalMin = numberIntervalMin;
    }

    public int getNumberIntervalMax() {
        return this.numberIntervalMax;
    }

    public void setNumberIntervalMax(int numberIntervalMax) {
        this.numberIntervalMax = numberIntervalMax;
    }

    public int getTicketCount() {
        return this.ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public boolean addUnwantedNumber(int number) {
        if (this.unwantedNumbers.contains(number)) {
            return false;
        }

        this.unwantedNumbers.add(number);
        return true;
    }

    public boolean removeUnwantedNumber(int number) {
        if (!this.unwantedNumbers.contains(number)) {
            return false;
        }

        this.unwantedNumbers.remove(number);
        return true;
    }

    public Map<Integer, List<Integer>> generateTickets() {
        Map<Integer, List<Integer>> tickets = new HashMap<>();
        for (int i = 1; i <= this.ticketCount; i++) {
            tickets.put(i, this.generateNumbers());
        }
        return tickets;
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < this.numberCount; i++) {
            Integer currentNum = null;
            while (currentNum == null || this.unwantedNumbers.contains(currentNum)) {
                currentNum = (int) (Math.random() * (this.numberIntervalMax - this.numberIntervalMin + 1)) + this.numberIntervalMin;
            }
            numbers.add(currentNum);
        }
        return numbers;
    }
}