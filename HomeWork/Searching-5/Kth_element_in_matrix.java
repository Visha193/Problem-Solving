import java.util.PriorityQueue;
import java.util.Collections;

public class Kth_element_in_matrix {
    public static int kthSmallest(int[][]mat,int n,int k)
	{
        //Max-Heap
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(pq.size()==k){
                    if(mat[i][j]<pq.peek()){
                        pq.poll();
                        pq.add(mat[i][j]);
                    }
                }else{
                    pq.add(mat[i][j]);
                }
            }
        }
       return pq.peek();
        
    }
}
