package Arrays;

 class ArraysExample {
    void demoArrays(){
    int ages [] = new int[5];
    float weights [] = new float[3];

    ages[0]=34;
    ages[1]=35;
    ages[2]=23;
    // ages[5]=45;
    System.out.println(ages[0]);
    System.out.println(ages[1]);
    System.out.println(ages[2]);
    }
}
public class Main {
    public static void main(String[] args) {
        ArraysExample obj = new ArraysExample();
        obj.demoArrays();
    }
}