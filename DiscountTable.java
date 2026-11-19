package FoodPandaApp;

import java.util.Random;

//Class to handle discount generation
public class DiscountTable {
 // Static Random object to generate random numbers
 private static final Random random = new Random();

 // Method to get a random discount between 5% and 15%
 public static double getRandomDiscount() {
     return 0.05 + (0.10 * random.nextDouble()); // Returns a random discount
 }
}
