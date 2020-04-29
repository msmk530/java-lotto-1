package exception.ManualLotto;

public class SelectedNumbersDuplicateException extends IllegalArgumentException {
    public SelectedNumbersDuplicateException(String message) {
        super(message);
    }
}
