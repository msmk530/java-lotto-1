package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static LottoGenerator manualLottoGenerator = new ManualLottoGenerator();
    private static LottoGenerator automaticLottoGenerator = new AutomaticLottoGenerator();

    public static List<Lotto> createLotto(int countOfPurchaseLotto, int countOfManualLotto) {
        List<Lotto> allPurchasedLotto = new ArrayList<>();
        List<Lotto> manualLottoes = manualLottoGenerator.generateLotto(countOfPurchaseLotto, countOfManualLotto);
        List<Lotto> automaticLottoes = automaticLottoGenerator.generateLotto(countOfPurchaseLotto, countOfManualLotto);

        allPurchasedLotto.addAll(manualLottoes);
        allPurchasedLotto.addAll(automaticLottoes);

        return allPurchasedLotto;
    }
}
