import java.util.*;
public class Counting {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            int N = scanner.nextInt();
            int Q = scanner.nextInt();
    
            int[] heights = new int[N];
            for (int i = 0; i < N; i++) {
                heights[i] = scanner.nextInt();
            }
    
            int[] queries = new int[Q];
            for (int i = 0; i < Q; i++) {
                queries[i] = scanner.nextInt();
            }
    
            int[] results = countStudents(heights, queries);
    
            for (int res : results) {
                System.out.println(res);
            }
        }
    
        public static int[] countStudents(int[] heights, int[] queries) {
            Arrays.sort(heights);
            int[] results = new int[queries.length];
    
            for (int i = 0; i < queries.length; i++) {
                int q = queries[i];
                int left = 0, right = heights.length - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (heights[mid] >= q) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                results[i] = heights.length - left;
        }
         return results;
    }
}
    