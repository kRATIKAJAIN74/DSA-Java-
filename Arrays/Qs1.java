package Arrays;
import java.util.Scanner;
 class Qs1 {
    static int lastOccurrence(int arr[], int x){
        int count=0;
      for(int i=0;i<arr.length;i++){
        if(arr[i]==x){
          count++;
        }
      }
      return count;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println(n);
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter x");
        int x = sc.nextInt();
        Qs1 obj = new Qs1();
        obj.lastOccurrence(arr, x);
    }
   
}
