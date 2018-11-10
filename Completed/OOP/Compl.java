package OOP;

public class Compl {
    private double a;
    private double b;

    public Compl() {
        a = 0;
        b = 0;
    }

    public Compl(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }


    public void init(double a, double b) {
        this.a = a;
        this.b = b;

    }

    public Compl add(Compl c) {
        Compl d = new Compl();
        d.a = this.a + c.a;
        d.b = b + c.b;
        return d;
    }

    public void addVoid(Compl c) {
        a = a + c.a;
        b = b + c.b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Compl compl = (Compl) o;

        if (Double.compare(compl.a, a) != 0) return false;
        return Double.compare(compl.b, b) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(a);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(b);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Compl{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
