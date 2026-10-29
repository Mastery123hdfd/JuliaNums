public class ComplexNumber {
    private double real;
    private double comp;
    private final double DIFF = 0.00000001;
    public ComplexNumber(double real, double comp){
        this.real = real;
        this.comp = comp;
    }
    /**
     * Returns the real part of the complex number
     *@return Real part of the complex number
     */
    public double getReal(){return real;}
    /**
     * Returns Complex part of the complex number
     * @return Complex part of the complex number
     */
    public double getImaginary(){return comp;}

    /**
     * Creates and returns a String interpretation of this class
     * @return String interpretation of this class; real + complex i
     */
    public String toString(){return ""+(real==0.0 ? "" : real)+((comp>=0 && real !=0.0 && comp != 0.0) ? "+" : "") + (comp == 0.0 ? "" :(comp+"i"));}

    /**
     * Returns whether two Complex Numbers are matching; if tried to compare with a non-ComplexNumber object, will catch ClassCastException.
     * @param other
     * @return
     */
    public boolean equals(Object other) {
        try{
            ComplexNumber cn =(ComplexNumber)other;
            return ((Math.abs(this.real-cn.getReal())<DIFF)&&(Math.abs(this.comp - cn.getImaginary())<DIFF));
        } catch(ClassCastException e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Returns this complex number added with another as a new ComplexNumber object
     * @param complex
     * @return This complex number added with another
     */
    public ComplexNumber plus(ComplexNumber complex){
        return new ComplexNumber(this.real+complex.getReal(),this.comp+complex.getImaginary());
    }

    /**
     * Adds a floating-point double to the current Complex Number and returns the result as a new ComplexNumber object, does not modify this object.
     * @param val
     * @return Complex number with added REAL floating-point value
     */
    public ComplexNumber plus(double val){
        return new ComplexNumber(this.real+val,this.comp);
    }

    /**
     * Returns a new ComplexNumber object from multiplying this complex number with another ComplexNumber object
     * @param complex
     * @return This complex number multiplied with another complex number
     */
    public ComplexNumber times(ComplexNumber complex){
        return new ComplexNumber(this.real * complex.getReal() - this.comp * complex.getImaginary(), this.real * complex.getImaginary() + this.comp * complex.getReal());
    }

    /**
     * Returns a new ComplexNumber object by multiplying the real and imaginary components by a parameter d
     * @param d
     * @return This complex number multiplied by a real number D
     */
    public ComplexNumber times(double d){return new ComplexNumber(this.real*d,this.comp*d);}

    /**
     * Returns a new ComplexNumber object by dividing this object by another
     * @param complex
     * @return Result of dividing this object with the parameter
     */
    public ComplexNumber dividedBy(ComplexNumber complex){
        return this.times(complex.getConjugate()).times(1/(Math.pow(real,2)+Math.pow(comp,2)));
    }

    /**
     * Gets the conjugate of the ComplexNumber and returns as a new ComplexNumber object
     * @return Conjugate of this complex number
     */
    public ComplexNumber getConjugate(){return new ComplexNumber(this.real,-this.comp);}

    /**
     * Returns a new ComplexNumber object that is this object to the power of x; if x is not positive, will throw an IllegalArgumentException.
     * @param x, the pow
     * @return This ComplexNumber raised to a power
     * @throws IllegalArgumentException
     */
    public ComplexNumber pow(int x) throws IllegalArgumentException{
        if(x<=0) throw new IllegalArgumentException("X must be positive in ComplexNumber.pow()!");
        if(x==1) return this;
        return this.pow(x-1).times(this);
    }
    private ComplexNumber pow(ComplexNumber cn){
        ComplexNumber cn1 = new ComplexNumber(Math.cos((cn.getReal()*this.getArgument()+0.5*cn.getImaginary()*Math.log(real*real+comp*comp))), Math.sin(cn.getReal()*getArgument()+0.5*cn.getImaginary()*Math.log(real*real+comp*comp)));
        double cons = Math.pow(real*real+comp*comp,cn.getReal()/2)*Math.pow(Math.E,-cn.getImaginary()*this.getArgument());
        return cn1.times(cons);
    }

    /**
     * Calculates the distance this point is from zero on the complex coordinate plane and returns it as a primitive double type
     * @return Modulus, or distance from zero on the complex coordinate plane
     */
    public double getModulus(){
        return Math.sqrt(Math.pow(real,2)+Math.pow(comp,2));
    }

    private double getArgument(){
        return Math.atan(comp/real);
    }

}
