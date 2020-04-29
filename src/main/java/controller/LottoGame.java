package controller;

import domain.Lotto;
import domain.LottoMachine;
import view.InputView;

import java.util.List;

public class LottoGame {
    public void run() {
        int countOfPurchaseLotto = InputView.inputPurchasePrice();
        int countOfManualLotto = InputView.inputCountOfManualLotto(countOfPurchaseLotto);

        List<Lotto> purchasedAllLotto = LottoMachine.createLotto(countOfPurchaseLotto,countOfManualLotto);

    }
}
