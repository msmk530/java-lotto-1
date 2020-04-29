package domain;

import java.util.List;

public interface LottoGenerator {
    List<Lotto> generateLotto(int countOfPurchaseLotto, int countOfManualLotto);
}
