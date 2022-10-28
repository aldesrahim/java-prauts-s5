package aldesrahim.prauts.aplikasi_rental;

import aldesrahim.prauts.Helper;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
    protected List<Movie> movies;
    protected List<Movie> sortedMovies;
    protected String[] genres;

    public MovieService() {
        this.movies = new ArrayList<>();
        this.sortedMovies = new ArrayList<>();
        this.genres = new String[]{
                "Horror",
                "Comedy",
                "Action"
        };
    }

    public List<Movie> getMovies() {
        return this.movies;
    }

    public List<Movie> getSortedMovies() {
        return this.sortedMovies;
    }

    public String[] getGenres() {
        return this.genres;
    }

    public Double getAdditionalPrice(String genre) {
        return (double) switch (genre) {
            case "Horror" -> 5000;
            case "Comedy" -> 3000;
            case "Action" -> 4000;
            default -> 0;
        };
    }

    public void setSortedMovies(List<Movie> movies) {
        this.sortedMovies = movies;
    }

    public String generateId() {
        String generatedId;

        outer:
        while (true) {
            generatedId = Random.alpha(2) + Random.numeric(3);
            for (Movie movie : this.getMovies()) {
                if (movie.getId().equals(generatedId)) {
                    continue outer;
                }
            }
            break;
        }

        return generatedId;
    }

    public void add(Movie movie) {
        this.movies.add(movie);
        this.sortMovies();
    }

    public void rent(Movie movie) {
        this.movies.remove(movie);
        this.sortMovies();
    }

    public void displayTable(List<Movie> movies) {
        String format = "| %-4s | %-7s | %-20s | %-7s | %-6s | %-8s |\n";

        System.out.println(Helper.strRepeat("=", 71));
        System.out.printf(format, "NO", "ID", "Title", "Genre", "Rating", "Price");
        System.out.println(Helper.strRepeat("=", 71));

        int num = 1;
        for (Movie movie : movies) {
            System.out.printf(format,
                    (num++),
                    movie.getId(),
                    movie.getTitle(),
                    movie.getGenre(),
                    movie.getRating(),
                    Helper.numberFormat(movie.getPrice())
            );
        }
        System.out.println(Helper.strRepeat("=", 71));
    }

    protected void sortMovies() {
        this.setSortedMovies(new ArrayList<>(this.getMovies()));
        this.getSortedMovies().sort((m1, m2) -> m1.getTitle().compareToIgnoreCase(m2.getTitle()));
    }
}
