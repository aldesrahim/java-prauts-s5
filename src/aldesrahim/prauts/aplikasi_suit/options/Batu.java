package aldesrahim.prauts.aplikasi_suit.options;

public class Batu implements OptionInterface {
    @Override
    public OptionInterface isWinAgainst() {
        return new Gunting();
    }
}
