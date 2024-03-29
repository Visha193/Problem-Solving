class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Height_of_binarytree {
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int height = height(root);
        System.out.println("The height of the binary tree is: " + height);
    }
}


