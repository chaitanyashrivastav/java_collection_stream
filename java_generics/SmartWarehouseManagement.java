import java.util.ArrayList;
import java.util.List;

// class representing items in the warehouse
abstract class WarehouseItem {
  private int id;
  private String name;

  public WarehouseItem(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public abstract void displayDetails(); // Abstract method to display item-specific details
}

class Electronics extends WarehouseItem {
  private String brand;

  public Electronics(int id, String name, String brand) {
    super(id, name);
    this.brand = brand;
  }

  @Override
  public void displayDetails() {
    System.out.println("Electronics-id: " + getId() + " Electronics-name: " + getName() + " brand: " + brand);
  }
}

class Groceries extends WarehouseItem {
  private String expiry;

  public Groceries(int id, String name, String brand) {
    super(id, name);
    this.expiry = expiry;
  }

  @Override
  public void displayDetails() {
    System.out.println("Groceries-id: " + getId() + " Groceries-name: " + getName() + " expiry-date: " + expiry);
  }
}

class Furniture extends WarehouseItem {
  private String material;

  public Furniture(int id, String name, String material) {
    super(id, name);
    this.material = material;
  }

  @Override
  public void displayDetails() {
    System.out.println("Furniture-id: " + getId() + " Furniture-name: " + getName() + " material: " + material);
  }
}

class Storage<T extends WarehouseItem> {
  private List<T> items = new ArrayList<>();

  public void addItem(T item) {
    items.add(item);
  }

  public List<T> getItemList() {
    return items;
  }
}

// for printing purposes
class WarehouseUtils {
  public static void displayItems(List<? extends WarehouseItem> items) {
    for (WarehouseItem item : items) {
      item.displayDetails();
    }
  }
}

public class SmartWarehouseManagement {

  public static void main(String[] args) {
    Storage<Electronics> electronicsStorage = new Storage<>();
    Storage<Groceries> groceriesStorage = new Storage<>();
    Storage<Furniture> furnitureStorage = new Storage<>();

    electronicsStorage.addItem(new Electronics(101, "Laptop", "Dell"));
    electronicsStorage.addItem(new Electronics(102, "Smartphone", "Samsung"));

    groceriesStorage.addItem(new Groceries(201, "Milk", "2025-01-10"));
    groceriesStorage.addItem(new Groceries(202, "Bread", "2024-04-05"));

    furnitureStorage.addItem(new Furniture(301, "Chair", "Wood"));
    furnitureStorage.addItem(new Furniture(302, "Table", "Metal"));

    WarehouseUtils.displayItems(electronicsStorage.getItemList());
    System.out.println();
    WarehouseUtils.displayItems(furnitureStorage.getItemList());
    System.out.println();
    WarehouseUtils.displayItems(groceriesStorage.getItemList());
  }
}