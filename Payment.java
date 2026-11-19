package FoodPandaApp;

	public class Payment {
	    public static void processPayment(String method, double amount) {
	        switch (method) {
	            case "Credit Card":
	                System.out.println("Processing Credit Card payment for ฿" + String.format("%.2f", amount));
	                break;
	            case "Cash":
	                System.out.println("Please prepare exact cash. Delivery is on the way.");
	                break;
	            case "PromptPay":
	                System.out.println("✔ Scan the PromptPay QR code to complete payment.");
	                break;
	        }
	        System.out.println("Thank you for your order!");
	    }
	}
