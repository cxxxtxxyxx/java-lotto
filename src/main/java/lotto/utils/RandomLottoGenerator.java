package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class RandomLottoGenerator {
    public static List<Lotto> getPurchasedLottos(int payment) {
        int totalCount = payment / 1000;
        List<Lotto> purchasedLottos = new ArrayList<Lotto>();
        for(int i = 0; i < totalCount; i++) {
            List<Integer> lottonumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottonumbers);
            purchasedLottos.add(new Lotto(lottonumbers));
        }

        return purchasedLottos;
    }
}
