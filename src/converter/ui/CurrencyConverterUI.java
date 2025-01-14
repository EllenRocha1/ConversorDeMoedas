package converter.ui;

import converter.service.CurrencyConverterService;
import java.util.Scanner;

public class CurrencyConverterUI {

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Conversor de Moedas ===");
            System.out.println("1. USD para EUR");
            System.out.println("2. EUR para GBP");
            System.out.println("3. USD para BRL");
            System.out.println("4. BRL para EUR");
            System.out.println("5. BRL para GBP");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1 -> handleConversion("USD", "EUR", scanner);
                    case 2 -> handleConversion("EUR", "GBP", scanner);
                    case 3 -> handleConversion("USD", "BRL", scanner);
                    case 4 -> handleConversion("BRL", "EUR", scanner);
                    case 5 -> handleConversion("BRL", "GBP", scanner);
                    case 6 -> {
                        System.out.println("Saindo...");
                        running = false;
                    }
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void handleConversion(String from, String to, Scanner scanner) {
        System.out.print("Digite o valor em " + from + ": ");
        double amount = scanner.nextDouble();

        try {
            double converted = CurrencyConverterService.convert(from, to, amount);
            System.out.printf("%.2f %s equivale a %.2f %s\n", amount, from, converted, to);
        } catch (Exception e) {
            System.out.println("Erro ao converter: " + e.getMessage());
        }
    }
}
