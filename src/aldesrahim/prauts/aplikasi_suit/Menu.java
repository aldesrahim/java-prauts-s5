package aldesrahim.prauts.aplikasi_suit;

import aldesrahim.prauts.Helper;

public class Menu {
    protected final GameService service;

    public Menu(GameService service) {
        this.service = service;
    }

    public void main() {
        this.score();
        System.out.println("\nAYO SUIT DAN KALAHKAN KOMPUTER!");
        System.out.println(Helper.strRepeat("=", 31));

        String options = String.join(" | ", this.service.getOptions().keySet());
        String playerOption = Helper.ask(
                "Pilih [" + options.toUpperCase() + " | X]: ",
                (String s) -> this.service.isOptionAvailable(s.toLowerCase()) || s.equalsIgnoreCase("x")
        ).toLowerCase();

        if (playerOption.equalsIgnoreCase("x")) {
            return;
        }

        this.service.setPlayerOption(playerOption);

        this.result();

        Helper.pause("Tekan ENTER untuk memulai permainan kembali");
        this.main();
    }

    public void score() {
        System.out.println("\nSKOR KEMENANGAN SAAT INI");
        System.out.println(Helper.strRepeat("=", 31));
        System.out.println("Player: " + this.service.getPlayerWinCounter());
        System.out.println("Computer: " + this.service.getComputerWinCounter());

    }

    public void result() {
        System.out.println("\nHASIL SUIT");
        System.out.println(Helper.strRepeat("=", 31));
        System.out.println("Anda: " + this.service.getPlayerOption().toUpperCase());
        System.out.println("Computer: " + this.service.getComputerOption().toUpperCase());
        System.out.println(Helper.strRepeat("=", 31));

        String message = switch (this.service.getWinner()) {
            case 1 -> "Selamat, Anda berhasil mengalahkan computer";
            case 0 -> "Seri !";
            case -1 -> "Yah.. Anda telah dikalahkan computer, jangan menyerah!";
            default -> "";
        };

        System.out.println(message + "\n");
    }
}
