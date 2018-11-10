package OOP;

import java.awt.*;

public class SmallColorSquare extends Square {
   private Color color;
   public SmallColorSquare(int x, int y, Color c) {
      super(x, y, 5);
      System.out.println("SmallColorSquare");
      color=c;
   }}
