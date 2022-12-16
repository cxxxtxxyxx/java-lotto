package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
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



    }

    public int getPayment() {
        while(true) {
            try {
                String inputPayment = Console.readLine();
                String inputPaymentRegex = "^[1-9]{1}[0-9]*[0]{3}$";
                if(!(inputPayment.matches(inputPaymentRegex))) {
                    throw new IllegalArgumentException("1000의 배수를 입력해 주세요");
                }
                return Integer.parseInt(inputPayment);
            } catch(IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }
}
