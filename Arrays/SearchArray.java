package Arrays;

class search {
    void searchInArray (){
        int arr[] = {10,5,3,6,2,8,4};
        int x = 10;
        int ans = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
              ans=i;
            }
        }
        System.out.println("Found " + x + " at index " + ans);
    }
}
public class SearchArray {
    public static void main(String[] args) {
        search obj = new search();
        obj.searchInArray();
    }
}
