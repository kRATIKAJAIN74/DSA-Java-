package Loops;
// import java.util.Scanner;
public class Multiple5or7 {
    public static void main(String[] args) {
        int num = 1;
    while(true){
        if ((num % 5 == 0) && (num % 7 == 0)){
            System.out.println("Found Answer " + num);
            break;
        }
        num++;
    }
    }
    // Scanner sc  = new Scanner(System.in);
    // int num = sc.nextInt();
    

}
 

