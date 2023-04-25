package dat.backend.model.entities.lotto;

import java.util.List;

public class LottoNumber {

    private int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public LottoNumber() { }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LottoNumber generateNumber(int numberIntervalMin, int numberIntervalMax, List<Integer> unwantedNumbers) {
        if (this.number < numberIntervalMin || this.number > numberIntervalMax || !unwantedNumbers.contains(this.number)) {
            return this;
        }

        return regenerateNumber(numberIntervalMin, numberIntervalMax, unwantedNumbers);
    }

    private LottoNumber regenerateNumber(int numberIntervalMin, int numberIntervalMax, List<Integer> unwantedNumbers) {
        while (true) {
            int currentNum = (int) (Math.random() * (numberIntervalMax - numberIntervalMin + 1)) + numberIntervalMin;
            if (!unwantedNumbers.contains(currentNum)) {
                this.number = currentNum;
                return this;
            }
        }
    }
}