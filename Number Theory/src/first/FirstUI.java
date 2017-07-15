package first;

import java.io.IOException;
import java.util.Scanner;

public class FirstUI {

    public static void main(String[] args) throws Exception, IOException {
        // TODO Auto-generated method stub
        FirstImp test = new FirstImp();
        Scanner input = new Scanner(System.in);
        System.out.println("Working.....");
        System.out.println("Enter A:");
        test.setBase(input.nextLine());
        System.out.println("Enter B:");
        test.setPower(input.nextLine());
        System.out.println("Enter N:");
        test.setNumber(input.nextLine());
        // Method 1
        long startTime, endTime;
        long ar[] = new long[3];
        startTime = System.currentTimeMillis();
        test.binaryCalculation().toString();
        endTime = System.currentTimeMillis();
        ar[0] = endTime - startTime;
        System.out.println("Method 1 : " + ar[0] + "ms");
        // End Method 1
        // Method 2
        startTime = System.currentTimeMillis();
        test.linearCalculation().toString();
        endTime = System.currentTimeMillis();
        ar[1] = endTime - startTime;
        System.out.println("Method 2 : " + ar[1] + "ms");
        // End Method2
        // Method 3
        startTime = System.currentTimeMillis();
        test.optimizedLinearCalculation().toString();
        endTime = System.currentTimeMillis();
        ar[2] = endTime - startTime;
        System.out.println("Method 3 : " + ar[2] + "ms");
        // End of Method 3
        input.close();
    }

}
