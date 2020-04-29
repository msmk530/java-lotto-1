package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generateLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

}
