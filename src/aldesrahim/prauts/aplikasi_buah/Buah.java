package aldesrahim.prauts.aplikasi_buah;

import aldesrahim.prauts.Helper;

import java.util.List;

public class Buah {
    String nama;
    String notelp;

    public Buah(String nama, String notelp) {
        this.nama = nama;
        this.notelp = notelp;
    }

    public static void main(String[] args) {
        System.out.println("===== SELAMAT DATANG DI TOKO BUAH HOTARU =====");
        System.out.println(Helper.strRepeat("-", 46));

        String nama = Helper.ask("Masukkan nama pelanggan: ");
        String notelp = Helper.ask("Masukkan no telepon: ");

        Buah buah = new Buah(nama, notelp);
        buah.menu();
    }

    public void menu() {
        String input;

        System.out.println("Jenis buah yang ingin dibeli:");
        System.out.println("1. Jeruk");
        System.out.println("2. Mangga");

        input = Helper.ask("Pilihan: ");

        FruitInterface fruitObj = switch (input) {
            case "1" -> new Jeruk();
            case "2" -> new Mangga();
            default -> null;
        };

        if (fruitObj == null) {
            this.menu();
            return;
        }

        fruitObj.menu();
        Double total = fruitObj.checkout();

        if (total == null) {
            System.out.println("Tidak ada buah dalam keranjang");
            return;
        }

        System.out.println(Helper.strRepeat("-", 35));
        System.out.println("----------Struk Pembelian----------");
        System.out.println("\t\t Yang dibeli");
        System.out.println("\t Buah\t\t\t\t Banyak Buah");

        int i = 1;
        for (DTOInterface cart: fruitObj.getCarts()) {
            System.out.printf("%-3s %-20s %s kg\n", (i++) + ".", cart.getNama(), cart.getQty());
        }

        System.out.println("Total yang harus dibayar: Rp " + Helper.numberFormat(total));
        System.out.println(Helper.strRepeat("-", 35));
        System.out.println("Terima kasih telah berbelanja " + this.nama);
        System.out.println("\t Jangan lupa datang kembali");
    }

    public interface DTOInterface {
        String getNama();

        Double getHarga();

        Integer getQty();

        Double getTotalHarga();

        void setQty(Integer qty);
    }

    public interface FruitInterface {
        void menu();

        Double checkout();

        List<Buah.DTOInterface> getCarts();
    }
}
