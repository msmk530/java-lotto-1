package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

import static view.OutputView.printErrorMessage;

public class LottoMachine {
    private LottoMachine() {
        throw new AssertionError();
    }

    public static List<Lotto> createManualLotto(LottoGenerator strategy, int countOfManualLotto) {
        List<Lotto> manualLottoes = new ArrayList<>();
        for (int i = 0; i < countOfManualLotto; i++) {
            manualLottoes.add(createLotto(strategy));
        }
        return manualLottoes;
    }

    public static List<Lotto> createAutomaticLotto(LottoGenerator strategy, int countOfAutomaticLotto) {
        List<Lotto> automaticLottoes = new ArrayList<>();

        for (int countOfFinishedLotto = 0; countOfFinishedLotto < countOfAutomaticLotto; countOfFinishedLotto++) {
            automaticLottoes.add(createLotto(strategy));
        }

        return automaticLottoes;
    }

    public static WinningLotto createWinningLotto(LottoGenerator strategy) {
        Lotto winningNumberLotto = createLotto(new WinningLottoGenerator());
        int bonus = createBonusNumber(winningNumberLotto);

        return new WinningLotto(winningNumberLotto, bonus);

    }

    private static int createBonusNumber(Lotto winningNumberLotto) {
        try {
            int bonus = InputView.inputBonus();
            Validator.isValidBonusNumber(bonus, winningNumberLotto.getNumbers());
            return bonus;
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
            return createBonusNumber(winningNumberLotto);
        }
    }

    private static Lotto createLotto(LottoGenerator strategy) {
        return strategy.generateLotto();
    }
}