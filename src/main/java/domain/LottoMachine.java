package domain;

import util.ChangeStringToIntList;
import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static view.OutputView.printErrorMessage;

public class LottoMachine {
    private static final int ONE_LOTTO_SIZE = 6;

    private LottoMachine() {
        throw new AssertionError();
    }

    public static Lotto createManualLotto(String selectNumbers) {
        List<Integer> lottoNumbers;

        try {
            lottoNumbers = ChangeStringToIntList.change(selectNumbers);
            return LottoGenerator.generateLotto(lottoNumbers);
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
            return null;
        }
    }

    public static void completeAllLotto(LottoRepository lottoRepository, int countOfAutomaticLotto) {
        for (int countOfFinishedLotto = 0; countOfFinishedLotto < countOfAutomaticLotto; countOfFinishedLotto++) {
            lottoRepository.addLotto(createAutomaticLotto());
        }
    }

    public static WinningLotto createWinningLotto(Lotto winningNumberLotto, int bonusNumber) {
        return new WinningLotto(winningNumberLotto, bonusNumber);
    }

    private static Lotto createAutomaticLotto() {
        List<Integer> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() != ONE_LOTTO_SIZE) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber();
            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }
        return LottoGenerator.generateLotto(lottoNumbers);
    }

}