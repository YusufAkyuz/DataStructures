package DynamicArray;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<Integer>(5);
        array.add(5);
        array.add(8);
        array.add(101);
        array.remove(101);
        System.out.println(array.toString());
    }
}
