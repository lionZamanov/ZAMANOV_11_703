public class RationalFraction {
    private int n;
    private int m;

    public RationalFraction(){
        n = 0;
        m = 1;
    }
    public RationalFraction(int n, int m){
        this.n = n;
        if(m != 0) {
            this.m = m;
        }else this.m = 1;
    }
    void reduce(){
        int a = n;
        int b = m;
        while(a != b){
            if(a > b){
                a -= b;
            }else{
                b -= a;
            }
        }
        n /= a;
        m /= b;
    }
    public 
}
