package third;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Testing {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        ThirdImp test = new ThirdImp();
        long testNumber = 2 * 3 * 5 * 7 * 11 * 13 * 17 * 19;
        test.setMapSize(8);
        test.setSmallM(0, 2);
        test.setSmallM(1, 3);
        test.setSmallM(2, 5);
        test.setSmallM(3, 7);
        test.setSmallM(4, 11);
        test.setSmallM(5, 13);
        test.setSmallM(6, 17);
        test.setSmallM(7, 19);
        test.calculateM();
        test.getInverses();
        long start;
        long end;
        PrintWriter writer = new PrintWriter("points2.txt", "UTF-8");
        for (int i = 1; i < 100; i++) {
            long first = (long) (Math.random() * ((testNumber - 1)) + 1);
            long second = (long) (Math.random() * ((testNumber - 1)) + 1);
            long[] map1 = test.getMap(first);
            long[] map2 = test.getMap(second);
            long[] addition = new long[8];
            writer.print((first + second) + "                      ");
            start = System.nanoTime();
            // way1
            for (int j = 0; j < 8; j++) {
                addition[j] = (map1[j] + map2[j]) % test.getSmallM(j);
            }
            System.out.println(test.getNumber(addition));
            // end way1
            end = System.nanoTime();
            writer.print((end - start) + "                               ");
            start = System.nanoTime();
            // way2
            long res = (test.getNumber(map1) % testNumber + test.getNumber(map2) % testNumber) % testNumber;
            System.out.println(res);
            // end way2
            end = System.nanoTime();
            writer.print((end - start));
            writer.println();
        }
        writer.close();
        // End addition

    }

}
