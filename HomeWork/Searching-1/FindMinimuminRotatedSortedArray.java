

public class FindMinimuminRotatedSortedArray {
    class Solution {
        public int findMin(int[] n) {
          int length = 0;
          int rotatedArray = n.length - 1;
      
          while (length < rotatedArray) {
            final int m = (length + rotatedArray) / 2;
            if (n[m] < n[rotatedArray])
              rotatedArray = m;
            else
              length = m + 1;
          }
      
          return n[length];
        }
      }
}
