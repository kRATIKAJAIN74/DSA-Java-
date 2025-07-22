 package Arrays;
 
 class SumArrays {
     void sumOfArray(){
   int arr[] = {1,2,3,4,5,6};
   int sum = 0;
   
   for(int i =0;i<arr.length;i++){
    System.out.println(arr[i]);
    sum = sum + arr[i];
   }
   System.out.println(sum);
     }
      
}
public class Array {
    public static void main(String[] args) {
        Main obj = new Main();
        obj.sumOfArray();
    }
}
