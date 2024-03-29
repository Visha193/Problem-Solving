import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class Bottom_view_BinaryTree {
        class Pair{
            Node n;
            int hd;//horizontal distance
            Pair(Node n,int hd){
                this.n=n;
                this.hd=hd;
            }
        }
        
        public ArrayList <Integer> bottomView(Node root){
            Queue<Pair> q=new ArrayDeque<>();
            q.add(new Pair(root,0));
            HashMap<Integer,Integer> m=new HashMap<>();
            
            int min=0,max=0;
            
            while(!q.isEmpty()){
                int size=q.size();
                while(size>0){
                    Pair curr=q.poll();
                    min=Math.min(min,curr.hd);
                    max=Math.max(max,curr.hd);
                    m.put(curr.hd,curr.n.data);
                    if(curr.n.left!=null){
                        q.add(new Pair(curr.n.left,curr.hd-1));
                    }
                    if(curr.n.right!=null){
                        q.add(new Pair(curr.n.right,curr.hd+1));
                    }
                    size--;
                }
            }
            
            ArrayList<Integer> arr=new ArrayList<>();
            while(min!=max+1){
                arr.add(m.get(min));
                min++;
            }
         
            return arr;
        }
    }
