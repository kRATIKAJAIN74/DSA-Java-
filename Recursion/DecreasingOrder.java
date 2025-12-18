package Recursion;

public class DecreasingOrder {
  public static void printOrder(int n){
    if(n==1){
      System.out.print(n);
      return;
    }
    System.out.print(n+ " ");
    printOrder(n-1);
  }
  public static void main(String[] args) {
    int n=10;
    printOrder(n);
  }
}
