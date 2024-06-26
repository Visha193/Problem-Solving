import java.util.ArrayList;
import java.util.List;

public class Path_Sum_ii {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
      List<List<Integer>> ans = new ArrayList<>();
      dfs(root, sum, new ArrayList<>(), ans);
      return ans;
    }
  
    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ans) {
      if (root == null)
        return;
      if (root.val == sum && root.left == null && root.right == null) {
        path.add(root.val);
        ans.add(new ArrayList<>(path));
        path.remove(path.size() - 1);
        return;
      }
  
      path.add(root.val);
      dfs(root.left, sum - root.val, path, ans);
      dfs(root.right, sum - root.val, path, ans);
      path.remove(path.size() - 1);
    }
  }

