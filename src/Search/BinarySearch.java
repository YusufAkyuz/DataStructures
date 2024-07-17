package Search;

public class BinarySearch {
    public static boolean binarySearch(int []data, int target, int low, int high) {
        if (low > high)
            return false;
        else {
            int mind = (low+high) / 2;
            if (target == data[mind]) {
                return true;
            }else if (target < data[mind]) {
                return binarySearch(data, target, low, mind-1);
            }else
                return binarySearch(data, target, mind+1, high);
        }
    }

    public static void main(String[] args) {
        int []arr = new int[]{1,2,3,4,5};
        System.out.println(binarySearch(arr, 3, 1,5));
    }
}
