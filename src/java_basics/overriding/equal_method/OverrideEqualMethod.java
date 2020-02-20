package java_basics.overriding.equal_method;

class Complex {
    private double re, im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        Complex c = (Complex) o;
        return Double.compare(this.re, c.re) == 0 && Double.compare(this.im, c.im) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)this.re + (int)this.im;
        return result;
    }
}
public class OverrideEqualMethod{

}