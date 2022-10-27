package aldesrahim.prauts.aplikasi_hotel;

public class Hotel {
    protected String nama;
    protected Double harga;
    protected Integer durasi = 0;

    public Hotel(String nama, Object harga) {
        this.nama = nama;
        this.harga = Double.parseDouble(harga.toString());
    }

    public String getNama() {
        return nama;
    }

    public Double getHarga() {
        return harga;
    }

    public Integer getDurasi() {
        return durasi;
    }

    public void setDurasi(Integer durasi) {
        this.durasi = durasi;
    }

    public Double getTotalHarga() {
        return this.getHarga() * this.getDurasi();
    }
}
