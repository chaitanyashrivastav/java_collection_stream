abstract class Product {
  private int id;
  private String type;
  protected int price ; 

  public Product(int id, String type,int price) {
    this.id = id;
    this.type = type;
    this.price = price ; 
  }

  public int getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {  
    this.price = price;
  }

  abstract void displayDetails();

  abstract <T extends Product> void applyDiscount(T product, double percentage);
}

class BookCategory extends Product {
  String bookName;

  BookCategory(int id, String type, String bookName, int price) {
    super(id, type,price);
    this.bookName = bookName; 
  }

  @Override
  public <T extends Product> void applyDiscount(T product, double percentage) {
    int discountedPrice = (int) (getPrice() - ((percentage /100) * getPrice())) ; 
    product.setPrice(discountedPrice);
    System.out.println("discounted price: "+discountedPrice);
  }

  @Override
  void displayDetails() {
    System.out.println("id : " + getId() + " type: " + getType() + " bookName: " + bookName+" Price: "+getPrice());
  }
}

class ClothingCategory extends Product {
  String clothName;
  

  ClothingCategory(int id, String type, String clothName, int price) {
    super(id, type,price);
    this.clothName = clothName;
  }

  @Override
  public <T extends Product> void applyDiscount(T product, double percentage) {
    int discountedPrice = (int) (product.getPrice() - ((percentage /100) * product.getPrice())) ; 
    product.setPrice(discountedPrice);
    System.out.println("discounted price: "+discountedPrice);
  }

  @Override
  void displayDetails() {
    System.out.println("id : " + getId() + " type: " + getType() + " apparels: " + clothName+"Price: "+getPrice());
  }
}

public class productMarketplace {
  public static void main(String[] args) {
    BookCategory book = new BookCategory(1, "Fiction", "Harry Potter", 500);
    book.displayDetails();

    book.applyDiscount(book, 20);
    book.displayDetails();
  }
}
