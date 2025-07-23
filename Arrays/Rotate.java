package Arrays;
import java.util.Scanner;
public class Rotate {
    static void reverse(int[] arr, int i, int j){
        while(i<j){
            swap(arr, i, j);
            i++;
            j--;
        }
        
    }
     static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void rotateInPlace(int[] arr,int k){
        int n = arr.length;
        k = k%n;
        reverse(arr, 0, n-k-1);
        reverse(arr, n-k, n-1);
        reverse(arr, 0, n-1);
    }
    static void printArray(int[] arr){
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       System.out.println("Enter the size of array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();

        }
        System.out.println("Enter k: ");
        int k = sc.nextInt();
        System.out.println("Original Array: ");
       printArray(arr);
       rotateInPlace(arr,k);
        // int[] ans = rotate(arr, k);
        System.out.println("Array after rotation: ");
        printArray(arr);
    }
}
