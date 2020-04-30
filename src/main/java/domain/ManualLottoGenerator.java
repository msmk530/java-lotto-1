package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generateLotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

}
