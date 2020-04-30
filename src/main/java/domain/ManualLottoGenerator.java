package domain;

import util.ChangeStringToIntList;
import view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static view.OutputView.printErrorMessage;

public class ManualLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generateLotto() {
        try {
            List<Integer> lottoNumbers = selectNumbers();
            Collections.sort(lottoNumbers);
            return new Lotto(lottoNumbers);
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
            return generateLotto();
        }
    }

    private List<Integer> selectNumbers(){
        List<Integer> lottoNumbers;

        try {
            String selectedNumbers = InputView.inputManualNumber();
            Validator.isValidNumbers(selectedNumbers);
            lottoNumbers = ChangeStringToIntList.change(selectedNumbers);
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
            return selectNumbers();
        }

        return lottoNumbers;
    }

}
