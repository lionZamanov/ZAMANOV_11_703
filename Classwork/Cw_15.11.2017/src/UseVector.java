public class UseVector {
    public static void main(String[] args) {
        Vector2D vector = new Vector2D(7,2);
        Vector2D vector1 = new Vector2D(10,5);
        RationalFraction fr = new RationalFraction(-34,25);
        System.out.println(fr.n);
        System.out.println(fr.m);
        System.out.println(fr.value());
        System.out.println(fr.toString());
        System.out.println(fr.numberPart());
    }
}
