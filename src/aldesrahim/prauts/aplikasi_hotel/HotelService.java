package aldesrahim.prauts.aplikasi_hotel;

import aldesrahim.prauts.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotelService {
    protected List<Hotel> hotels = new ArrayList<>();

    public HotelService() {
        this.hotels.addAll(Arrays.asList(
                new Hotel("Standard Room", 400000),
                new Hotel("Superior Room", 500000),
                new Hotel("Deluxe Room", 650000),
                new Hotel("Suite Room", 750000)
        ));
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void showHotels() {
        int i = 1;
        for (Hotel hotel : this.getHotels()) {
            System.out.printf("%-4s %-15s Rp.%s/malam\n",
                    (i++) + ".",
                    hotel.getNama(),
                    Helper.numberFormat(hotel.getHarga())
            );
        }

    }

    public Hotel getByIndex(int i) {
        try {
            return this.hotels.get(i);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
