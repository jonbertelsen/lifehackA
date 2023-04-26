package dat.backend.model.entities.lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The {@code LottoRow} class represents a row of {@link LottoNumber}.
 * @author Peter
 */
public class LottoRow {

    /**
     * The set of {@link LottoNumber} that represents the row of {@link LottoNumber}.
     */
    private final Set<LottoNumber> numbers = new HashSet<>();

    /**
     * Constructs a {@link LottoRow} with the given set of {@link LottoNumber}.
     *
     * @param numbers the set of {@link LottoNumber} that represents the row of {@link LottoNumber}.
     */
    public LottoRow(Set<LottoNumber> numbers) {
        this.numbers.addAll(numbers);
    }

    /**
     * Constructs an empty {@link LottoRow} with no {@link LottoNumber}.
     */
    public LottoRow() { }

    /**
     * Generates a {@link LottoRow} based on specific criteria.
     *
     * @param numberCount      the number of lotto numbers in the row.
     * @param numberIntervalMin the minimum number in the number interval.
     * @param numberIntervalMax the maximum number in the number interval.
     * @param unwantedNumbers   a set of unwanted numbers that should not be generated.
     * @author Peter
     * @return the generated {@link LottoRow}.
     */
    public LottoRow generateRow(int numberCount, int numberIntervalMin, int numberIntervalMax, Set<Integer> unwantedNumbers) {
        if (numbers.size() == numberCount) {
            return this;
        }

        return regenerateRow(numberCount, numberIntervalMin, numberIntervalMax, unwantedNumbers);
    }

    /**
     * Helper method that generates a {@link LottoRow} based on specific criteria.
     *
     * @param numberCount      the number of lotto numbers in the row.
     * @param numberIntervalMin the minimum number in the number interval.
     * @param numberIntervalMax the maximum number in the number interval.
     * @param unwantedNumbers   a set of unwanted numbers that should not be generated.
     * @author Peter
     * @return the regenerated {@link LottoRow}.
     */
    private LottoRow regenerateRow(int numberCount, int numberIntervalMin, int numberIntervalMax, Set<Integer> unwantedNumbers) {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 0; i < numberCount; i++) {
            numbers.add(new LottoNumber().generateNumber(numberIntervalMin, numberIntervalMax, unwantedNumbers));
        }

        this.numbers.clear();
        this.numbers.addAll(numbers);
        return this;
    }

    /**
     * Returns the set of {@link LottoNumber} that represents the row of {@link LottoNumber}.
     *
     * @return the set of {@link LottoNumber} that represents the row of {@link LottoNumber}.
     */
    public Set<LottoNumber> getNumbers() {
        return this.numbers;
    }

    /**
     * Adds a {@link LottoNumber} to the row of {@link LottoNumber}.
     *
     * @param number the lotto number to be added.
     */
    public void addNumber(LottoNumber number) {
        this.numbers.add(number);
    }

    /**
     * Adds a {@link LottoNumber} to the row of {@link LottoNumber} based on its integer value.
     *
     * @param number the integer value that represents the {@link LottoNumber} to be added.
     */
    public void addNumber(int number) {
        this.numbers.add(new LottoNumber(number));
    }
}