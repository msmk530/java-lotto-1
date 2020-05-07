package domain;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        Validator.isValidNumbers(lotto.getNumbers());
        Validator.isValidBonusNumber(bonus, lotto.getNumbers());
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = userLotto.countMatch(lotto);
        boolean matchBonus = userLotto.containNumber(bonus);

        return Rank.valueOf(countOfMatch, matchBonus);
    }

    public boolean compareLotto(List<Integer> numbers, int number) {
        return lotto.getNumbers().containsAll(numbers) && bonus == number;
    }
}
