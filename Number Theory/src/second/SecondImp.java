package second;

public class SecondImp {
    
    /**
     * 
     *  Global parameters :
     *          number : to save the A
     *          
     *          base : to save the n 
     *          
     *          inverse : to save inverse of number modular base
     *          
     *          k : is a helper variable to get the inverse
     * 
     * */

    private long number, base, inverse, k;

    public void setBase(long base) {
        this.base = base;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getInverse() {
        return inverse;
    }
    /**
     *  main method which calculate the  inverse of the number 
     *   and get the inverse of the number 
     *      
     *      @return inverse ;
     * 
     * */
    public long calculate() {
        calc(number, base);
        return (inverse + base) % base;
    }
    
    /**
     * helper method used to calculate the inverse of the number
     * 
     *      @param number : the number i want to make its reverse
     *      
     *      @param base : the number which give one if i took number * its inverse
     *          mod base ;
     * 
     * 
     * */

    private void calc(long number, long base) {
        if (base == 0) {
            inverse = 1;
            k = 0;
            return;
        }
        calc(base, number % base);
        long tmp = inverse;
        inverse = k;
        k = tmp - ((number / base) * k);
    }

}
