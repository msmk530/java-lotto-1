package domain;

import util.ChangeStringToIntList;
import util.RandomNumberGenerator;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

import static view.OutputView.printErrorMessage;

public class LottoMachine {
    private static final int ONE_LOTTO_SIZE = 6;

    private LottoMachine() {
        throw new AssertionError();
    }

    public static List<Lotto> createManualLotto(int countOfManualLotto) {
        List<Lotto> manualLottoes = new ArrayList<>();
        for (int countOfFinishedLotto = 0; countOfFinishedLotto < countOfManualLotto; countOfFinishedLotto++) {
            manualLottoes.add(selectManualNumbers(countOfFinishedLotto));
        }
        return manualLottoes;
    }

    public static List<Lotto> createAutomaticLotto(int countOfAutomaticLotto) {
        List<Lotto> automaticLottoes = new ArrayList<>();

        for (int countOfFinishedLotto = 0; countOfFinishedLotto < countOfAutomaticLotto; countOfFinishedLotto++) {
            automaticLottoes.add(selectAutomaticNumbers());
        }

        return automaticLottoes;
    }

    public static WinningLotto createWinningLotto() {
        Lotto winningNumberLotto = selectWinningNumbers();
        return addBonusNumber(winningNumberLotto);
    }

    private static Lotto selectManualNumbers(int countOfFinishedLotto) {
        List<Integer> lottoNumbers;

        try {
            String selectNumbers = InputView.inputManualNumber(countOfFinishedLotto);
            lottoNumbers = ChangeStringToIntList.change(selectNumbers);
            return new ManualLottoGenerator().generateLotto(lottoNumbers);
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
            return selectManualNumbers(countOfFinishedLotto);
        }
    }

    private static Lotto selectAutomaticNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() != ONE_LOTTO_SIZE) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber();
            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }

        return new AutomaticLottoGenerator().generateLotto(lottoNumbers);
    }

    private static Lotto selectWinningNumbers() {
        List<Integer> lottoNumbers;

        try {
            String selectNumbers = InputView.inputWinningLottoNumbers();
            lottoNumbers = ChangeStringToIntList.change(selectNumbers);
            return new WinningLottoGenerator().generateLotto(lottoNumbers);
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
            return selectWinningNumbers();
        }
    }

    private static WinningLotto addBonusNumber(Lotto winningNumberLotto) {
        try {
            int bonus = InputView.inputBonus();
            return new WinningLotto(winningNumberLotto, bonus);
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
            return addBonusNumber(winningNumberLotto);
        }
    }
}