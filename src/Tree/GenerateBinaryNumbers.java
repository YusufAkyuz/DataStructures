package Tree;

import java.util.Queue;

import java.util.LinkedList;

public class GenerateBinaryNumbers {
    public static String[] generateBinaryNumber(int n) {
        String[] result = new String[n];
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        for (int i = 0; i < n; i++) {
            result[i] = q.poll();
            String n1 = result[i] + "0";
            String n2 = result[i] + "1";
            q.offer(n1);
            q.offer(n2);
        }
        return result;
    }
    public static void display(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        String[] binaryValues = generateBinaryNumber(5);
        display(binaryValues);
    }
}
