package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static List<Lotto> createManualLotto(LottoGenerator strategy, int countOfManualLotto) {
        List<Lotto> manualLottoes = new ArrayList<>();

        for (int countOfFinishedLotto = 0; countOfFinishedLotto < countOfManualLotto; countOfFinishedLotto++) {
            List<Integer> manualNumbers = InputView.inputManualNumber(countOfFinishedLotto);
            manualLottoes.add(createLotto(strategy, manualNumbers));
        }
        return manualLottoes;
    }

    public static List<Lotto> createAutomaticLotto(LottoGenerator strategy, int countOfAutomaticLotto) {
        List<Lotto> automaticLottoes = new ArrayList<>();

        for (int countOfFinishedLotto = 0; countOfFinishedLotto < countOfAutomaticLotto; countOfFinishedLotto++) {
            List<Integer> automaticNumbers = new ArrayList<>();
            automaticLottoes.add(LottoMachine.createLotto(strategy, automaticNumbers));
        }

        return automaticLottoes;
    }

    public static WinningLotto createWinningLotto(List<Integer> winningNumbers, int bonus) {
        Lotto winningNumberLotto = createLotto(new ManualLottoGenerator(), winningNumbers);
        return new WinningLotto(winningNumberLotto, bonus);
    }

    private static Lotto createLotto(LottoGenerator strategy, List<Integer> numbers) {
        return strategy.generateLotto(numbers);
    }
}
