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

        allLotto.addAll(LottoMachine.createManualLotto(new ManualLottoGenerator(), countOfManualLotto));
        allLotto.addAll(LottoMachine.createAutomaticLotto(new AutomaticLottoGenerator(), countOfAutomaticLotto));

        OutputView.printAllLotto(allLotto, countOfManualLotto, countOfAutomaticLotto);

        List<Integer> winningNumbers = InputView.inputWinningLottoNumbers();
        int bonus = InputView.inputBonus(winningNumbers);

        WinningLotto winningLotto = LottoMachine.createWinningLotto(winningNumbers, bonus);
        GameResult gameResult = new GameResult(countOfPurchaseLotto, allLotto, winningLotto);
        OutputView.printResult(gameResult);
    }


}
