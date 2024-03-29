import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Odd_Even_Level {
    int sumofodd=0;
    int sumofeven=0;
    
    void findLevelDiff(Node root,int level)
    {
        if(root==null)
          return;
          
        if(level%2==0)
           sumofeven+=root.data;
        else
           sumofodd+=root.data;
           
        findLevelDiff(root.left,level+1);   
        findLevelDiff(root.right,level+1);
    }
    
    int getLevelDiff(Node root)
    {
        findLevelDiff(root,1);
        return sumofodd-sumofeven;
    }
}

