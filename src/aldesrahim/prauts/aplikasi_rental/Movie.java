package aldesrahim.prauts.aplikasi_rental;

public class Movie {
    protected String id;
    protected String title;
    protected String genre;
    protected Integer rating;
    protected Double price;

    public Movie(String id, String title, String genre, Integer rating, Double price) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.price = price;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getGenre() {
        return this.genre;
    }

    public Integer getRating() {
        return this.rating;
    }

    public Double getPrice() {
        return this.price;
    }
}
