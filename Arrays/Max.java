package Arrays;

 class MaxValue {
    void MaxOfArray(){
        int arr[] = {2,5,3,7,5,8,6,9,1};
         int ans = 0;
         for(int i=0;i<arr.length;i++){
            if (arr[i]>ans){
                ans = arr[i];
            }
         }
         System.out.println("Max: " + ans);
        }
}
public class Max {
public static void main(String[] args) {
    MaxValue obj = new MaxValue();
    obj.MaxOfArray();
}

}
