package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void viewNumbers() {
        System.out.println(numbers);
    }

    public Prize getPrize(List<Integer> winningNumbers, int bonusNumber) {
        int winningNumberCount = 0;
        boolean isCorrectBonusNumber = false;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                winningNumberCount++;
            }
            if (bonusNumber == number) {
                isCorrectBonusNumber = true;
            }
        }

        return Prize.findBy(winningNumberCount, isCorrectBonusNumber);
    }

    // TODO: 추가 기능 구현
}
