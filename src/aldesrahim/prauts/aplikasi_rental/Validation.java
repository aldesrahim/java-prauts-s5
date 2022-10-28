package aldesrahim.prauts.aplikasi_rental;

public class Validation {
    public static Boolean between(String value, int min, int max) {
        return value.length() >= min && value.length() <= max;
    }

    public static Boolean between(int value, int min, int max) {
        return value >= min && value <= max;
    }

    public static Boolean min(Double value, double min) {
        return value.compareTo(min) >= 0;
    }

    public static Boolean min(Double value, int min) {
        return Validation.min(value, (double) min);
    }

    public static Boolean in(String value, String[] values) {
        for (String requiredValue : values) {
            if (requiredValue.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
