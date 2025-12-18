package Recursion;

public class firstOccurence {
  public static int isFirst(int arr[], int key, int i){
    if(i == arr.length) return -1;
    if(arr[i]==key){
    return i;
    }
    return isFirst(arr, key, i+1);
  }
  public static void main(String[] args) {
    int arr[] = {3,4,5,6,7,81,3,4,6};
   
    System.out.println(isFirst(arr,81,0));
  }
}
