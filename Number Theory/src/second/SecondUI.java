package second;

import java.util.Scanner;

public class SecondUI {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SecondImp test = new SecondImp();
        Scanner input = new Scanner(System.in);
        System.out.println("Working.....");
        System.out.println("Set N :");
        test.setBase(input.nextLong());
        System.out.println("Set A");
        test.setNumber(input.nextLong());
        System.out.println("Result:");
        System.out.println(test.calculate());
        input.close();

    }

}
