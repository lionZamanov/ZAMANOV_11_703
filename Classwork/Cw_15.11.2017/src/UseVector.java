public class UseVector {
    public static void main(String[] args) {
        Vector2D vector = new Vector2D(7,2);
        Vector2D vector1 = new Vector2D(10,5);
        System.out.println(vector.toString());
        System.out.println(vector1.toString());
        vector.mult2(7);
        System.out.println(vector.toString());
    }
}
