package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

import static view.OutputView.printErrorMessage;
import static view.OutputView.printMessage;

public class LottoGame {
    public void run() {
        final int countOfPurchaseLotto = InputView.inputPurchasePrice();
        final int countOfManualLotto = InputView.inputCountOfManualLotto(countOfPurchaseLotto);
        final int countOfAutomaticLotto = countOfPurchaseLotto - countOfManualLotto;

        inputManualLotto(countOfManualLotto);
        LottoMachine.completeAllLotto(countOfAutomaticLotto);

        OutputView.printAllLotto(countOfManualLotto, countOfAutomaticLotto);

        Lotto winningNumberLotto = inputWinningNumber();
        WinningLotto winningLotto = inputBonusNumber(winningNumberLotto);

        GameResult gameResult = new GameResult(countOfPurchaseLotto, winningLotto);
        OutputView.printResult(gameResult);
    }

    private static void inputManualLotto(int countOfManualLotto) {
        int countOfFinishedLotto = 0;

        do {
            String numbers = InputView.inputManualNumber(countOfFinishedLotto);

            if (LottoMachine.createManualLotto(numbers) != null) {
                AllLotto.addLotto(LottoMachine.createManualLotto(numbers));
                countOfFinishedLotto++;
            }
        } while (!AllLotto.isCheckLottoCount(countOfManualLotto));
    }

    private static Lotto inputWinningNumber() {
        String numbers;

        do {
            numbers = InputView.inputWinningLottoNumbers();
        } while (LottoMachine.createManualLotto(numbers) == null);

        return LottoMachine.createManualLotto(numbers);
    }

    private static WinningLotto inputBonusNumber(Lotto winnningNumberLotto) {
        int bonus;
        WinningLotto winningLotto;

        try {
            bonus = InputView.inputBonus();
            winningLotto = LottoMachine.createWinningLotto(winnningNumberLotto, bonus);
            return winningLotto;
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
            return inputBonusNumber(winnningNumberLotto);
        }
    }

}
