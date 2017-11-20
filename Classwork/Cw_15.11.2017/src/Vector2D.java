public class Vector2D {
    double x;
    double y;

    public Vector2D(){
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Vector2D add(Vector2D vector){
        Vector2D nw = new Vector2D();
        nw.x = vector.x + this.x;
        nw.x = vector.y + this.y;
        return nw;
    }

    public void add2(Vector2D vector){
        this.x += vector.x;
        this.y += vector.y;
    }

    public Vector2D sub(Vector2D vector){
        Vector2D nw = new Vector2D();
        nw.x = vector.x - this.x;
        nw.x = vector.y - this.y;
        return nw;
    }

    public void sub2(Vector2D vector){
        this.x -= vector.x;
        this.y -= vector.y;
    }

    public Vector2D mult(double a){
        Vector2D nw = new Vector2D();
        nw.x *= a;
        nw.y *= a;
        return nw;
    }

    public void mult2(double a){
        this.x *= a;
        this.y *= a;
    }

    @Override
    public String toString() {
        return "x = " + x +
                " y = " + y;
    }

    public double length(){
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double scalarProduct(Vector2D vector){
        return this.x * vector.x + this.y * vector.y;
    }
    public double cos(Vector2D vector){
        return (scalarProduct(this)*scalarProduct(vector))/(vector.length()*this.length());
    }

    public boolean equals(Vector2D vector){
        if (this.x != vector.x) return false;
        return this.y == vector.y;
    }
}
