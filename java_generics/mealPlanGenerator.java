interface MealPlan {
  void displaydetails();
}

class VegetarianMeal implements MealPlan {

  @Override
  public void displaydetails() {
    System.out.println("Vegetarian Meal: Grilled vegetables with quinoa.");
  }

}

class Vegan implements MealPlan {

  @Override
  public void displaydetails() {
    System.out.println("Vegan Meal: Tofu stir-fry with brown rice.");
  }
}

class HighPro implements MealPlan {
  @Override
  public void displaydetails() {
    System.out.println("High-Protein Meal: Steak with steamed broccoli.");
  }
}

class KetoMeal implements MealPlan {
  @Override
  public void displaydetails() {
    System.out.println("Keto Meal: Grilled chicken with avocado salad.");
  }
}

class Meal<T extends MealPlan> {
  private T meal ;

  public Meal(T meal){
    this.meal = meal ; 
  }

  public void serveMeal(){
    meal.displaydetails();
  }
}

public class mealPlanGenerator {
  public static void main(String[] args) {
    Meal<VegetarianMeal> vegetarianMeal = new Meal<>(new VegetarianMeal());
    vegetarianMeal.serveMeal();

    Meal<HighPro> highProteinMeal = new Meal<>(new HighPro()) ;//(arguement (instance of specific class)contains the logic for displaying the right info ) and <> includes meal-type

    highProteinMeal.serveMeal(); //object can use the logic of meal generic class
  }
}
