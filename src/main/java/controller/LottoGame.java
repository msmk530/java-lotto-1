package controller;

import domain.AutomaticLottoGenerator;
import domain.Lotto;
import domain.LottoMachine;
import domain.ManualLottoGenerator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public void run() {
        int countOfPurchaseLotto = InputView.inputPurchasePrice();
        int countOfManualLotto = InputView.inputCountOfManualLotto(countOfPurchaseLotto);
        int countOfAutomaticLotto = countOfPurchaseLotto - countOfManualLotto;
        List<Lotto> allLotto = new ArrayList<>();

        for (int i = 0; i < countOfManualLotto; i++) {
            List<Integer> manualNumbers = InputView.inputManualNumber(i);
            allLotto.add(LottoMachine.createLotto(new ManualLottoGenerator(), manualNumbers));
        }

        for (int i = 0; i < countOfAutomaticLotto; i++) {
            List<Integer> automaticNumbers = new ArrayList<>();
            allLotto.add(LottoMachine.createLotto(new AutomaticLottoGenerator(), automaticNumbers));
        }

        OutputView.printAllLotto(allLotto, countOfManualLotto, countOfAutomaticLotto);

    }
}
