package Arrays;
import java.util.Scanner;
public class RepeatingNum {
    static int firstRepeatingNum(int arr[]){
        int n = arr.length;
        // int ans  = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]== arr[j]){
                    return arr[i];
                }
            }
        }
        return -1;
    }
     public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter Array Size: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter " + n + " Elements");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        
        System.out.println(" First Repeating Num: " + firstRepeatingNum(arr));
    }
}
