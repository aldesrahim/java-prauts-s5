package aldesrahim.prauts.aplikasi_buah;

import aldesrahim.prauts.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mangga implements Buah.FruitInterface {
    protected List<Buah.DTOInterface> fruits = new ArrayList<>();
    protected List<Buah.DTOInterface> carts = new ArrayList<>();

    public Mangga() {
        this.init();
    }

    private void init() {
        class BuahDTO implements Buah.DTOInterface {
            final String nama;
            final Double harga;
            Integer qty = 0;

            public BuahDTO(String nama, Object harga) {
                this.nama = nama;
                this.harga = Double.parseDouble(harga.toString());
            }

            public String getNama() {
                return this.nama;
            }

            public Double getHarga() {
                return this.harga;
            }

            public Integer getQty() {
                return this.qty;
            }

            public void setQty(Integer qty) {
                this.qty = qty;
            }

        }

        Buah.DTOInterface fruit1 = new BuahDTO("Mangga Harum Manis", 15000);
        Buah.DTOInterface fruit2 = new BuahDTO("Mangga Indramayu", 20000.00);
        Buah.DTOInterface fruit3 = new BuahDTO("Mangga Simanalagi", 30000.00);

        this.fruits.addAll(Arrays.asList(fruit1, fruit2, fruit3));
    }

    public List<Buah.DTOInterface> getCarts() {
        return this.carts;
    }

    public void menu() {
        System.out.println("\t Jenis buah mangga");
        System.out.println(Helper.strRepeat("-", 30));

        int i = 1;

        for (Buah.DTOInterface fruit : this.fruits) {
            System.out.printf("%-3s %-20s Rp %s\n", (i++) + ".", fruit.getNama(), Helper.numberFormat(fruit.getHarga()));
        }
        System.out.printf("%-3s %-20s\n", "9.", "Check out");

        while (true) {
            Integer input = Helper.askInt("Pilihan anda: ");

            if (input.equals(9)) {
                break;
            }

            if (input.compareTo(this.fruits.size()) > 0) {
                continue;
            }

            Integer qty = Helper.askInt("Banyaknya buah yang dibeli: ");

            if (this.addToChart(input - 1, qty).equals(false)) {
                System.out.println("Gagal ditambahkan");
                continue;
            }

            System.out.println("Berhasil ditambahkan");
        }
    }

    private Boolean addToChart(Integer i, Integer qty) {
        try {
            Buah.DTOInterface fruit = this.fruits.get(i);
            fruit.setQty(qty);

            this.carts.add(fruit);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }

        return true;
    }

    public Double checkout() {
        if (this.carts.size() == 0) {
            return null;
        }

        double total = 0.0;

        for (Buah.DTOInterface cart : this.carts) {
            total += cart.getHarga() * cart.getQty();
        }

        return total;
    }
}
