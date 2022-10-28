package aldesrahim.prauts.aplikasi_suit.options;

public class Kertas implements OptionInterface {
    @Override
    public OptionInterface isWinAgainst() {
        return new Batu();
    }
}
