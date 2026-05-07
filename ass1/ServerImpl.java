import java.rmi.*;
import java.rmi.server.*;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf{
    public ServerImpl() throws RemoteException{

    }
    
    // this function changes according to the problem statement. Refer the Assignment_1.pdf
    // to know what exactly to put inside the function. Just change the retun statement.
    public double Addition(double num1, double num2) throws RemoteException{
        return num1 + num2;
    }
    // public double Subtraction(double num1, double num2) throws RemoteException {
//     return num1 - num2;
// }

// public double Multiplication(double num1, double num2) throws RemoteException {
//     return num1 * num2;
// }

// public double Division(double num1, double num2) throws RemoteException {
//     return num1 / num2;
// }

// public double PowerOfTwo(double num1) throws RemoteException {
//     return Math.pow(2, num1);
// }

// public double CelsiusToFahrenheit(double num1) throws RemoteException {
//     return (num1 * 9/5) + 32;
// }

// public double MilesToKm(double num1) throws RemoteException {
//     return num1 * 1.60934;
// }

 public String Echo(String name) throws RemoteException {
     return "Hello " + name;
 }

 public String StringComparison(String str1, String str2) throws RemoteException {
     return str1.compareTo(str2) > 0 ? str1 : str2;
 }

// public int CountVowels(String str) throws RemoteException {
//     return (int) str.toLowerCase().chars()
//             .filter(c -> "aeiou".indexOf(c) >= 0)
//             .count();
// }

// public int Factorial(int n) throws RemoteException {
//     return (n <= 1) ? 1 : n * Factorial(n - 1);
// }
}