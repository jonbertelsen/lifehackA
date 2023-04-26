package dat.backend.model.entities.lotto;

import java.util.*;

/**
 * The {@code LottoCoupon} class represents a coupon for a lottery game, containing multiple {@link LottoRow}.
 * @author Peter
 */
public class LottoCoupon {

    private final Map<Integer, LottoRow> rows = new HashMap<>();
    private final Set<Integer> unwantedNumbers = new HashSet<>();

    private int numberCount = 7;
    private int numberIntervalMin = 1;
    private int numberIntervalMax = 36;
    private int ticketCount = 10;

    /**
     * Constructs a {@link LottoCoupon} object with the given parameters.
     *
     * @param numberCount The number of LottoNumbers in each LottoRow.
     * @param numberIntervalMin The minimum value for each LottoNumber in a LottoRow.
     * @param numberIntervalMax The maximum value for each LottoNumber in a LottoRow.
     * @param ticketCount The number of LottoRows in the LottoCoupon.
     * @param unwantedNumbers The set of unwanted numbers that should not be present in any {@link LottoRow}.
     * @param rows The map of LottoRows for this {@link LottoCoupon}.
     */
    public LottoCoupon(int numberCount, int numberIntervalMin, int numberIntervalMax, int ticketCount, Set<Integer> unwantedNumbers, Map<Integer, LottoRow> rows) {
        this.numberCount = numberCount;
        this.numberIntervalMin = numberIntervalMin;
        this.numberIntervalMax = numberIntervalMax;
        this.ticketCount = ticketCount;
        this.unwantedNumbers.addAll(unwantedNumbers);
        this.rows.putAll(rows);
    }

    /**
     * Constructs a {@link LottoCoupon} object with the given parameters, and no rows.
     *
     * @param numberCount The number of LottoNumbers in each LottoRow.
     * @param numberIntervalMin The minimum value for each LottoNumber in a LottoRow.
     * @param numberIntervalMax The maximum value for each LottoNumber in a LottoRow.
     * @param ticketCount The number of LottoRows in the LottoCoupon.
     */
    public LottoCoupon(int numberCount, int numberIntervalMin, int numberIntervalMax, int ticketCount) {
        this.numberCount = numberCount;
        this.numberIntervalMin = numberIntervalMin;
        this.numberIntervalMax = numberIntervalMax;
        this.ticketCount = ticketCount;
    }

    /**
     * Constructs an empty {@link LottoCoupon} object.
     */
    public LottoCoupon() { }

    /**
     * Generates a {@link LottoCoupon} based on specific criteria.
     *
     * @author Peter
     * @return The {@link LottoCoupon} with generated rows (if necessary).
     */
    public LottoCoupon generateCoupon() {
        if (this.rows.size() == this.ticketCount) {
            return this;
        }

        return regenerateCoupon();
    }

    /**
     * Helper method that generates a {@link LottoCoupon} based on specific criteria.
     *
     * @author Peter
     * @return The {@link LottoCoupon} with regenerated rows.
     */
    private LottoCoupon regenerateCoupon() {
        Map<Integer, LottoRow> rows = new HashMap<>();
        for (int i = 1; i <= this.ticketCount; i++) {
            rows.put(i, new LottoRow().generateRow(this.numberCount, this.numberIntervalMin, this.numberIntervalMax, this.unwantedNumbers));
        }

        this.rows.clear();
        this.rows.putAll(rows);
        return this;
    }

    /**
     * Returns the number of {@link LottoNumber}s in each {@link LottoRow}.
     *
     * @return The number of {@link LottoNumber}s in each {@link LottoRow}.
     */
    public int getNumberCount() {
        return this.numberCount;
    }

    /**
     * Sets the number of {@link LottoNumber}s in each {@link LottoRow}.
     *
     * @param numberCount The number of {@link LottoNumber}s in each {@link LottoRow}.
     */
    public void setNumberCount(int numberCount) {
        this.numberCount = numberCount;
    }

    /**
     * Returns the minimum value for each {@link LottoNumber} in a {@link LottoRow}.
     *
     * @return The minimum value for each {@link LottoNumber} in a {@link LottoRow}.
     */
    public int getNumberIntervalMin() {
        return this.numberIntervalMin;
    }

    /**
     * Sets the minimum value for each {@link LottoNumber} in a {@link LottoRow}.
     *
     * @param numberIntervalMin The minimum value for each {@link LottoNumber} in a {@link LottoRow}.
     */
    public void setNumberIntervalMin(int numberIntervalMin) {
        this.numberIntervalMin = numberIntervalMin;
    }

    /**
     * Returns the maximum value for each {@link LottoNumber} in a {@link LottoRow}.
     *
     * @return The maximum value for each {@link LottoNumber} in a {@link LottoRow}.
     */
    public int getNumberIntervalMax() {
        return this.numberIntervalMax;
    }

    /**
     * Sets the maximum value for each {@link LottoNumber} in a {@link LottoRow}.
     *
     * @param numberIntervalMax The maximum value for each {@link LottoNumber} in a {@link LottoRow}.
     */
    public void setNumberIntervalMax(int numberIntervalMax) {
        this.numberIntervalMax = numberIntervalMax;
    }

    /**
     * Returns the number of {@link LottoRow}s in the {@link LottoCoupon}.
     *
     * @return The number of {@link LottoRow}s in the {@link LottoCoupon}.
     */
    public int getTicketCount() {
        return this.ticketCount;
    }

    /**
     * Sets the number of {@link LottoRow}s in the {@link LottoCoupon}.
     *
     * @param ticketCount The number of {@link LottoRow}s in the {@link LottoCoupon}.
     */
    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    /**
     * Returns the set of unwanted numbers that should not be present in any {@link LottoRow}.
     *
     * @return The set of unwanted numbers that should not be present in any {@link LottoRow}.
     */
    public Set<Integer> getUnwantedNumbers() {
        return this.unwantedNumbers;
    }

    /**
     * Adds an unwanted number to the set of unwanted numbers.
     *
     * @param number The number to add to the set of unwanted numbers.
     * @return True if the number was added, false otherwise.
     */
    public boolean addUnwantedNumber(int number) {
        return this.unwantedNumbers.add(number);
    }

    /**
     * Removes an unwanted number from the set of unwanted numbers.
     *
     * @param number The number to remove from the set of unwanted numbers.
     * @return True if the number was removed, false otherwise.
     */
    public boolean removeUnwantedNumber(int number) {
        return this.unwantedNumbers.remove(number);
    }

    /**
     * Returns the map of {@link LottoRow}s for this {@link LottoCoupon}.
     *
     * @return The map of {@link LottoRow}s for this {@link LottoCoupon}.
     */
    public Map<Integer, LottoRow> getRows() {
        return this.rows;
    }

    /**
     * Adds a {@link LottoRow} to the map of {@link LottoRow}s for this {@link LottoCoupon}.
     *
     * @param rowNumber The key for the {@link LottoRow}.
     * @param row The {@link LottoRow} to add to the map.
     */
    public void addRow(int rowNumber, LottoRow row) {
        this.rows.put(rowNumber, row);
    }

    /**
     * Removes a {@link LottoRow} from the map of {@link LottoRow}s for this {@link LottoCoupon}.
     *
     * @param rowNumber The key for the {@link LottoRow} to remove.
     */
    public void removeRow(int rowNumber) {
        this.rows.remove(rowNumber);
    }
}