package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    public static Lotto createLotto(LottoGenerator strategy, List<Integer> numbers) {
        return strategy.generateLotto(numbers);
    }

}
