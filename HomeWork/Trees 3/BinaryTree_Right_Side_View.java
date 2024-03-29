import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTree_Right_Side_View {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
              Map<Integer,Integer> map = new HashMap<>();
            List<Integer> al = new ArrayList<>();
            help(root , map , 0);
          for(Map.Entry<Integer,Integer> m : map.entrySet())
          {
            al.add(m.getValue());
          }
          return al;
        }
    
    
         static void help(TreeNode  r, Map<Integer,Integer> map , int cl)
         {
             if(r==null)
             {
                 return;
             }
             
                 map.put(cl, r.val);
               
             
              help(r.left , map , cl+1);
              help(r.right , map, cl+1);
         }
    }
}
