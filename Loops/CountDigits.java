package Loops;
 import java.util.Scanner;
public class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int sumOfDigits = 0;
        while(i>0){
           sumOfDigits += i%10;
         i = i/10;
         
        }
        System.out.println(sumOfDigits);
    }
}
