class Number_of_Provinces {
    public int findCircleNum(int[][] isConnected) { //Function to find number of provinces
        int start=0,c=0;
        int[] vis=new int[isConnected.length]; //Array to store visited nodes
            for(int i=0;i<isConnected.length;i++) //Iterating over all nodes
            {
              if(vis[i]==0)//If node is not visited
              {
               c++;
               dfs(isConnected,i,vis);//DFS
              } 
            }
            
        return c;
    }
    public void dfs(int[][] c,int ele,int[] vis)
    {
        vis[ele]=1;
        for(int i=0;i<c[0].length;i++)
        {
            if(c[ele][i]==1 && vis[i]==0)
            {
                dfs(c,i,vis);
            }
        }
    }
}
