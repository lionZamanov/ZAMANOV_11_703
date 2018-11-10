package OOP;

public class Square extends GraphicElement {
   private int side;
   public Square(int x, int y, int nside) {
      super(x, y);
      System.out.println("Square");
       side=nside;
   }}