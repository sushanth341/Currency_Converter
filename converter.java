import java.util.Scanner;
import java.util.HashMap;

public class converter{
    private static final HashMap<String, Double> exchangeRates = new HashMap<>();

    static {
        // Sample exchange rates (1 unit of base currency to target currency)
        exchangeRates.put("USD_TO_EUR", 0.96);
        exchangeRates.put("USD_TO_GBP", 0.79);
        exchangeRates.put("USD_TO_INR", 87.29);
        exchangeRates.put("USD_TO_CAD", 1.43);
        exchangeRates.put("EUR_TO_USD", 1.04);
        exchangeRates.put("EUR_TO_GBP", 0.83);
        exchangeRates.put("EUR_TO_CAD", 1.48);
        exchangeRates.put("EUR_TO_INR", 90.79);
        exchangeRates.put("GBP_TO_INR", 109.12);
        exchangeRates.put("GBP_TO_CAD", 1.78);
        exchangeRates.put("GBP_TO_USD", 1.25);
        exchangeRates.put("GBP_TO_EUR", 1.20);

        exchangeRates.put("CAD_TO_EUR", 0.6);
        exchangeRates.put("CAD_TO_INR", 61.0);
        exchangeRates.put("CAD_TO_GBP", 0.55);
        exchangeRates.put("CAD_TO_USD", 0.69);

    }
    public static double convertCurrency(String from, String to, double amount) {
        String key = from + "_TO_" + to;
        if (exchangeRates.containsKey(key)) {
            return amount * exchangeRates.get(key);
        } else {
            System.out.println("Conversion rate not available.");
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter source currency (USD, EUR, GBP, CAD): ");
        String from = scanner.next().toUpperCase();
        
        System.out.println("Enter target currency (USD, EUR, GBP, INR, CAD): ");
        String to = scanner.next().toUpperCase();
        
        System.out.println("Enter amount to be converted: ");
        double amount = scanner.nextDouble();

        double result = convertCurrency(from, to, amount);
        if (result != -1) {
            System.out.printf("%.2f %s is equivalent to %.2f %s\n", amount, from, result, to);
        }
        
        scanner.close();
    }
}
