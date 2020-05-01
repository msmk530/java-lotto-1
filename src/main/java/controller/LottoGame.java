package controller;

import domain.*;
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

        allLotto.addAll(LottoMachine.createManualLotto(countOfManualLotto));
        allLotto.addAll(LottoMachine.createAutomaticLotto(countOfAutomaticLotto));

        OutputView.printAllLotto(allLotto, countOfManualLotto, countOfAutomaticLotto);

        WinningLotto winningLotto = LottoMachine.createWinningLotto();
        GameResult gameResult = new GameResult(countOfPurchaseLotto, allLotto, winningLotto);
        OutputView.printResult(gameResult);
    }


}
