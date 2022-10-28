package aldesrahim.prauts.aplikasi_suit.options;

public class Gunting implements OptionInterface {
    @Override
    public OptionInterface isWinAgainst() {
        return new Kertas();
    }
}
