package HashMap ;
import java.util.HashMap;
import java.util.Map;
public class Hashing {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();

        //Insertion(Key, value)
        hm.put("India", 120);
        hm.put("UK", 140);
        System.out.println(hm);
    



















        //Search(True, false)
        // if(hm.containsKey("UK")){
        //     System.out.println("Key is present in the map");
        // }else{
        //     System.out.println("Key is not present in the HashMap");
        // }

        // System.out.println(hm.get("India")); Value
        // System.out.println(hm.get("China"));  Null

        // int arr[] = {10, 15, 20};
        // for(int val : arr){
        //     System.out.println(val + " ");
        // }
        // System.out.println();

        // for(Map.Entry<String, Integer> e : hm.entrySet()){
        //   System.out.println(e.getKey());
        //   System.out.println(e.getValue());  
        // }

        hm.remove("UK");
        System.out.println(hm);
    }
}

