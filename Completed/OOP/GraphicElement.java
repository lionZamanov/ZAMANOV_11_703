package OOP;

import java.awt.*;

public class GraphicElement {
   private int x, y; // положение на экране
   public GraphicElement(int nx, int ny) {
      super(); // обращение к конструктору родителя Object
      System.out.println("GraphicElement");
      x=nx;
      y=nx;
   }
}
