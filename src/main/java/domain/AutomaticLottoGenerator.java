package domain;

import util.RandomNumberGenerator;

import java.util.Collections;
import java.util.List;

public class AutomaticLottoGenerator implements LottoGenerator {
    private static final int ONE_LOTTO_SIZE = 6;

    @Override
    public Lotto generateLotto(List<Integer> lottoNumbers) {
        while (lottoNumbers.size() != ONE_LOTTO_SIZE) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber();
            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }

        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }
}
