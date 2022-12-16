package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private static final String PURCHASED = "개를 구매했습니다.";
    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + PURCHASED);
        for(Lotto lotto : lottos) {
            lotto.viewNumbers();
        }
    }
}
