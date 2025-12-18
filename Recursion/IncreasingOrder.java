package Recursion;

public class IncreasingOrder {
  public static void printOrder(int n){
    if(n == 1){
      System.out.print(n);
      return;
    }
   
    printOrder(n-1);
     System.out.print(n+ " ");
  }
  public static void main(String[] args) {
    int n = 10;
    printOrder(n);
  }
}
