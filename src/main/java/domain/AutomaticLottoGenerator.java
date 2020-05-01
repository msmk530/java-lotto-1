package domain;

import java.util.Collections;
import java.util.List;

public class AutomaticLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generateLotto(List<Integer> lottonumbers) {
        Collections.sort(lottonumbers);
        return new Lotto(lottonumbers);
    }
}
