import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Select the base currency (e.g., USD, EUR, GBP):");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.println("Select the target currency (e.g., USD, EUR, GBP):");
        String targetCurrency = scanner.nextLine().toUpperCase();

        
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        if (exchangeRate == -1) {
            System.out.println("Invalid currency selection. Exiting program.");
            System.exit(0);
        }

      
        System.out.println("Enter the amount to convert from " + baseCurrency + " to " + targetCurrency + ":");
        double amountToConvert = scanner.nextDouble();

        
        double convertedAmount = amountToConvert * exchangeRate;

        
        System.out.println("Converted Amount: " + convertedAmount + " " + targetCurrency);

        scanner.close();
    }

    
    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        
        if (baseCurrency.equals("USD") && targetCurrency.equals("EUR")) {
            return 0.85; 
        } else if (baseCurrency.equals("USD") && targetCurrency.equals("GBP")) {
            return 0.73;
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("USD")) {
            return 1.18; 
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("GBP")) {
            return 0.86; 
        } else if (baseCurrency.equals("GBP") && targetCurrency.equals("USD")) {
            return 1.37; 
        } else if (baseCurrency.equals("GBP") && targetCurrency.equals("EUR")) {
            return 1.16; 
        } else {
            return -1; 
        }
    }
}

