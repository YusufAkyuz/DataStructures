package Array;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public void printArr(int []arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public void initialArr() {
        int arr[] = new int [5];
        printArr(arr);
        printArr(new int[]{1,2,4,5,6}); //anlık olarak oluşturulacak nesne verileri gönderilmiş oluncaktır
    }
    public void removeEvenElements(int []arr) {
        int numberOfOdd = 0;
        for(int element : arr) {
            if (element % 2 == 1) {
                numberOfOdd++;
            }
        }
        int oddArr [] = new int [numberOfOdd];
        int i = 0;
        for (int element : arr) {
            if (element % 2 == 1){
                oddArr[i] = element;
                i++;
            }
        }
        printArr(oddArr);
    }
    public void reverseElements(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        printArr(arr);
    }
    public void findMinimumValue(int arr[]) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        int minNumber = arr[0];
        for (int element : arr) {
            if (element < minNumber) {
                minNumber = element;
            }
        }
        System.out.println(minNumber);
    }
    public void findSecondMax(int arr[]) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }else if(arr[i] >secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        System.out.println(secondMax);
    }

    public boolean isPalindrome(String str) {
        char arr[] = str.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.initialArr();
        System.out.println();
        main.removeEvenElements(new int []{1,2,4,5});
        System.out.println();
        main.reverseElements(new int []{1,2,3,4,5},0,4);
        System.out.println();
        main.findMinimumValue(new int[]{1,4,6,3,-4});
        main.findSecondMax(new int[]{1,4,6,3,-4});
    }
}