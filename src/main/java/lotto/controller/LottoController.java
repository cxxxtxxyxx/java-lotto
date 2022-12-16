package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.utils.RandomLottoGenerator;
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
                if(winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException("당첨 번호에 속하지 않은 보너스 번호를 입력해 주세요");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }



    }

    private int getBonusNumber() {
        while(true) {
            try {
                String inputBonusNumber = Console.readLine();
                String inputBonusNumberRegex = "^[1-45]$";
                if(!(inputBonusNumber.matches(inputBonusNumberRegex))) {
                    throw new IllegalArgumentException("1-45 사이의 숫자를 입력해 주세요");
                }
                return Integer.parseInt(inputBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = Console.readLine();
                String inputWinningNumbersRegex = "^[1-45],[1-45],[1-45],[1-45],[1-45],[1-45]$";
                if (!(inputWinningNumbers.matches(inputWinningNumbersRegex))) {
                    throw new IllegalArgumentException("형식에 맞도록 입력해주세요");
                }
                return Arrays.stream(inputWinningNumbers.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                System.out.println(e);
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
                System.out.println(e);
            }
        }
    }
}
