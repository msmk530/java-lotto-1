package domain;

import java.util.Collections;
import java.util.List;

public class WinningLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generateLotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

}
