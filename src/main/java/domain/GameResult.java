package domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private final int countOfPurchaseLotto;
    private final Map<Rank, Integer> result;

    public GameResult(LottoRepository lottoRepository, int countOfPurchaseLotto, WinningLotto winningLotto) {
        this.countOfPurchaseLotto = countOfPurchaseLotto;

        result = initResult();

        for (Lotto lotto : lottoRepository.getAllLotto()) {
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

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public int getCountOfPurchaseLotto() {
        return countOfPurchaseLotto;
    }
}
