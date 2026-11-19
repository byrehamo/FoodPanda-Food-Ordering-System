package FoodPandaApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in); // Scanner for user input
        ArrayList<Restaurant> restaurants = initializeRestaurants(); // Initialize the list of restaurants
        Order currentOrder = new Order(); // Create a new order instance
        // Main application loop
        while (true) {
            // Display the main menu
            System.out.println("\n=== FOODPANDA ===");
            System.out.println("1. Browse Restaurants");
            System.out.println("2. My Cart");
            System.out.println("3. Promotions");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt(); // Get user choice
            // Handle user choice
            switch (choice) {
                case 1 -> browseRestaurants(scanner, restaurants, currentOrder); // Browse restaurants
                case 2 -> {
                    // Check if the cart has items
                    if (currentOrder.getItemCount() > 0) {
                        currentOrder.displayCart(); // Display current cart items
                        System.out.println("\n[C] Checkout  [M] Main Menu");
                        System.out.print("Enter option: ");
                        String option = scanner.next(); // Get user option
                        if (option.equalsIgnoreCase("C")) {
                        	 processCheckout(scanner, currentOrder); // Process checkout
                        }
                    } else {
                        System.out.println("\n🛒 YOUR CART IS EMPTY"); // Notify if cart is empty
                    }
                }
                case 3 -> showPromotions();
                case 4 -> {
                    System.out.println("Thank you for using FoodPanda!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static ArrayList<Restaurant> initializeRestaurants() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        
        Restaurant mk = new Restaurant("MK Restaurant", "Thai", 4);
        mk.addMenuItem("Suki Set", 199);
        mk.addMenuItem("Roasted Duck", 189);
        mk.addMenuItem("Thai Tea", 59);
        
        Restaurant pizza = new Restaurant("Pizza Company", "Fast Food", 4);
        pizza.addMenuItem("Pepperoni Pizza", 299);
        pizza.addMenuItem("Garlic Bread", 119);
        pizza.addMenuItem("Coke", 39);
        
        Restaurant sushi = new Restaurant("Sushi Hiro", "Japanese", 5);
        sushi.addMenuItem("Salmon Sushi Set", 199);
        sushi.addMenuItem("Tempura Udon", 159);
        sushi.addMenuItem("Matcha Ice Cream", 89);
        
        restaurants.add(mk);
        restaurants.add(pizza);
        restaurants.add(sushi);
        
        return restaurants;
    }

    private static void browseRestaurants(Scanner scanner, 
                                        ArrayList<Restaurant> restaurants, 
                                        Order currentOrder) {
        System.out.println("\nRESTAURANTS NEAR YOU (BANGKOK)");
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println((i + 1) + ". " + restaurants.get(i));
        }
        
        System.out.print("Enter choice (0 to cancel): ");
        int resChoice = scanner.nextInt();
        
        if (resChoice == 0) return;
        Restaurant selected = restaurants.get(resChoice - 1);

        while (true) {
            System.out.println("\n" + selected.getName().toUpperCase() + " MENU");
            ArrayList<MenuItem> menu = selected.getMenu();
            
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + ". " + menu.get(i));
            }
            
            System.out.println("[+] Add  [-] Remove  [C] Checkout");
            System.out.print("Enter item number or option: ");
            String action = scanner.next();
            
            if (action.equalsIgnoreCase("C")) {
                if (currentOrder.getItemCount() > 0) {
                    processCheckout(scanner, currentOrder);
                }
                break;
            } else if (action.equals("+")) {
                System.out.print("Enter item number to add: ");
                int itemNum = scanner.nextInt();
                if (itemNum >= 1 && itemNum <= menu.size()) {
                    currentOrder.addItem(menu.get(itemNum - 1));
                } else {
                    System.out.println("Invalid item number!");
                }
            } else if (action.equals("-")) {
                if (currentOrder.getItemCount() > 0) {
                    currentOrder.displayCart();
                    System.out.print("Enter item number to remove: ");
                    int itemNum = scanner.nextInt();
                    currentOrder.removeItem(itemNum - 1);
                } else {
                    System.out.println("Your cart is empty!");
                }
            }
        }
    }

    private static void processCheckout(Scanner scanner, Order currentOrder) {
        double discount = DiscountTable.getRandomDiscount();
        currentOrder.printReceipt(discount);
        
        System.out.println("\n=== PAYMENT ===");
        System.out.println("1. Credit Card");
        System.out.println("2. Cash");
        System.out.println("3. PromptPay");
        System.out.print("Enter payment method: ");
        int paymentMethod = scanner.nextInt();
        
        switch (paymentMethod) {
            case 1 -> Payment.processPayment("Credit Card", 
                currentOrder.calculateSubtotal() - 
                (currentOrder.calculateSubtotal() * discount) + 
                Order.DELIVERY_FEE);
            case 2 -> Payment.processPayment("Cash", 
                currentOrder.calculateSubtotal() - 
                (currentOrder.calculateSubtotal() * discount) + 
                Order.DELIVERY_FEE);
            case 3 -> Payment.processPayment("PromptPay", 
                currentOrder.calculateSubtotal() - 
                (currentOrder.calculateSubtotal() * discount) + 
                Order.DELIVERY_FEE);
            default -> System.out.println("Invalid payment method!");
        }
    }

    private static void showPromotions() {
        System.out.println("\n🎉 CURRENT PROMOTIONS 🎉");
        System.out.println("1. Free delivery for orders over ฿500");
        System.out.println("2. 10% off Pizza company restaurants on weekends");
        System.out.println("3. Buy 1 icce cream get 1 free ice creamin sushihero restaurant");
        System.out.print("Press any key to continue...");
        new Scanner(System.in).nextLine();
    }
}
