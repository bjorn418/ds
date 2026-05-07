
import java.rmi.*;
import java.util.Scanner;

public class Client{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        try {
            String serverURL = "rmi://localhost/Server";
            ServerIntf serInt = (ServerIntf) Naming.lookup(serverURL);

            System.out.println("1.Add 2.Sub 3.Mul 4.Div 5.Pow2 6.C->F 7.Mi->Km 8.Echo 9.StrCmp 10.Vowels 11.Fact");
            int choice = sc.nextInt();

            double num1, num2;
            String str1, str2;

            switch (choice) {

                case 1:
                    num1 = sc.nextDouble();
                    num2 = sc.nextDouble();
                    System.out.println(serInt.Addition(num1, num2));
                    break;

                // case 2:
                //     num1 = sc.nextDouble();
                //     num2 = sc.nextDouble();
                //     System.out.println(serInt.Subtraction(num1, num2));
                //     break;

                // case 3:
                //     num1 = sc.nextDouble();
                //     num2 = sc.nextDouble();
                //     System.out.println(serInt.Multiplication(num1, num2));
                //     break;

                // case 4:
                //     num1 = sc.nextDouble();
                //     num2 = sc.nextDouble();
                //     System.out.println(serInt.Division(num1, num2));
                //     break;

                // case 5:
                //     num1 = sc.nextDouble();
                //     System.out.println(serInt.PowerOfTwo(num1));
                //     break;

                // case 6:
                //     num1 = sc.nextDouble();
                //     System.out.println(serInt.CelsiusToFahrenheit(num1));
                //     break;

                // case 7:
                //     num1 = sc.nextDouble();
                //     System.out.println(serInt.MilesToKm(num1));
                //     break;

                 case 8:
                     str1 = sc.next();
                     System.out.println(serInt.Echo(str1));
                     break;

                 case 9:
                     str1 = sc.next();
                     str2 = sc.next();
                     System.out.println(serInt.StringComparison(str1, str2));
                     break;

                // case 10:
                //     str1 = sc.next();
                //     System.out.println(serInt.CountVowels(str1));
                //     break;

                // case 11:
                //     int n = sc.nextInt();
                //     System.out.println(serInt.Factorial(n));
                //     break;
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}



