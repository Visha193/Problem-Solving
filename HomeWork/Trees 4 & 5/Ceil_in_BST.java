package Java.Problem-Solving.HomeWork.Trees 4 & 5;
import org.w3c.dom.Node;

public class Ceil_in_BST {
    int currVal=Integer.MAX_VALUE;
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        

        ceil(root , key);
        int x=currVal;
        if(currVal == Integer.MAX_VALUE)
        return -1;
        return x;
        // Code here
    }
    
    void ceil(Node root , int key)
    {
        if(root==null)
        {
            return ;
        }
      
          
        ceil(root.left , key);
          if(root.data >= key && root.data <currVal)
          currVal=root.data;
        //   System.out.println(currVal);
        ceil(root.right , key);
    }
}
