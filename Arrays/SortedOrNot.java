package Arrays;
import java.util.Scanner;
public class SortedOrNot {
    static boolean isSorted(int[] arr){
        boolean check = true;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                check=false;
                break;
            }
        }
        return check;
    }

public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println(n);
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        // System.out.println("Enter x");
        // int x = sc.nextInt();
        // SortedOrNot obj = new SortedOrNot();
        // obj.isSorted(arr);
         if (isSorted(arr)) {
            System.out.println("Array is sorted");
        } else {
            System.out.println("Array is not sorted");
        }
    }
   
}
