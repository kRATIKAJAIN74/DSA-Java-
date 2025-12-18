package Recursion;

public class tilingProblem {
  public static int Tiling(int n){
    //base
    if(n == 0 || n == 1){
      return 1;
    }
 // vertical
 int fnm1 = Tiling(n-1);
 //horizontal
 int fnm2 = Tiling(n-2);

 int total = fnm1 + fnm2;
 return total;
  }
  public static void main(String[] args) {
    System.out.print(Tiling(5));
  }
}
