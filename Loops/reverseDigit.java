package Loops;
 import java.util.Scanner;
public class reverseDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int ans = 0;
        while(i>0){
          ans =  ans*10 + i%10;
          i/=10;
        }
        System.out.println(ans);
    }
}
