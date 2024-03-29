import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Path_To_Given_Node {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> al = new ArrayList<>();
    
            if(A==null)
            {
                return al;
            }
            
            if(help(A,B , al))
            return al;
            return al;
            
        }
        
        boolean help(TreeNode r, int key, ArrayList<Integer> al)
        {
            if(r==null)
            {
                return false;
            }
            
            al.add(r.val);
            
            if(r.val==key)
            {
                return true;
            }
            
            if(help(r.left , key ,al) || help(r.right ,key ,al))
            return true;
            
            al.remove(al.size() -1);
            return false;
        }
       
    }

