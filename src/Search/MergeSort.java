package Search;

public class MergeSort {
    public int [] merge(int [] arr1, int [] arr2, int n, int m) {
        int [] result = new int [n+m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
            }else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < n) {
            result[k] = arr1[i];
            i++;
            k++;
        }
        while (j < m) {
            result[k] = arr2[j];
            j++;
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr1[] = {1,2,8};
        int arr2[] = {5,6,7};
        MergeSort mergeSort = new MergeSort();
        int [] result = mergeSort.merge(arr1, arr2, 3,3);
        for (int element : result) {
            System.out.print(element + " ");
        }
    }

}
