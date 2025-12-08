package Arrays;
import java.util.*;
public class ReverseArray {
  public static void reverse(int arr[]){
    int i=0;
    int j=arr.length-1;
    while(i<j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
  }
  public static void main(String[] args) {
    int arr[] = {2,5,4,7,8};
    reverse(arr);
    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i]+ " ");
    }
    System.out.println();
  }
   
}
