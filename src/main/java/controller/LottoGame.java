package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import static view.OutputView.printErrorMessage;

public class LottoGame {
    public void run() {
        final int countOfPurchaseLotto = InputView.inputPurchasePrice();
        final int countOfManualLotto = InputView.inputCountOfManualLotto(countOfPurchaseLotto);
        final int countOfAutomaticLotto = countOfPurchaseLotto - countOfManualLotto;
        LottoRepository lottoRepository = new LottoRepository();

        inputManualLotto(lottoRepository, countOfManualLotto);
        LottoMachine.completeAllLotto(lottoRepository, countOfAutomaticLotto);

        OutputView.printAllLotto(lottoRepository, countOfManualLotto, countOfAutomaticLotto);

        Lotto winningNumberLotto = inputWinningNumber();
        WinningLotto winningLotto = inputBonusNumber(winningNumberLotto);

        GameResult gameResult = new GameResult(lottoRepository, countOfPurchaseLotto, winningLotto);
        OutputView.printResult(gameResult);
    }

    private static void inputManualLotto(LottoRepository lottoRepository, int countOfManualLotto) {
        int countOfFinishedLotto = 0;

        do {
            String numbers = InputView.inputManualNumber(countOfFinishedLotto);

            if (LottoMachine.createManualLotto(numbers) != null) {
                lottoRepository.addLotto(LottoMachine.createManualLotto(numbers));
                countOfFinishedLotto++;
            }
        } while (!lottoRepository.isCheckLottoCount(countOfManualLotto));
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
