public class Matrix2x2 {
    double[][] Matrix = new double[2][2];
    public Matrix2x2(){
        fillMatrix(0);
    }
    public Matrix2x2(double a){
        fillMatrix(a);
    }
    public Matrix2x2(double[][] Matrix){
        this.Matrix = Matrix;
    }
    public Matrix2x2(double a, double b, double c, double d){
        Matrix[0][0] = a;
        Matrix[0][1] = b;
        Matrix[1][0] = c;
        Matrix[1][1] = d;
    }
    public Matrix2x2 add(Matrix2x2 matrix){
        Matrix2x2 m = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.Matrix[i][j] = this.Matrix[i][j] + matrix.Matrix[i][j];
            }
        }
        return m;
    }
    public void add2(Matrix2x2 matrix){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.Matrix[i][j] += matrix.Matrix[i][j];
            }
        }
    }
    public Matrix2x2 sub(Matrix2x2 matrix){
        Matrix2x2 m = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.Matrix[i][j] = this.Matrix[i][j] - matrix.Matrix[i][j];
            }
        }
        return m;
    }
    public void sub2(Matrix2x2 matrix){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.Matrix[i][j] -= matrix.Matrix[i][j];
            }
        }
    }
    public Matrix2x2 multNumber(double a){
        Matrix2x2 m = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.Matrix[i][j] *= a;
            }
        }
        return m;
    }
    public void multNumber2(double a){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.Matrix[i][j] *= a;
            }
        }
    }
    public Matrix2x2 mult(Matrix2x2 matrix){
        Matrix2x2 m = new Matrix2x2();
        for (int line = 0; line < 2; line++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < this.Matrix.length; k++) {
                    m.Matrix[line][j] += this.Matrix[line][k]*matrix.Matrix[k][j];
                }
            }
        }
        return m;
    }
    public void mult2(Matrix2x2 matrix){
        double[][] m = new double[2][2];
        for (int line = 0; line < 2; line++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    m[line][j] += this.Matrix[line][k]*matrix.Matrix[k][j];
                }
            }
        }
        this.Matrix = m;
    }
    public double det(){
        return Matrix[0][0]*Matrix[1][1] - Matrix[0][1]*Matrix[1][0];
    }
    public void transpon(){
        double a = Matrix[0][1];
        Matrix[0][1] = Matrix[1][0];
        Matrix[1][0] = a;
    }
    public Matrix2x2 inverseMatrix(){
        Matrix2x2 m = new Matrix2x2();
        if(this.det() != 0){
            m.Matrix[0][0] = Matrix[1][1]/det();
            m.Matrix[0][1] = -Matrix[1][0]/det();
            m.Matrix[1][0] = -Matrix[0][1];
            m.Matrix[1][1] = Matrix[0][0];
            m.transpon();
            return m;
        }
        System.out.println("Ошибка!");
        return m;
    }
    public void fillMatrix(double a){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Matrix[i][j] = a;
            }
        }
    }
    public Vector2D multVector(Vector2D vector){
        Vector2D v = new Vector2D();
        v.x = Matrix[0][0]*vector.x + Matrix[0][1]*vector.y;
        v.y = Matrix[1][0]*vector.x + Matrix[1][1]*vector.y;
        return v;
    }
}
