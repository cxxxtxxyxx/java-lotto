package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.utils.RandomLottoGenerator;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void init() {
        InputView.inputPayment();
        int payment = getPayment();
        List<Lotto> lottos = RandomLottoGenerator.getPurchasedLottos(payment);
        OutputView.printPurchasedLottos(lottos);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber;
        while(true) {
            try {
                bonusNumber = getBonusNumber();
                Validator.checkDuplicatedNumber(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }



    }

    private int getBonusNumber() {
        while(true) {
            try {
                InputView.inputBonusNumber();
                String inputBonusNumber = Console.readLine();
                Validator.checkBonusNumberFormat(inputBonusNumber);
                return Integer.parseInt(inputBonusNumber);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                InputView.inputWinningNumbers();
                String inputWinningNumbers = Console.readLine();
                Validator.checkWinningNumbersFormat(inputWinningNumbers);
                return Arrays.stream(inputWinningNumbers.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    public int getPayment() {
        while (true) {
            try {
                String inputPayment = Console.readLine();
                String inputPaymentRegex = "^[1-9]{1}[0-9]*[0]{3}$";
                if (!(inputPayment.matches(inputPaymentRegex))) {
                    throw new IllegalArgumentException("1000의 배수를 입력해 주세요");
                }
                return Integer.parseInt(inputPayment);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
