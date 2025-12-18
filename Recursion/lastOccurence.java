package Recursion;

public class lastOccurence {
  public static int isLast(int arr[], int key, int i){
    if(i < 0) return -1;
    if(arr[i]==key){
    return i;
    }
    return isLast(arr, key, i-1);
  }
  public static void main(String[] args) {
    int arr[] = {3,4,5,6,7,81,3,4,6};
   
    System.out.println(isLast(arr,5,arr.length-1));
  }
}


