package day25;


//Prototype Interface
interface Plant extends Cloneable {
 void grow();
 String getGrowthType();
 void setGrowthType(String type);
 Plant clone(); // Prototype method
}

//Concrete Prototype 1
class Creeper implements Plant {
 private String growthType;

 public Creeper(String growthType) {
     this.growthType = growthType;
 }

 @Override
 public void grow() {
     System.out.println("Creeper growing as: " + growthType);
 }

 @Override
 public String getGrowthType() {
     return growthType;
 }

 @Override
 public void setGrowthType(String type) {
     this.growthType = type;
 }

 @Override
 public Plant clone() {
     return new Creeper(this.growthType);
 }
}

//Concrete Prototype 2
class Shrub implements Plant {
 private String growthType;

 public Shrub(String growthType) {
     this.growthType = growthType;
 }

 @Override
 public void grow() {
     System.out.println("Shrub growing as: " + growthType);
 }

 @Override
 public String getGrowthType() {
     return growthType;
 }

 @Override
 public void setGrowthType(String type) {
     this.growthType = type;
 }

 @Override
 public Plant clone() {
     return new Shrub(this.growthType);
 }
}

//Client
public class HomeTask06_PrototypeExample {
 public static void main(String[] args) {
     // Original objects
     Plant creeper = new Creeper("Climbing");
     Plant shrub = new Shrub("Bushy");

     // Cloning
     Plant creeperClone = creeper.clone();
     Plant shrubClone = shrub.clone();

     // Using clones
     creeperClone.setGrowthType("Hanging");
     shrubClone.setGrowthType("Flowering");

     creeper.grow();       // Creeper growing as: Climbing
     creeperClone.grow();  // Creeper growing as: Hanging

     shrub.grow();         // Shrub growing as: Bushy
     shrubClone.grow();    // Shrub growing as: Flowering
 }
}
