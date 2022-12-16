package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public enum Prize {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원) - "),
    LOSE(2, false, 0, "");

    private final String format;
    private final int winningCash;
    private final int winwinningNumberCondition;
    private final boolean correctBonusNumber;

    Prize(int winningNumberCount, boolean correctBonusNumber, int winningCash, String format) {
        this.format = format;
        this.winwinningNumberCondition = winningNumberCount;
        this.correctBonusNumber = correctBonusNumber;
        this.winningCash = winningCash;
    }

    public String getFormat() {
        return format;
    }

    private static boolean isLose(Prize prize) {
        return prize.equals(LOSE);
    }

    private static long getTotalPrize(HashMap<Prize, Integer> winningResult) {
        long totalPrize = 0L;
        for (Prize prize : winningResult.keySet()) {
            if (isLose(prize)) {
                continue;
            }
            totalPrize += winningResult.get(prize) * prize.winningCash;
        }
        return totalPrize;
    }

    public static String calculateProfit(HashMap<Prize, Integer> winningResult, int payment) {
        long totalPrize = getTotalPrize(winningResult);
        return String.format("%.1f", ((double) totalPrize / payment) * 100);
    }

    public static HashMap<Prize, Integer> calculatePrizeCount
            (List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        HashMap<Prize, Integer> result = new HashMap<Prize, Integer>() {{
            put(FIRST, 0);
            put(SECOND, 0);
            put(THIRD, 0);
            put(FOURTH, 0);
            put(FIFTH, 0);
        }};

        lottos.stream()
                .forEach(lotto -> {
                            Prize prize = lotto.getPrize(winningNumbers, bonusNumber);
                            if (isLose(prize)) {
                                return;
                            }
                            int prevCount = result.get(prize);
                            result.put(prize, prevCount + 1);
                        }
                );

        return result;
    }

    public static Prize findBy(int winningNumberCount, boolean isCorrectBonusNumber) {
        if (winningNumberCount == 5 && isCorrectBonusNumber == true) {
            return FIFTH;
        }
        return Arrays.stream(Prize.values())
                .filter(prize ->
                        prize.winwinningNumberCondition == winningNumberCount && prize.correctBonusNumber == false
                )
                .findFirst()
                .orElse(LOSE);
    }
}
