package aldesrahim.prauts.aplikasi_hutang;

import aldesrahim.prauts.Helper;

import java.util.ArrayList;
import java.util.List;

public class HutangService {
    private final List<Hutang> hutangList;
    private int unpaidHutangCounter = 0;

    public HutangService() {
        this.hutangList = new ArrayList<>();
    }

    public List<Hutang> getHutangList() {
        return this.hutangList;
    }

    public int getUnpaidHutangCounter() {
        return this.unpaidHutangCounter;
    }

    public Hutang getByIndex(int i) {
        try {
            return this.hutangList.get(i);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void add(Hutang hutang) {
        this.hutangList.add(hutang);
        this.unpaidHutangCounter++;
    }

    public void pay(Hutang hutang) {
        hutang.setPaid(true);
        this.unpaidHutangCounter--;
    }

    public void showHutangList() {
        String format = "| %-3s | %-30s | %-15s | %-5s |\n";
        System.out.println(Helper.strRepeat("=", 66));
        System.out.printf(format, "NO", "JUDUL", "JUMLAH", "LUNAS");
        System.out.println(Helper.strRepeat("=", 66));

        int i = 1;
        double totalHutang = 0;
        double totalTerbayar = 0;
        for (Hutang hutang : hutangList) {
            System.out.printf(format,
                    i++,
                    hutang.getTitle(),
                    Helper.numberFormat(hutang.getAmount()),
                    hutang.getPaidLabel()
            );
            totalHutang += hutang.getAmount();
            totalTerbayar += (hutang.isPaid() ? hutang.getAmount() : 0);
        }

        System.out.println(Helper.strRepeat("=", 66));
        System.out.printf("| %-8s : %-51s |\n", "TOTAL", Helper.numberFormat(totalHutang));
        System.out.printf("| %-8s : %-51s |\n", "TERBAYAR", Helper.numberFormat(totalTerbayar));
        System.out.printf("| %-8s : %-51s |\n", "SISA", Helper.numberFormat(totalHutang - totalTerbayar));
        System.out.println(Helper.strRepeat("=", 66));
    }
}
