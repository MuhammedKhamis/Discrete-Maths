package third;

import second.SecondImp;

public class ThirdImp {

    /**
     * Global variables
     * 
     * helper : to use the extended eculid algorithm
     * 
     * bigM : the base when i convert any number to its map
     * 
     * smallMs : used to save the numbers which relatively prime to each other
     * and the result of their multiplication is bigM
     * 
     * bigMsInverse : save the inverse of bigM/smallMs[i] with respect to
     * smallMs[i]
     * 
     * 
     */

    private SecondImp helper;
    private long bigM;
    private long[] smallMs;
    private long[] bigMsInverse;

    public ThirdImp() {
        // TODO Auto-generated constructor stub
        helper = new SecondImp();
    }

    /**
     * to calculate the BigM
     * 
     */
    public void calculateM() {
        bigM = 1;
        for (int i = 0; i < smallMs.length; i++) {
            bigM *= smallMs[i];
        }
    }

    public long getBigM() {
        return bigM;
    }

    public void setMapSize(int size) {
        smallMs = new long[size];
        bigMsInverse = new long[size];
    }

    public void setSmallM(int index, int value) {
        smallMs[index] = value;
    }

    public long getSmallM(int index) {
        return smallMs[index];
    }

    /**
     * method which convert any number to the equivalent map
     * 
     * @param number
     *            : the input number we want to get its map
     * 
     * @return result : the final map
     * 
     */
    public long[] getMap(long number) {
        long[] result = new long[smallMs.length];
        for (int i = 0; i < smallMs.length; i++) {
            result[i] = number % smallMs[i];
        }
        return result;
    }

    /**
     * calculate the inverse of the BigM/smallMs[i] with respect to smallMs[i]
     * in order to convert from map to number easily
     * 
     */
    public void getInverses() {
        for (int i = 0; i < bigMsInverse.length; i++) {
            helper.setBase(smallMs[i]);
            helper.setNumber(bigM / smallMs[i]);
            bigMsInverse[i] = helper.calculate();
        }
    }

    /**
     * used to get the final number which convert any map to the number
     * 
     * @param map
     *            : the map i want to convert
     * 
     * @return number : the final result
     * 
     */
    public long getNumber(long[] map) {
        long number = 0;
        for (int i = 0; i < map.length; i++) {
            number += (bigM / smallMs[i]) * (bigMsInverse[i] % smallMs[i]) * map[i];
        }
        return number % bigM;
    }

}
