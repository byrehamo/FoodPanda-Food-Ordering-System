package FoodPandaApp;

// Class representing a menu item
public class MenuItem {
    String name; // Name of the food item
    double price; // Price of the item

    // Constructor with parameters
    public MenuItem(String name, double price) {
        this.name = name; // Set the name of the item
        this.price = price; // Set the price of the item
    }

    // Default constructor
    public MenuItem() {
        this.name = "Unnamed Item"; // Default name
        this.price = 0.0; // Default price
    }

    // Getter for name
    public String getName() {
        return name; // Return the name of the item
    }

    // Getter for price
    public double getPrice() {
        return price; // Return the price of the item
    }

    // Override toString method for displaying item details
    public String toString() {
        return String.format("%s ฿%.2f", name, price); // Format the output
    }
}
