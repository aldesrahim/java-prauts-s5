package aldesrahim.prauts.aplikasi_hotel;

import aldesrahim.prauts.Helper;

public class App {

    String namaPengunjung;
    Integer durasi;
    HotelService hotelService = new HotelService();

    public App(String namaPengunjung, Integer durasi) {
        this.namaPengunjung = namaPengunjung;
        this.durasi = durasi;
    }

    public static void main(String[] args) {
        System.out.println("======= SELAMAT DATANG =======");

        String namaPengunjung = Helper.ask("Nama Pengunjung: ");
        Integer durasi = Helper.askInt("Durasi Inap (malam): ");

        App app = new App(namaPengunjung, durasi);
        app.checkin();
    }

    public void checkin() {
        System.out.println("\n\n\n\n\n\n\n");
        System.out.println("======== DAFTAR KAMAR ========");
        this.hotelService.showHotels();
        System.out.println(Helper.strRepeat("-", 30));

        Hotel hotel = null;

        while (hotel == null) {
            Integer i = Helper.askInt("Pilih Kamar: ");
            hotel = this.hotelService.getByIndex(--i);
        }

        hotel.setDurasi(this.durasi);

        System.out.println("\n\n\n\n\n\n\n");
        System.out.println("======= DETAIL TAGIHAN =======");

        System.out.printf("Nama Pengunjung: %s\n", this.namaPengunjung);
        System.out.printf("Durasi Inap: %s malam\n", this.durasi);
        System.out.printf("Tipe Kamar: %s @ Rp.%s/malam\n", hotel.getNama(), Helper.numberFormat(hotel.getHarga()));
        System.out.println(Helper.strRepeat("-", 30));
        System.out.printf("Tagihan: Rp.%s\n", Helper.numberFormat(hotel.getTotalHarga()));
        System.out.println(Helper.strRepeat("-", 30));
    }
}
