package first;

import java.math.BigInteger;

public class FirstImp {

    /**
     *  
     *  Global parameters :
     *              base : to save base of the number ( a )
     *              
     *              power : to save to power ( b )
     *              
     *              number : the modular number ( n )
     *              
     *              result : (a^b) % n
     *  
     * */
    private BigInteger base, power, number, result;

    /**
     *  This method is used to set the Base
     *  
     *      @param base
     * 
     * */
    public void setBase(String base) {
        this.base = new BigInteger(base);
    }
    /**
     * 
     *  set the number ( n )
     *      @param number : the input
     * 
     * */

    public void setNumber(String number) {
        this.number = new BigInteger(number);
    }
    /**
     *  set the power
     *      @param power 
     *  
     * */
    public void setPower(String power) {
        this.power = new BigInteger(power);
    }
    /**
     *  get the final result
     *  
     *      @return result
     *  
     * */
    public BigInteger getResult() {
        return result;
    }
    /**
     *  this method is used to calculate the expression 
     *  in a way that divide the power into 2 identical smaller number
     *  in order to calculate the final result in Logarithmic time
     *      
     *      @return result :
     *                  the final result
     * */
    public BigInteger binaryCalculation() {
        BigInteger result = calc(base, power, number);
        return this.result = result;
    }
    /**
     *  this method calculate the expression linearly by multiplying 
     *  the base power times until it reach base^power 
     *  then get the modular of the result and return it
     *      
     *      @return result
     * 
     * */
    public BigInteger linearCalculation() {
        BigInteger i = BigInteger.ZERO;
        BigInteger result = BigInteger.ONE;
        while (i.compareTo(power) < 0) {
            result = result.multiply(base);
            i = i.add(BigInteger.ONE);
        }
        result = result.mod(number);
        return this.result = result;
    }
    /**
     *  this method calculate the expression while taking the modular ( % )
     *  by taking the modular in the loop which will get the same result 
     *  according to this relation ( A * B )% M = ( A%M * B%M ) % M
     *      
     *      @return result
     * 
     * */
    public BigInteger optimizedLinearCalculation() {
        BigInteger i = BigInteger.ZERO;
        BigInteger result = BigInteger.ONE;
        while (i.compareTo(power) < 0) {
            result = result.multiply(base).mod(number);
            i = i.add(BigInteger.ONE);
        }
        return this.result = result;
    }
    /**
     *  this method is called from binaryCalculation , this is a helper method
     *  in order to calculate the result in logarithmic time
     *  
     *      @return result
     * 
     * */
    private BigInteger calc(BigInteger base, BigInteger power, BigInteger number) {
        if (power.compareTo(BigInteger.ZERO) == 0) {
            return new BigInteger("1");
        }
        BigInteger tmp = calc(base, power.divide(new BigInteger("2")), number).mod(number);
        if (power.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
            return (tmp.multiply(tmp)).mod(number);
        } else {
            return tmp.multiply(tmp).mod(number).multiply(base.mod(number)).mod(number);
        }
    }

}
