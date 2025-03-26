import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

class ShoppingCart {
  private HashMap<String, Double> productprices = new HashMap<>(); // put the product with price in hashmap
  private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>(); // sort by price using linkedHashMap

  public void addProduct(String name, Double price) {
    productprices.put(name, price); // adding to the hashmap
  }

  public void addToCart(String product, int quantity) {
    if (!productprices.containsKey(product)) {
      System.out.println(" ❌ Product not found");
      return;
    }

    cart.put(product, cart.getOrDefault(product, 0) + quantity); // adding to the cart
  }

  public void displayProducts() {
    System.out.println("All the products added: ");
    for (var entry : cart.entrySet()) {
      System.out.println("Product name: " + entry.getKey() + " : " + entry.getValue() + " and price for each: "
          + productprices.get(entry.getKey())); // printing prices, qty and name
    }
  }

  public void displayBysortedPrice() {
    TreeMap<Double, String> sortedByprice = new TreeMap<>(); // sorted by price

    for (var entry : cart.entrySet()) {
      sortedByprice.put(productprices.get(entry.getKey()), entry.getKey()); // productprices.get because its double
    }

    // sort by prices
    System.out.println("\n💰 Cart Sorted by Price (Ordered by Addition) :");

    for (var entry : sortedByprice.entrySet()) {
      System.out.println("price: " + entry.getKey() + " product: " + entry.getValue());
    }
  }
}

public class cartImplementation {
  public static void main(String[] args) {
    ShoppingCart cart = new ShoppingCart();

    cart.addProduct("Apple", 1.5);
    cart.addProduct("Banana", 0.8);
    cart.addProduct("Cherry", 2.0);
    cart.addProduct("Dates", 3.0);

    // Adding items to the cart
    cart.addToCart("Apple", 2);
    cart.addToCart("Banana", 5);
    cart.addToCart("Cherry", 1);
    cart.addToCart("Dates", 3);

    cart.displayProducts();
    cart.displayBysortedPrice();
  }
}
