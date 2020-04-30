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

        for (int countOfFinishedLotto = 0; countOfFinishedLotto < countOfManualLotto; countOfFinishedLotto++) {
            List<Integer> manualNumbers = InputView.inputManualNumber(countOfFinishedLotto);
            allLotto.add(LottoMachine.createLotto(new ManualLottoGenerator(), manualNumbers));
        }

        for (int countOfFinishedLotto = 0; countOfFinishedLotto < countOfAutomaticLotto; countOfFinishedLotto++) {
            List<Integer> automaticNumbers = new ArrayList<>();
            allLotto.add(LottoMachine.createLotto(new AutomaticLottoGenerator(), automaticNumbers));
        }

        OutputView.printAllLotto(allLotto, countOfManualLotto, countOfAutomaticLotto);

    }
}
