package DP;
public class fibonacci{
  //memoization
  public static int fib(int n,int f[]){
   if(n==0 || n==1){
    return n;
   }
   if(f[n]!=0){//if not 0
    return f[n];
   }
   f[n]= fib(n-1,f) + fib(n-2,f);
   return f[n];
  }
//tabulation
  public static int fibTabulation(int n){
    int dp[] = new int[n+1];
    dp[0] = 1;
    for(int i=1;i<=n;i++){
      if(i==1){
        dp[i] = dp[i-1];
      }
      else {
        dp[i] = dp[i-1] + dp[i-2];
      }
      
    }
    return dp[n];
  }
  public static void main(String[] args) {
    int n=5;
    int f[] = new int[n+1];// 0
    // System.out.println(fib(n,f));
    System.out.println(fibTabulation(n));
  }
}