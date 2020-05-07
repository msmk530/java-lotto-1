package domain;

import java.util.ArrayList;
import java.util.List;

public class AllLotto {
    private static List<Lotto> allLotto = new ArrayList<>();

    private AllLotto() {
        throw new AssertionError();
    }

    public static void addLotto(Lotto lotto) {
        allLotto.add(lotto);
    }

    public static boolean isCheckLottoCount(int countOfLotto) {
        return allLotto.size() == countOfLotto;
    }

    public static List<Lotto> getAllLotto() {
        return allLotto;
    }

}
