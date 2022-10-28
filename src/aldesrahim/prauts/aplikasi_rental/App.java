package aldesrahim.prauts.aplikasi_rental;

import aldesrahim.prauts.Helper;

import java.util.List;

public class App {
    MovieService service;

    public App() {
        this.service = new MovieService();
    }

    public static void main(String[] args) {
        App app = new App();
        app.menu();
    }

    public void menu() {
        System.out.println(Helper.strRepeat("=", 14));
        System.out.println(" MOVIE RENTAL ");
        System.out.println(Helper.strRepeat("=", 14));
        System.out.println("1. Add new movie");
        System.out.println("2. View movies");
        System.out.println("3. Rent movie");
        System.out.println("4. EXIT");

        while (true) {
            switch (Helper.ask(">> ")) {
                case "1" -> this.addMovie();
                case "2" -> this.viewMovies();
                case "3" -> this.rentMovie();
                case "4" -> System.exit(0);
                default -> {
                    continue;
                }
            }
            break;
        }

        this.menu();
    }

    public void addMovie() {
        String[] movieGenres = this.service.getGenres();
        String generatedMovieId = this.service.generateId();

        System.out.println(Helper.strRepeat("=", 14));
        System.out.println(" ADD MOVIE ");
        System.out.println(Helper.strRepeat("=", 14));

        String movieTitle = Helper.ask(
                "Input movie title [3-20 chars]: ",
                (String s) -> Validation.between(s, 3, 20)
        );
        String movieGenre = Helper.ask(
                "Input movie genre [" + String.join(" | ", movieGenres) + "]: ",
                (String s) -> Validation.in(s, movieGenres)
        );
        Integer movieRating = Helper.askInt(
                "Input movie rating [1-10]: ",
                (String s) -> Validation.between(Integer.parseInt(s), 1, 10)
        );
        System.out.println("Generated Movie ID: " + generatedMovieId);

        Double moviePrice = this.service.getAdditionalPrice(movieGenre) + (movieTitle.length() * 500);

        this.service.add(new Movie(generatedMovieId, movieTitle, movieGenre, movieRating, moviePrice));

        System.out.println("Insert success!");

        Helper.pause();
    }

    public void viewMovies() {
        List<Movie> movies = this.service.getSortedMovies();

        if (movies.size() == 0) {
            System.out.println("NO MOVIES FOUND");
            Helper.pause();
            return;
        }

        this.service.displayTable(movies);
        Helper.pause();
    }

    public void rentMovie() {
        List<Movie> movies = this.service.getMovies();

        int movieSize = movies.size();

        if (movieSize == 0) {
            System.out.println("NO MOVIES FOUND");
            Helper.pause();
            return;
        }

        this.service.displayTable(movies);
        Integer movieIndex = Helper.askInt(
                "Choose movie index [1-" + movieSize + "]: ",
                (String s) -> Validation.between(Integer.parseInt(s), 1, movieSize)
        );

        Movie movie = movies.get(--movieIndex);

        Double payment = Helper.askDouble("Input money to rent [MIN "+ Helper.numberFormat(movie.getPrice()) +"]: ",
                (String s) -> Validation.min(Double.parseDouble(s), movie.getPrice())
        );

        System.out.printf("Payment rent successful with %s change\n", Helper.numberFormat(payment - movie.getPrice()));

        this.service.rent(movie);
        Helper.pause();
    }
}
