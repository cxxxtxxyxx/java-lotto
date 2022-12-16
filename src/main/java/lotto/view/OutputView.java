package lotto.view;

import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Prize;

public class OutputView {
    private static final String PURCHASED = "개를 구매했습니다.";
    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + PURCHASED);
        for(Lotto lotto : lottos) {
            lotto.viewNumbers();
        }
    }

    public static void printError(IllegalArgumentException e) {
        System.out.println(e);
    }

    public static void printWinningResult(HashMap<Prize, Integer> winningResult, String profit) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Prize.FIFTH.getFormat() + winningResult.get(Prize.FIFTH) + "개");
        System.out.println(Prize.FOURTH.getFormat() + winningResult.get(Prize.FOURTH) + "개");
        System.out.println(Prize.THIRD.getFormat() + winningResult.get(Prize.THIRD) + "개");
        System.out.println(Prize.SECOND.getFormat() + winningResult.get(Prize.SECOND) + "개");
        System.out.println(Prize.FIRST.getFormat() + winningResult.get(Prize.FIRST) + "개");
        System.out.println("총 수익률은 " + profit + "%입니다.");


    }
}
