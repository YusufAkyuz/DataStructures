package Iterators;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iter {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Yusuf");
        list.add("Ali");
        list.add("Mehmet");

        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        iter.remove();
        for (String element : list) {
            System.out.println(element);
        }

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(3);
        intList.add(5);
        intList.add(7);
        intList.add(11);
        intList.add(9);

        Iterator<Integer> iter1 = intList.iterator();
        while (iter1.hasNext()) {
            int nextInt = iter1.next();
            if (nextInt % 3 == 0) {
                iter1.remove();
            }
        }
        for (int element : intList) {
            System.out.println(element);
        }

        System.out.println("\n************************\n");

        ArrayList<String> names = new ArrayList<>();
        names.add("Yusuf");
        names.add("Yusuf");
        names.add("Yusuf");
        Iterator<String> iter2 = names.iterator();
        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }
    }
}
