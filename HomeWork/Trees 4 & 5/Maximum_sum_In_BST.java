package Java.Problem-Solving.HomeWork.Trees 4 & 5;

public class Maximum_sum_In_BST {
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        check(root);
        return maxSum;
    }

    private int[] isValidBST(TreeNode node) {
        if (node == null) {
            return new int[]{1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        int[] left = isValidBST(node.left);
        int[] right = isValidBST(node.right);

        if (left[0] == 1 && right[0] == 1 && node.val > left[3] && node.val < right[2]) {
            int sum = node.val + left[1] + right[1];
            maxSum = Math.max(maxSum, sum);
            int minVal = Math.min(node.val, left[2]);
            int maxVal = Math.max(node.val, right[3]);
            return new int[]{1, sum, minVal, maxVal};
        }

        return new int[]{0, 0, 0, 0}; 
    }
    private void check(TreeNode root) {
        isValidBST(root);
    }
}
