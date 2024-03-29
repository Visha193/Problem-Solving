class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

    public class Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        
        help(root);
        return root;
    }

    void help(TreeNode r){
        if(r==null)
        return;
        TreeNode left = r.left;
        TreeNode right = r.right;

        r.left = right;
        r.right=left;

        help(r.left);
        help(r.right);
    }
}

