package exception.ManualLotto;

public class LottoNumberOutOfRangeException extends IllegalArgumentException {
    public LottoNumberOutOfRangeException(String message) {
        super(message);
    }
}
