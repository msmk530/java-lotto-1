package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResult {
    private static int countOfPurchaseLotto;
    private static Map<Rank, Integer> result;
    private static Rank rank;

    public GameResult(int countOfPurchaseLotto, List<Lotto> allLotto, WinningLotto winningLotto) {
        this.countOfPurchaseLotto = countOfPurchaseLotto;

        result = initResult();

        for (int i = 0; i < allLotto.size(); i++) {
            rank = winningLotto.match(allLotto.get(i));
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
