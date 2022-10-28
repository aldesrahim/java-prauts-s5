package aldesrahim.prauts.aplikasi_suit;

public class App {
    public static void main(String[] args) {
        GameService service = new GameService();
        Menu menu = new Menu(service);
        menu.main();
    }
}
