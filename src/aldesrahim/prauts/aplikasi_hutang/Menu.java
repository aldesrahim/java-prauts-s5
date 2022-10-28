package aldesrahim.prauts.aplikasi_hutang;

import aldesrahim.prauts.Helper;

public class Menu {
    private final HutangService hutangService;

    public Menu(HutangService hutangService) {
        this.hutangService = hutangService;
    }

    public void main() {
        System.out.println("MENU UTAMA");
        System.out.println(Helper.strRepeat("=", 15));
        System.out.println("1. Daftar Hutang");
        System.out.println("2. Tambah Hutang");
        System.out.println("3. Bayar Hutang");
        System.out.println("4. EXIT");

        while (true) {
            Integer input = Helper.askInt(">> ");
            switch (input) {
                case 1 -> this.show();
                case 2 -> this.add();
                case 3 -> this.pay();
                case 4 -> System.exit(0);
                default -> {
                    continue;
                }
            }
            break;
        }

        this.main();
    }

    private void show() {
        if (this.hutangService.getHutangList().isEmpty()) {
            Helper.pause("Data hutang kosong. Tekan ENTER untuk kembali ke menu");
            return;
        }

        this.hutangService.showHutangList();
        Helper.pause("Tekan ENTER untuk kembali ke menu");
    }

    private void add() {
        System.out.println("TAMBAH HUTANG");
        System.out.println(Helper.strRepeat("=", 15));

        String title = Helper.ask("Judul Hutang: ");
        Double amount = Helper.askDouble("Jumlah Hutang: ");

        Hutang hutang = new Hutang(title, amount);
        this.hutangService.add(hutang);

        System.out.println("Hutang berhasil ditambah");
        Helper.pause("Tekan ENTER untuk kembali ke menu");
    }

    private void pay() {
        if (this.hutangService.getHutangList().isEmpty()) {
            Helper.pause("Data hutang kosong. Tekan ENTER untuk kembali ke menu");
            return;
        }

        if (this.hutangService.getUnpaidHutangCounter() <= 0) {
            Helper.pause("Semua hutang sudah lunas. Tekan ENTER untuk kembali ke menu");
            return;
        }

        int len = this.hutangService.getHutangList().size();
        this.hutangService.showHutangList();

        int hutangIndex;
        Hutang hutang;

        while (true) {
            hutangIndex = Helper.askInt(String.format("Bayar hutang %s: ", len > 1 ? "[1-"+ len +"]" : ""));
            hutang = this.hutangService.getByIndex(--hutangIndex);

            if (hutang == null) {
                continue;
            }

            if (hutang.isPaid()) {
                System.out.println("Hutang sudah lunas");
                continue;
            }

            break;
        }

        this.hutangService.pay(hutang);
        System.out.println("Hutang berhasil dibayar");
        Helper.pause("Tekan ENTER untuk kembali ke menu");
    }
}
