package aldesrahim.prauts.aplikasi_suit;

import aldesrahim.prauts.aplikasi_suit.options.Batu;
import aldesrahim.prauts.aplikasi_suit.options.Gunting;
import aldesrahim.prauts.aplikasi_suit.options.Kertas;
import aldesrahim.prauts.aplikasi_suit.options.OptionInterface;

import java.util.HashMap;
import java.util.Random;

public class GameService {
    protected final HashMap<String, OptionInterface> options;
    protected String playerOption;
    protected String computerOption;
    protected int playerWinCounter;
    protected int computerWinCounter;

    public GameService() {
        this.options = new HashMap<>();
        this.options.put("batu", new Batu());
        this.options.put("gunting", new Gunting());
        this.options.put("kertas", new Kertas());

        this.playerWinCounter = 0;
        this.computerWinCounter = 0;
        this.computerOption = this.getRandomOptionKey();
    }

    public String getPlayerOption() {
        return this.playerOption;
    }

    public void setPlayerOption(String playerOption) {
        this.playerOption = playerOption;
    }

    public String getComputerOption() {
        return this.computerOption;
    }

    public int getPlayerWinCounter() {
        return this.playerWinCounter;
    }

    public int getComputerWinCounter() {
        return this.computerWinCounter;
    }

    public HashMap<String, OptionInterface> getOptions() {
        return this.options;
    }

    public String getRandomOptionKey() {
        String[] keys = new String[]{
                "batu",
                "gunting",
                "kertas"
        };

        Random rand = new Random();
        return keys[rand.nextInt(keys.length)];
    }

    public boolean isOptionAvailable(String option) {
        return this.options.get(option) != null;
    }

    public int getWinner() {
        OptionInterface playerOption = this.options.get(this.playerOption);
        OptionInterface computerOption = this.options.get(this.computerOption);

        this.resetComputerOption();

        if (playerOption == computerOption) {
            return 0;
        }

        boolean isPlayerWin = playerOption.isWinAgainst().getClass().isAssignableFrom(computerOption.getClass());

        if (isPlayerWin) {
            this.playerWinCounter++;
        } else {
            this.computerWinCounter++;
        }

        return isPlayerWin ? 1 : -1;
    }

    public void resetComputerOption() {
        this.computerOption = this.getRandomOptionKey();
    }
}
