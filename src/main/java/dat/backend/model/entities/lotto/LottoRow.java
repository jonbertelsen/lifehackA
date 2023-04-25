package dat.backend.model.entities.lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoRow {

    private final Set<LottoNumber> numbers = new HashSet<>();

    public LottoRow(Set<LottoNumber> numbers) {
        this.numbers.addAll(numbers);
    }

    public LottoRow() { }

    public LottoRow generateRow(int numberCount, int numberIntervalMin, int numberIntervalMax, Set<Integer> unwantedNumbers) {
        if (numbers.size() == numberCount) {
            return this;
        }

        return regenerateRow(numberCount, numberIntervalMin, numberIntervalMax, unwantedNumbers);
    }

    private LottoRow regenerateRow(int numberCount, int numberIntervalMin, int numberIntervalMax, Set<Integer> unwantedNumbers) {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 0; i < numberCount; i++) {
            numbers.add(new LottoNumber().generateNumber(numberIntervalMin, numberIntervalMax, unwantedNumbers));
        }

        this.numbers.clear();
        this.numbers.addAll(numbers);
        return this;
    }

    public Set<LottoNumber> getNumbers() {
        return this.numbers;
    }

    public void addNumber(LottoNumber number) {
        this.numbers.add(number);
    }

    public void addNumber(int number) {
        this.numbers.add(new LottoNumber(number));
    }
}