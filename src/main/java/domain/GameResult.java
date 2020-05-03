package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResult {
    private static int countOfPurchaseLotto;
    private static Map<Rank, Integer> result;

    public GameResult(int countOfPurchaseLotto, AllLotto allLotto, WinningLotto winningLotto) {
        GameResult.countOfPurchaseLotto = countOfPurchaseLotto;

        result = initResult();

        for (Lotto lotto : allLotto.getAllLotto()) {
            Rank rank = winningLotto.match(lotto);
            result.put(rank, result.get(rank) + 1);
        }
    }

    private static Map<Rank, Integer> initResult() {
        Map<Rank, Integer> result = new HashMap<>();

        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        return result;
    }

    public static Map<Rank, Integer> getResult() {
        return result;
    }

    public static int getCountOfPurchaseLotto() {
        return countOfPurchaseLotto;
    }
}
