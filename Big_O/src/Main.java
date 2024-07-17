
public class Main {

    public static boolean find(int arr[], int value) {      //O(n) mesela bu
        for (int element : arr) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    public static int [] selectioSort(int [] arr) {     //  O(n^2) mesela bu
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{4,2,1};
        System.out.println(find(arr,2));

        arr = selectioSort(arr);
        for (int element : arr) {
            System.out.print(String.valueOf(element) + ' ');
        }
    }
}