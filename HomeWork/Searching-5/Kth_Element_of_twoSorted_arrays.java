import java.util.*;

public class Kth_Element_of_twoSorted_arrays {

    public static int kthelement(int arr1[], int arr2[], int m, int n, int k) {
        int p1 = 0, p2 = 0, count = 0, ans = 0;

        while (p1 < m && p2 < n) {
            if (count == k) break;
            else if (arr1[p1] < arr2[p2]) {
                ans = arr1[p1];
                ++p1;
            } else {
                ans = arr2[p2];
                ++p2;
            }
            ++count;
        }
        if (count != k) {
            if (p1 != m - 1)
                ans = arr1[k - count];
            else
                ans = arr2[k - count];
        }
        return ans;
    }
    public static void main(String args[]) {
        int arr1[] = {4,5,7,6,9};
        int arr2[] = {4,3,7,10};
        int m = arr1.length;
        int n = arr2.length;
        int k = 5;
        System.out.println("The element at the kth position in the final sorted array is "
        + kthelement(arr1, arr2, m, n, k));

    }
}

