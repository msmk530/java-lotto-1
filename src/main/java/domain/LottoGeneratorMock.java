package domain;

import java.util.Arrays;

public class LottoGeneratorMock implements LottoGenerator{
    private static final int bonusNumber = 7;
    @Override
    public Lotto generateLotto() {
        return new Lotto(Arrays.asList(1,2,3,4,5,6));
    }

    public int generateBonus() {
        return bonusNumber;
    }
}
