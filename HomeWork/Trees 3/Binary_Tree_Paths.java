import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Binary_Tree_Paths {
    public List<String> binaryTreePaths(TreeNode root) {
        
        ArrayList<String> bl = new ArrayList<>(); 
        if(root!=null)
        
           help(root , "" , bl);
            return bl;
        
      

    }

    public void help(TreeNode r , String path , List<String> ans)
    {         
        if(r==null)
        return;
        if(r.left==null && r.right==null)
        {
            ans.add(path +r.val);
            return;
        
        }
        help(r.left , path+r.val +"->" , ans);
        help(r.right , path+r.val +"->" , ans);                        
    
    }
}
