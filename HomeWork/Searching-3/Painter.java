
    import java.util.List;

    public class Painter {
    public static void main(String[] args) {
        List<Integer> boards = List.of(1, 2, 3, 4, 5);
        int k = 3;

        int result = findLargestMinDistance(boards, k);
        System.out.println(result);
    }

    public static int findLargestMinDistance(List<Integer> boards, int k) {
        int low = 0;
        int high = (int) 1e8;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPoss(mid, boards, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isPoss(int mid, List<Integer> boards, int k) {
        int c = 1;
        int boardSum = 0;

        for (int board : boards) {
            if (board > mid) {
                return false;
            }
            if (boardSum + board > mid) {
                c++;
                if (c > k) {
                    return false;
                }
                boardSum = board;
            } else {
                boardSum += board;
            }
        }
        return true;
    }
}


//using binary search. We start with a low value of 0 and a high value of 10^8 (since the maximum height of a board is given as 10^8). We iterate through the binary search process, checking if it's possible to paint all the boards with the given minimum distance. If it is, we update the answer and move towards lower values by updating the high pointer. Otherwise, we move towards higher values by updating the low pointer. We repeat this until the low pointer is less than or equal to the high pointer.
