import java.util.Arrays;

public class MinimumLimitsOfBallInBag {
        public int minimumSize(int[] n, int max) {
          int l = 1;
          int r = Arrays.stream(n).max().getAsInt();
      
          while (l < r) {
            final int m = (l + r) / 2;
            if (numOperations(n, m) <= max)
              r = m;
            else
              l = m + 1;
          }
      
          return l;
        }
      
        private int numOperations(int[] n, int m) {
          int operations = 0;
          for (final int num : n)
            operations += (num - 1) / m;
          return operations;
        }
      }

