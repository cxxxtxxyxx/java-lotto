package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;

public class LottoController {
    public void init() {
        InputView.inputPayment();
        String inputPayment = Console.readLine();
        String inputPaymentRegex = "^[1-9]{1}[0-9]*[0]{3}$";
        if(!(inputPayment.matches(inputPaymentRegex))) {
            throw new IllegalArgumentException("1000의 배수를 입력해 주세요");
        }
    }
}
