public class ComplexNumber {
    public int real;
    public int im;

    public ComplexNumber(){
        real = 0;
        im = 0;
    }
    public ComplexNumber(int real, int im){
        this.real = real;
        this.im = im;
    }

    public ComplexNumber add(ComplexNumber complex){
        ComplexNumber c = new ComplexNumber();
        c.real = this.real + complex.real;
        c.im = this.im + complex.im;
        return c;
    }
    public void add2(ComplexNumber complex){
        this.real += complex.real;
        this.im += complex.im;
    }
    public ComplexNumber sub(ComplexNumber complex){
        ComplexNumber r = new ComplexNumber();
        r.real = this.real - complex.real;
        r.im = this.im = complex.im;
        return r;
    }
    public void sub2(ComplexNumber complex){
        this.real -= complex.real;
        this.im -= complex.im;
    }
    public ComplexNumber mult(ComplexNumber complex){
        ComplexNumber r = new ComplexNumber();
         r.real = this.real*complex.real - this.im*complex.im;
         r.im = this.real*complex.im + this.im*complex.real;
         return r;
    }
    public void mult2(ComplexNumber complex){
        this.real = this.real*complex.real - this.im*complex.im;
        this.im = this.real*complex.im + this.im*complex.real;
    }
    public ComplexNumber div(ComplexNumber complex){
        ComplexNumber r = new ComplexNumber();
        int k = this.real*this.real + this.im*this.im;
        r.real = (this.real*complex.real + this.im*complex.im)/k;
        r.im = (complex.im*this.im - this.real*complex.im)/k;
        return r;
    }
    public void div2(ComplexNumber complex){
        int k = this.real*this.real + this.im*this.im;
        this.real = (this.real*complex.real + this.im*complex.im)/k;
        this.im = (complex.im*this.im - this.real*complex.im)/k;
    }

    @Override
    public String toString() {
        return " " + real + im;
    }
    public boolean equals(ComplexNumber complex){
        return this.real == complex.real && this.im == complex.im;
    }

}
