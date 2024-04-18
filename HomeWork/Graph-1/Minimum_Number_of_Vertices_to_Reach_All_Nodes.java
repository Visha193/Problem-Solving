import java.util.ArrayList;
import java.util.List;

class Minimum_Number_of_Vertices_to_Reach_All_Nodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) { //Function to find smallest set of vertices

        int[] indegree=new int[n];//Array to store indegree of nodes
        for(List<Integer> e:edges)//Iterating over edges
        {
            indegree[e.get(1)]++;//Incrementing indegree of node
        }
        List<Integer> ans=new ArrayList<>();//List to store answer
        for(int i=0;i<n;i++)
         if(indegree[i]==0)
          ans.add(i);
        return ans;    
    } 
}
