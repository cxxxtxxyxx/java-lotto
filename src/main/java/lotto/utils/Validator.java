package lotto.utils;

import java.util.List;

public class Validator {

    private static final String INPUT_NOT_CONTAIN_WINNING_NUMBERS = "당첨 번호에 속하지 않은 보너스 번호를 입력해 주세요";
    private static final String INPUT_NUMBER_IN_LOTTO_RANGE = "1-45 사이의 숫자를 입력해 주세요";
    private static final String INPUT_WINNING_NUMBER_VALID_FORMAT = "당첨 번호 형식에 맞도록 입력해주세요";
    private static final String INPUT_BONUS_NUMBER_REGEX = "(^[1-9]{1}$)|(^1[0-9]{1}$)|(^2[0-9]{1}$)|(^3[0-9]{1}$)|(^4[0-5]{1}$)";
    private static final String INPUT_WINNING_NUMBERS_REGEX =
            "^((([1-9]{1})|(1[0-9]{1})|(2[0-9]{1})|(3[0-9]{1})|(4[0-5]{1})),){5}"
                    + "(([1-9]{1})|(1[0-9]{1})|(2[0-9]{1})|(3[0-9]{1})|(4[0-5]{1}))$";

    public static void checkDuplicatedNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(INPUT_NOT_CONTAIN_WINNING_NUMBERS);
        }
    }

    public static void checkBonusNumberFormat(String inputBonusNumber) {
        if (!(inputBonusNumber.matches(INPUT_BONUS_NUMBER_REGEX))) {
            throw new IllegalArgumentException(INPUT_NUMBER_IN_LOTTO_RANGE);
        }
    }

    public static void checkWinningNumbersFormat(String inputWinningNumbers) {
        if (!(inputWinningNumbers.matches(INPUT_WINNING_NUMBERS_REGEX))) {
            throw new IllegalArgumentException(INPUT_WINNING_NUMBER_VALID_FORMAT);
        }
    }
}
