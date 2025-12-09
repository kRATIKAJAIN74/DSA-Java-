package Arrays;

public class BuyAndSell {
  public static int BuyAndSell( int price[]){
 int BuyPrice = Integer.MAX_VALUE;
 int maxProfit = 0;
 for(int i=0;i<price.length;i++){
  if(BuyPrice<price[i]){
    int profit = price[i] - BuyPrice;
    maxProfit = Math.max(maxProfit, profit);
  } else {
    BuyPrice = price[i];
  }
 }
 return maxProfit;
  }
  public static void main(String[] args) {
    int price[] = {7,1,5,3,6,4};
System.out.println(BuyAndSell(price));;
  }
}
