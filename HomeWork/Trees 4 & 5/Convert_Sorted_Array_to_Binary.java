package Java.Problem-Solving.HomeWork.Trees 4 & 5;
import javax.swing.tree.TreeNode;

public class Convert_Sorted_Array_to_Binary {
    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums, 0, nums.length-1);
    }
    TreeNode help(int nums [] , int low , int high)
    {
        if(low>high) return null;;
        int mid= (low+high)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left=help(nums , low , mid-1);
        node.right=help(nums , mid+1 , high);

        return node;
    }
}
