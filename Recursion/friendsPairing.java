package Recursion;

public class friendsPairing {
  public static int isPairing(int n){
    if(n==1 || n==2){
      return n;
    }
    //choice
    //single
     int fnm1 = isPairing(n-1);
    //pair
    int fnm2 = isPairing(n-2);
    int pairWays = (n-1) * fnm2;

    int total = fnm1 + pairWays;
    return total;
  }
  public static void main(String[] args) {
   System.out.println(isPairing(3));
  }
}
