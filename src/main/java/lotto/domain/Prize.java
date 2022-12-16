package lotto.domain;

public enum Prize {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, true, 30_000_000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
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
}
