package Arrays;

public class Swap {
    static void  swap(int a, int b){
        System.out.println("Original Value before swap");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        a = a+b;
        b= a-b;
        a =a-b;
        System.out.println("Original Value after swap");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
    public static void main(String[] args) {
        int a  = 3;
        int b = 9;
        int[]  arr = {1, 3, 4, 2, 5};
        swap(a,b);
    }
    
}
