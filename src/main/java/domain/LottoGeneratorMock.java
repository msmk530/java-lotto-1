package domain;

import java.util.Arrays;
import java.util.List;

public class LottoGeneratorMock implements LottoGenerator{
    private static final int bonusNumber = 7;

    @Override
    public Lotto generateLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public int generateBonus() {
        return bonusNumber;
    }
}
