package Basic;
import java.util.Scanner;
public class Simpleintrest{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Principal");
        float p = sc.nextFloat();
        System.out.println("Enter Rate: ");
        float r = sc.nextFloat();
        System.out.println("Enter Time: ");
        int t = sc.nextInt();
        float PI = (p*r*t)/100;
        System.out.println("Simple Intrest is: " + PI);
    }
}
