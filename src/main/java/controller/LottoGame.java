package controller;

import domain.Lotto;
import domain.LottoMachine;
import view.InputView;

import java.util.List;

public class LottoGame {
    public void run() {
        int countOfPurchaseLotto = InputView.inputPurchasePrice();
        int countOfManualLotto = InputView.inputCountOfManualLotto(countOfPurchaseLotto);
        int countOfAutomaticLotto = countOfPurchaseLotto-countOfManualLotto;

        List<Lotto> allPurchasedLotto = LottoMachine.createLotto(countOfManualLotto,countOfAutomaticLotto);

    }
}
