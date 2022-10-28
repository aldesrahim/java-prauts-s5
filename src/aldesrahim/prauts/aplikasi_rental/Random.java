package aldesrahim.prauts.aplikasi_rental;

public class Random {

    private static String generate(String charlist, int n) {
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (charlist.length() * Math.random());

            // add Character one by one in end of sb
            sb.append(charlist.charAt(index));
        }

        return sb.toString();
    }

    public static String alpha(int n) {
        return generate("ABCDEFGHIJKLMNOPQRSTUVWXYZ", n);
    }

    public static String numeric(int n) {
        return generate("0123456789", n);
    }
}
