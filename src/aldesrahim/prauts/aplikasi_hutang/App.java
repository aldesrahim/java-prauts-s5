package aldesrahim.prauts.aplikasi_hutang;

public class App {
    public static void main(String[] args) {
        HutangService hutangService = new HutangService();
        Menu menu = new Menu(hutangService);
        menu.main();
    }
}
