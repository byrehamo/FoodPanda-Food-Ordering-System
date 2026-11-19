package FoodPandaApp;

import java.util.Scanner;

public class PaymentProcessor {
    Scanner input;

    public PaymentProcessor(Scanner input) {
        this.input = input;
    }

    public void handlePayment(double amount) {
        System.out.println("\n=== PAYMENT ===");
        System.out.printf("Total Amount: ฿%.2f\n", amount);
        System.out.println("Choose payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Cash on Delivery");
        System.out.println("3. PromptPay");

        System.out.print("Enter payment method: ");
        int method = input.nextInt();

        switch (method) {
            case 1:
                System.out.print("Enter card number: ");
                String card = input.next(); 
                System.out.println("✔ Payment completed via Credit Card.");
                break;
            case 2:
                System.out.println("✔ Please prepare exact cash. Delivery is on the way.");
                break;
            case 3:
                System.out.println("✔ Scan the PromptPay QR code to complete payment.");
                break;
            default:
                System.out.println("❌ Invalid payment method. Payment failed.");
                return;
        }

        System.out.println(" Thank you for your order!");
    }
}
