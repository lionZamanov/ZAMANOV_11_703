public class RationalFraction {
    public int n;
    public int m;

    public RationalFraction(){
        n = 0;
        m = 1;
    }
    public RationalFraction(int n, int m){
        this.n = n;
        if(m != 0) {
            this.m = m;
        }else this.m = 1;
        this.reduce();
    }
    public int NOD(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        while(a != b){
            if(a > b){
                a -= b;
            }else{
                b -= a;
            }
        }
        return a;
    }
    /*public int NOK(int a, int b){
        return a*b/NOD(a,b);
    }*/
    void reduce(){
        int k = NOD(m,n);
        n /= k;
        m /= k;
    }
    public RationalFraction add(RationalFraction fraction){
        RationalFraction r = new RationalFraction();
        if(r.m == fraction.m) {
            r.n = this.n + fraction.n;
            r.m = this.m + fraction.m;
        }else{
            r.n = this.n * fraction.m + fraction.n * this.m;
            r.m = this.m * fraction.m;
        }
        r.reduce();
        return r;
    }
    public void add2(RationalFraction fraction){
        if(this.m == fraction.m) {
            this.n += fraction.n;
            this.m += fraction.m;
        }else{
            this.n = this.n * fraction.m + fraction.n * this.m;
            this.m = this.m * fraction.m;
        }
        this.reduce();
    }
    public RationalFraction sub(RationalFraction fraction){
        RationalFraction r = new RationalFraction();
        if(r.m == fraction.m) {
            r.n = this.n - fraction.n;
            r.m = this.m - fraction.m;
        }else{
            r.n = this.n * fraction.m - fraction.n * this.m;
            r.m = this.m * fraction.m;
        }
        r.reduce();
        return r;
    }
    public void sub2(RationalFraction fraction){
        if(this.m == fraction.m) {
            this.n -= fraction.n;
            this.m -= fraction.m;
        }else{
            this.n = this.n * fraction.m - fraction.n * this.m;
            this.m = this.m * fraction.m;
        }
        this.reduce();
    }
    public RationalFraction mult(RationalFraction fraction){
        RationalFraction r = new RationalFraction();
        r.n = this.n * fraction.n;
        r.m = this.m * fraction.m;
        r.reduce();
        return r;
    }
    public void mult2(RationalFraction fraction){
        this.n *= fraction.n;
        this.m *= fraction.m;
        this.reduce();
    }
    public RationalFraction div(RationalFraction fraction){
        RationalFraction r = new RationalFraction();
        r.n = this.n * fraction.m;
        r.m = this.m * fraction.n;
        r.reduce();
        return r;
    }
    public void div2(RationalFraction fraction){
        this.n *= fraction.m;
        this.m *= fraction.n;
        this.reduce();
    }

    @Override
    public String toString() {
        return n + "/" + m;
    }
    public double value(){
        return (double)n/m;
    }
    public boolean equals(RationalFraction fraction){
        fraction.reduce();
        return this.n == fraction.n && this.m == fraction.m;
    }
    public int numberPart(){
        return this.n/this.m;
    }
}
