package domain;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private LottoGenerator() {
        throw new AssertionError();
    }

    public static Lotto generateLotto(List<Integer> numbers) {
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
