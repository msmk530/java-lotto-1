package domain;

import java.util.Collections;
import java.util.List;

public class AutomaticLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generateLotto(List<Integer> numbers) {
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
