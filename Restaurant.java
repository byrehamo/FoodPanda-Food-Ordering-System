package FoodPandaApp;

import java.util.ArrayList;

public class Restaurant {
     String name;
     String cuisineType;
     int rating;
     ArrayList<MenuItem> menu;

    public Restaurant(String name, String cuisineType, int rating) {
        this.name = name;
        this.cuisineType = cuisineType;
        this.rating = rating;
        this.menu = new ArrayList<>();
    }

    public void addMenuItem(String name, double price) {
        menu.add(new MenuItem(name, price));
    }

    public ArrayList<MenuItem> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " " + "★".repeat(rating) + " (" + cuisineType + ")";
    }
}
