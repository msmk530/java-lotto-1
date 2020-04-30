package domain;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = userLotto.countMatch(lotto);
        boolean matchBonus = userLotto.containNumber(bonus);
        return Rank.valueOf(countOfMatch, matchBonus);

    }


    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }

}
