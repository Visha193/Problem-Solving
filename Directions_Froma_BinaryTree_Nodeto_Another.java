import java.util.*;
import javax.swing.tree.TreeNode;

public class Directions_Froma_BinaryTree_Nodeto_Another{
    public String getDirections(TreeNode root, int starts, int dest) {
        StringBuilder start = new StringBuilder();
        StringBuilder des = new StringBuilder();

        find(root,starts,start);
        find(root,dest,des);

        start.reverse();
        des.reverse();

        while(start.length()>0 && des.length()>0 && start.charAt(0) == des.charAt(0))
        {
            start.deleteCharAt(0);
            des.deleteCharAt(0);
        }
        return "U".repeat(start.length()) + des.toString();
    }
    private boolean find(TreeNode root, int val, StringBuilder sb)
    {
        if(root.val == val)
        return true;
        if(root.left != null && find(root.left,val,sb))
        {
            sb.append("L");
            return true;
        }
        if(root.right != null && find(root.right,val,sb))
        {
            sb.append("R");
            return true;
        }
        return false;
    }
}
