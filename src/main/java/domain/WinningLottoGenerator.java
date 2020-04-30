package domain;

import util.ChangeStringToIntList;
import view.InputView;

import java.util.Collections;
import java.util.List;

import static view.OutputView.printErrorMessage;

public class WinningLottoGenerator implements LottoGenerator{
    @Override
    public Lotto generateLotto() {
        List<Integer> lottoNumbers = makeNumbers();
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    private List<Integer> makeNumbers(){
        List<Integer> lottoNumbers;

        try {
            String selectedNumbers = InputView.inputWinningLottoNumbers();
            Validator.isValidNumbers(selectedNumbers);
            lottoNumbers = ChangeStringToIntList.change(selectedNumbers);
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
            return makeNumbers();
        }

        return lottoNumbers;
    }
}
