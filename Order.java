package FoodPandaApp;

import java.util.ArrayList;

public class Order {
    private ArrayList<MenuItem> items;
    public static final double DELIVERY_FEE = 20.0;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
        System.out.println(" Added: " + item.getName());
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            System.out.println(" Removed: " + items.get(index).getName());
            items.remove(index);
        }
    }

    public int getItemCount() { return items.size(); }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("\n🛒 YOUR CART IS EMPTY");
            return;
        }

        System.out.println("\n🛒 YOUR CART (" + getItemCount() + " ITEMS)");
        System.out.println("----------------------------------");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
        System.out.println("----------------------------------");
        System.out.printf("Subtotal: ฿%.2f\n", calculateSubtotal());
    }

    public double calculateSubtotal() {
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public void printReceipt(double discountRate) {
        double subtotal = calculateSubtotal();
        double discountAmount = subtotal * discountRate;
        double total = subtotal - discountAmount + DELIVERY_FEE;

        System.out.println("\n ORDER RECEIPT");
        System.out.println("----------------------------------");
        items.forEach(item -> System.out.println("- " + item));
        System.out.println("----------------------------------");
        System.out.printf("Subtotal: ฿%.2f\n", subtotal);
        System.out.printf("Discount (%.0f%%): -฿%.2f\n", discountRate * 100, discountAmount);
        System.out.printf("Delivery Fee: ฿%.2f\n", DELIVERY_FEE);
        System.out.printf("TOTAL: ฿%.2f\n", total);
    }
}
