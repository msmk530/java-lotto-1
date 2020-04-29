package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static LottoGenerator manualLottoGenerator = new ManualLottoGenerator();
    private static LottoGenerator automaticLottoGenerator = new AutomaticLottoGenerator();

    public static List<Lotto> createLotto(int countOfManualLotto, int countOfAutomaticLotto) {
        List<Lotto> allPurchasedLotto = new ArrayList<>();
        List<Lotto> manualLottoes = createManualLottoes(countOfManualLotto);
        List<Lotto> automaticLottoes = createAutomaticLottoes(countOfAutomaticLotto);

        allPurchasedLotto.addAll(manualLottoes);
        allPurchasedLotto.addAll(automaticLottoes);

        return allPurchasedLotto;
    }

    private static List<Lotto> createManualLottoes(int countOfManualLotto) {
        List<Lotto> manualLottoes = new ArrayList<>();

        for(int i=0; i<countOfManualLotto; i++){
            List<Integer> manualNumbers = InputView.inputManualNumber();
            manualLottoes.add(manualLottoGenerator.generateLotto(manualNumbers));
        }

        return manualLottoes;
    }

    private static List<Lotto> createAutomaticLottoes(int countOfAutomaticLotto) {
        List<Lotto> automaticLottoes = new ArrayList<>();


        return automaticLottoes;
    }


}
