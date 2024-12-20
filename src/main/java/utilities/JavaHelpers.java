package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class JavaHelpers {

    private static final HashMap<String, Object> dataMap = new HashMap<>();

    /**
     * Stores a value in local storage with the given key.
     *
     * @param key   The key to associate with the value.
     * @param value The value to be stored.
     */
    public static void saveValue(String key, Object value) {
        dataMap.put(key, value);
    }


    /**
     * Retrieves a value from the local storage based on the provided key.
     *
     * @param key to get the value
     */
    public static Object getValue(String key) {
        return dataMap.get(key);
    }

    /**
     * Returns a random index between 0 and the specified size (exclusive).
     * Throws an exception if the size is less than or equal to 0.
     *
     * @param size The upper bound for the random index.
     * @return int A randomly generated index.
     * @throws IllegalArgumentException If the size is less than or equal to 0.
     */
    public static int getRandomIndex(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        Random random = new Random();
        return random.nextInt(size);
    }


    //Time-stamps

    /**
     * Returns the current timestamp formatted according to the given pattern.
     *
     * @param format The format of the timestamp, e.g., "yyyy MMM dd", "yyyyMMdd_HHmmss", etc.
     * @return A formatted timestamp string.
     */
    public String getTimeStamp(String format) {
        /*
         * Example format are :
         *
         * "yyyy MMM dd" for "2013 Nov 28"
         *
         * "yyyyMMdd_HHmmss" for "20130131000000"
         *
         * "yyyy MMM dd HH:mm:ss" for "2013 Jan 31 00:00:00"
         *
         * "dd MMM yyyy" for "28 Nov 2017"
         */
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }


    /**
     * Verifies if the list is sorted as per the specified order.
     *
     * @param items  The list to be checked.
     * @param sortBy The sorting order: "ASCENDING" or "DESCENDING".
     * @param <T>    The type of the items in the list. It must be Comparable.
     * @return boolean Returns true if the list is sorted according to the specified order, otherwise false.
     * @throws IllegalArgumentException If an invalid sorting order is provided.
     */
    public static <T extends Comparable<T>> boolean sorting(List<T> items, String sortBy) {
        List<T> sortedItems = new ArrayList<>(items);

        if (sortBy.equalsIgnoreCase("DESCENDING")) {
            sortedItems.sort(Collections.reverseOrder());
        } else if (sortBy.equalsIgnoreCase("ASCENDING")) {
            Collections.sort(sortedItems);
        } else {
            throw new IllegalArgumentException("Invalid sortBy value. Use 'ascending' or 'descending'.");
        }

        return sortedItems.equals(items);
    }

    /**
     * Converts a price string (with dollar sign) to a double value.
     * Returns 0.0 for empty input and throws a NumberFormatException for invalid input.
     *
     * @param number The price string, which may include a dollar sign.
     * @return The parsed price as a double.
     * @throws NumberFormatException If the input is not a valid number.
     */
    public static Double convertPriceToDouble(String number) {
        String price = number.replaceAll("[^0-9.]", "");
        if (price.isEmpty()) {
            return 0.0;
        }
        try {
            return Double.parseDouble(price);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid input for conversion to double: " + number);
        }
    }

    /**
     * Calculates the total price from a list of prices.
     *
     * @param prices A list of product prices.
     * @return Double The total sum of all prices in the list.
     */
    public static Double totalPrice(List<Double> prices) {
        return prices.stream().mapToDouble(Double::doubleValue).sum();
    }


}
