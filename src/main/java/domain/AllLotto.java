package domain;

import java.util.ArrayList;
import java.util.List;

public class AllLotto {
    private List<Lotto> allLotto = new ArrayList<>();

    public AllLotto(int countOfManualLotto, int countOfAutomaticLotto){
        addManualLotto(countOfManualLotto);
        addAutomaticLotto(countOfAutomaticLotto);
    }

    private void addManualLotto(int countOfManualLotto){
        allLotto.addAll(LottoMachine.createManualLotto(countOfManualLotto));
    }

    private void addAutomaticLotto(int countOfAutomaticLotto){
        allLotto.addAll(LottoMachine.createAutomaticLotto(countOfAutomaticLotto));
    }

    public List<Lotto> getAllLotto(){
        return allLotto;
    }

}
