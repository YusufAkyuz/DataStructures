package Search;

public class SelectionSort {
    public void selectionSort(int [] data) {
        for (int i = 0; i < data.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }

        for (int element : data) {
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args) {
        int [] data = new int[] {4,6,2,4,1};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(data);
    }
}
