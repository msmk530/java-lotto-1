package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public void run() {
        final int countOfPurchaseLotto = InputView.inputPurchasePrice();
        final int countOfManualLotto = InputView.inputCountOfManualLotto(countOfPurchaseLotto);
        final int countOfAutomaticLotto = countOfPurchaseLotto - countOfManualLotto;

        AllLotto allLotto = new AllLotto(countOfManualLotto,countOfAutomaticLotto);

        OutputView.printAllLotto(allLotto, countOfManualLotto, countOfAutomaticLotto);

        WinningLotto winningLotto = LottoMachine.createWinningLotto();
        GameResult gameResult = new GameResult(countOfPurchaseLotto, allLotto, winningLotto);
        OutputView.printResult(gameResult);
    }


}
