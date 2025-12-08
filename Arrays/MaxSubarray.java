package Arrays;

public class MaxSubarray {
  public static void maxSubarray(int arr[]){
    int maxSum = Integer.MIN_VALUE; // Using kadanes Theorem
    int currSum = 0;
     for(int i=0;i<arr.length;i++){
      currSum+=arr[i];
      if(currSum<0){
        currSum=0;
      }
      maxSum = Math.max(currSum, maxSum);
     }
    
    System.out.println(maxSum);
  }
  public static void main(String[] args) {
    int arr[] = {2,4,6,8,10};
    maxSubarray(arr);
  }
}
