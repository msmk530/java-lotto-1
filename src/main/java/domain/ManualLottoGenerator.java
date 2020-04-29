package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {

    @Override
    public List<Lotto> generateLotto(int countOfPurchaseLotto, int countOfManualLotto) {
        List<Lotto> manualLottoes = new ArrayList<>();

        for (int i = 0; i < countOfManualLotto; i++) {
            List<Integer> selectManualNumber = InputView.inputManualNumber();
            manualLottoes.add(new Lotto(selectManualNumber));
        }

        return manualLottoes;
    }
}
