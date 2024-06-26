import java.util.ArrayList;
class Pair{
    int hd;
    Node node;
    
    Pair( Node node, int hd) {
        this.hd = hd;
        this.node = node;
    }
}
public class Top_View_BinaryTree {

    
        static ArrayList<Integer> topView(Node root)
        {
           ArrayList<Integer> ans = new ArrayList<>();
           if(root == null){
               return ans;
           }
           Map<Integer, Integer> mpp = new TreeMap<>();
           Queue<Pair> q = new LinkedList<Pair>();
           
           q.add(new Pair ( root, 0));
           
           while (!q.isEmpty()){
               Pair it = q.remove();
               int hd = it.hd;
               Node temp = it.node;
               
               if(mpp.get(hd) == null){
                   mpp.put(hd, temp.data);
               }
               if(temp.left != null){
                   q.add(new Pair (temp.left, hd-1));
               }
               if(temp.right != null){
                   q.add(new Pair (temp.right, hd+1));
               }
           }
           for (Map.Entry<Integer, Integer> entry: mpp.entrySet()){
               ans.add(entry.getValue());
           }
           return ans;
            
        }
    }
    
    
}
