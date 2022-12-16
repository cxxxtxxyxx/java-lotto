package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.utils.Converter;
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
        int bonusNumber = getBonusNumber(winningNumbers);
        HashMap<Prize, Integer> prizeResult = Prize.calculatePrizeCount(lottos, winningNumbers, bonusNumber);
        String profit = Prize.calculateProfit(prizeResult, payment);
        OutputView.printWinningResult(prizeResult, profit);

    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                InputView.inputBonusNumber();
                String inputBonusNumber = Console.readLine();
                Validator.checkBonusNumberFormat(inputBonusNumber);
                Validator.checkDuplicatedNumber(winningNumbers, Integer.parseInt(inputBonusNumber));
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
                return Converter.stringArrayToIntegerList(inputWinningNumbers.split(","));

            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    public int getPayment() {
        while (true) {
            try {
                String inputPayment = Console.readLine();
                Validator.checkPaymentFormat(inputPayment);
                return Integer.parseInt(inputPayment);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
