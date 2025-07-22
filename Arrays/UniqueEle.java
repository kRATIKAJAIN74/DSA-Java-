
package Arrays;
import java.util.Scanner;

public class UniqueEle {
    static int findUnique(int arr[]){
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i] == arr[j]){
                    arr[i] = -1;
                    arr[j] =-1;
                }
            }
        }
        int met = -1;
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                met = arr[i];
            }
        }
        return met;
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
        
        System.out.println("UniqueElement: " + findUnique(arr));
    }
}


