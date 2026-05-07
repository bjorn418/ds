import java.rmi.*;

public interface ServerIntf extends Remote{
    public double Addition(double num1, double num2) throws RemoteException;
    // double Subtraction(double num1, double num2) throws RemoteException;

    // double Multiplication(double num1, double num2) throws RemoteException;

    // double Division(double num1, double num2) throws RemoteException;

    // double PowerOfTwo(double num1) throws RemoteException;

    // double CelsiusToFahrenheit(double num1) throws RemoteException;

    // double MilesToKm(double num1) throws RemoteException;

     String Echo(String name) throws RemoteException;

     String StringComparison(String str1, String str2) throws RemoteException;

    // int CountVowels(String str) throws RemoteException;

    // int Factorial(int n) throws RemoteException;
}