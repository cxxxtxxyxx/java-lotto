package lotto.view;

public class InputView {

    private static final String INPUT_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void inputPayment() {
        System.out.println(INPUT_PAYMENT);
    }

    public static void inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
    }

    public static void inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }
}
