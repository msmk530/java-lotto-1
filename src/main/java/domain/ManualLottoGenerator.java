package domain;

import java.util.Collections;
import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generateLotto(List<Integer> lottoNumbers) {
        List<Integer> selectedNumbers = validateLottoNumbers(lottoNumbers);

        Collections.sort(selectedNumbers);
        return new Lotto(selectedNumbers);
    }

    private List<Integer> validateLottoNumbers(List<Integer> selectedNumbers) {
        Validator.isValidNumbers(selectedNumbers);
        return selectedNumbers;
    }
}
