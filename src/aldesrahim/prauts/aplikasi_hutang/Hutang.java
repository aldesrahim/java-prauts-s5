package aldesrahim.prauts.aplikasi_hutang;

public class Hutang {
    private final String title;
    private final Double amount;
    private boolean paid;

    public Hutang(String title, Double amount) {
        this.title = title;
        this.amount = amount;
        this.paid = false;
    }

    public String getTitle() {
        return title;
    }

    public Double getAmount() {
        return amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public String getPaidLabel() {
        return this.isPaid() ? "Y" : "N";
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
