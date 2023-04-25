package dat.backend.model.entities.lotto;

import java.util.*;

public class LottoCoupon {

    private final Map<Integer, LottoRow> rows = new HashMap<>();
    private final Set<Integer> unwantedNumbers = new HashSet<>();

    private int numberCount = 7;
    private int numberIntervalMin = 1;
    private int numberIntervalMax = 36;
    private int ticketCount = 10;

    public LottoCoupon(int numberCount, int numberIntervalMin, int numberIntervalMax, int ticketCount, Set<Integer> unwantedNumbers, Map<Integer, LottoRow> rows) {
        this.numberCount = numberCount;
        this.numberIntervalMin = numberIntervalMin;
        this.numberIntervalMax = numberIntervalMax;
        this.ticketCount = ticketCount;
        this.unwantedNumbers.addAll(unwantedNumbers);
        this.rows.putAll(rows);
    }

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

    public Set<Integer> getUnwantedNumbers() {
        return this.unwantedNumbers;
    }

    public boolean addUnwantedNumber(int number) {
        return this.unwantedNumbers.add(number);
    }

    public boolean removeUnwantedNumber(int number) {
        return this.unwantedNumbers.remove(number);
    }

    public Map<Integer, LottoRow> getRows() {
        return this.rows;
    }

    public LottoRow getRow(int rowNumber) {
        return this.rows.get(rowNumber);
    }

    public void addRow(int rowNumber, LottoRow row) {
        this.rows.put(rowNumber, row);
    }

    public void removeRow(int rowNumber) {
        this.rows.remove(rowNumber);
    }

    public LottoCoupon generateCoupon() {
        if (this.rows.size() == this.ticketCount) {
            return this;
        }

        return regenerateCoupon();
    }

    public LottoCoupon regenerateCoupon() {
        Map<Integer, LottoRow> rows = new HashMap<>();
        for (int i = 1; i <= this.ticketCount; i++) {
            rows.put(i, new LottoRow().generateRow(this.numberCount, this.numberIntervalMin, this.numberIntervalMax, this.unwantedNumbers));
        }

        this.rows.clear();
        this.rows.putAll(rows);
        return this;
    }

    public Map<Integer, List<Integer>> generateTickets() {
        Map<Integer, List<Integer>> tickets = new HashMap<>();
        for (int i = 1; i <= this.ticketCount; i++) {
            tickets.put(i, this.generateTicket());
        }
        return tickets;
    }

    private List<Integer> generateTicket() {
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