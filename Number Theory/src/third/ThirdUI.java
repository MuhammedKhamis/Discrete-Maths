package third;

import java.util.Scanner;

public class ThirdUI {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ThirdImp test = new ThirdImp();
        long[] firstMap, secondMap, result;
        long start, end;
        System.out.println("Working....");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter # of elements to be in the map :");
        int n = input.nextInt();
        test.setMapSize(n);
        firstMap = new long[n];
        secondMap = new long[n];
        result = new long[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter #" + (i + 1) + " : ");
            test.setSmallM(i, input.nextInt());
        }
        test.calculateM();
        test.getInverses();
        System.out.println("Enter Elements of A : ");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter #" + (i + 1) + " : ");
            firstMap[i] = input.nextInt();
        }
        System.out.println("Enter Elements of B : ");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter #" + (i + 1) + " : ");
            secondMap[i] = input.nextInt();
        }
        start = System.nanoTime();
        // Method 1
        for (int i = 0; i < n; i++) {
            result[i] = (firstMap[i] + secondMap[i]) % test.getSmallM(i);
        }
        System.out.print("Method 1 : " + test.getNumber(result));
        // End method 1
        end = System.nanoTime();
        System.out.println(" with time : " + (end - start) + " ns");
        start = System.nanoTime();
        // Method 2
        System.out.print("Method 2 : " + (test.getNumber(firstMap) + test.getNumber(secondMap)) % test.getBigM());
        // End method2
        end = System.nanoTime();
        System.out.println(" with time : " + (end - start) + " ns");
        input.close();

    }

}
