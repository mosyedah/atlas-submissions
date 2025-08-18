package day25;

//Composite
import java.util.ArrayList;
import java.util.List;
//Component
interface Graphic {
 void draw();
}

//Leaf
class Circle implements Graphic {
 public void draw() {
     System.out.println("Drawing a Circle");
 }
}

class Square implements Graphic {
 public void draw() {
     System.out.println("Drawing a Square");
 }
}


class GraphicGroup implements Graphic {
 private List<Graphic> children = new ArrayList<>();

 public void add(Graphic g) { children.add(g); }
 public void remove(Graphic g) { children.remove(g); }


 // behaves same as circle or squrare
 public void draw() {
     for (Graphic g : children) {
         g.draw();
     }
 }
}

//Client
public class HomeTask02_CompositeExample {
 public static void main(String[] args) {
     Circle c1 = new Circle();
     Square s1 = new Square();

     GraphicGroup group = new GraphicGroup();
     group.add(c1);
     group.add(s1);

     GraphicGroup bigGroup = new GraphicGroup();
     bigGroup.add(group);
     bigGroup.add(new Circle());

     bigGroup.draw(); // Draws everything in both groups
 }
}

