// Parent class
class Animal {
  void makeSound() {
      System.out.println("Animal makes a sound");
  }
}

class Dog extends Animal {
  @Override
  void makeSound() {
      System.out.println("Dog barks");
  }
}

public class Animal_Runner {
  public static void main(String[] args) {
      Dog myDog = new Dog();
      myDog.makeSound();  // This will call the overridden method in Dog class
  }
}
