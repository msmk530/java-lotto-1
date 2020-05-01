package domain;

import java.util.List;

import static view.OutputView.printErrorMessage;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        validateBonusNumber(bonus,lotto.getNumbers());
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = userLotto.countMatch(lotto);
        boolean matchBonus = userLotto.containNumber(bonus);

        return Rank.valueOf(countOfMatch, matchBonus);
    }

    private void validateBonusNumber(int bonus, List<Integer> numbers){
        Validator.isValidBonusNumber(bonus,numbers);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }

}
