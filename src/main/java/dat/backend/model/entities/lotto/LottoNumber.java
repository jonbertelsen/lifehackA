package dat.backend.model.entities.lotto;

import java.util.Set;

/**
 * The {@code LottoNumber} class represents a lotto number.
 * @author Peter
 */
public class LottoNumber {

    /**
     * The integer number that represents the {@link LottoNumber}.
     */
    private int number;

    /**
     * Constructs a {@link LottoNumber} with the given number.
     *
     * @param number the number that represents the lotto number.
     */
    public LottoNumber(int number) {
        this.number = number;
    }

    /**
     * Constructs an empty {@link LottoNumber}
     */
    public LottoNumber() { }

    /**
     * Generates a {@link LottoNumber} based on specific criteria.
     *
     * @param numberIntervalMin the minimum number in the number interval.
     * @param numberIntervalMax the maximum number in the number interval.
     * @param unwantedNumbers   a set of unwanted numbers that should not be generated.
     * @author Peter
     * @return the generated {@link LottoNumber}.
     */
    public LottoNumber generateNumber(int numberIntervalMin, int numberIntervalMax, Set<Integer> unwantedNumbers) {
        if (this.number >= numberIntervalMin && this.number <= numberIntervalMax && !unwantedNumbers.contains(this.number)) {
            return this;
        }

        return regenerateNumber(numberIntervalMin, numberIntervalMax, unwantedNumbers);
    }

    /**
     * Helper method that generates a {@link LottoNumber} based on specific criteria.
     *
     * @param numberIntervalMin the minimum number in the number interval.
     * @param numberIntervalMax the maximum number in the number interval.
     * @param unwantedNumbers   a set of unwanted numbers that should not be generated.
     * @author Peter
     * @return the regenerated {@link LottoNumber}.
     */
    private LottoNumber regenerateNumber(int numberIntervalMin, int numberIntervalMax, Set<Integer> unwantedNumbers) {
        while (true) {
            int currentNum = (int) (Math.random() * (numberIntervalMax - numberIntervalMin + 1)) + numberIntervalMin;
            if (!unwantedNumbers.contains(currentNum)) {
                this.number = currentNum;
                return this;
            }
        }
    }

    /**
     * Returns the number that represents the {@link LottoNumber}.
     *
     * @return the number that represents the {@link LottoNumber}.
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * Sets the number that represents the {@link LottoNumber}.
     *
     * @param number the number that represents the {@link LottoNumber}.
     */
    public void setNumber(int number) {
        this.number = number;
    }
}