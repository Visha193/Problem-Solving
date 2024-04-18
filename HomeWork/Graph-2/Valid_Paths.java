import java.util.ArrayList;

public class Valid_Paths {
    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) { // Function to find if there is a path

        int[][] vis=new int[A+1][B+1];
        return (dfs(0,0,vis,D,E,F,A,B)==true)?"YES":"NO"; //Return YES if path exists else NO
    }
    public boolean dfs(int x,int y,int[][] vis,int r,ArrayList<Integer> X,ArrayList<Integer> Y,int A,int B) //Function to perform DFS
    {
        if(x<0 || y<0 || x>=vis.length || y>=vis[0].length) //If x or y is out of bounds
         return false;
        if(vis[x][y]==1 || insideCircle(x,y,X,Y,r)) //If already visited or inside circle
         return false;
        if(x==A && y==B)//If reached destination
         return true;
        
        vis[x][y]=1;
        for(int i=-1;i<=1;i++)//Iterating over all possible directions
        {
            for(int j=-1;j<=1;j++)
            {
                int nr=x+i,nc=y+j;
                if(dfs(nr,nc,vis,r,X,Y,A,B)) //If path exists
                 return true;
            }
        }
        return false;
    }
    public boolean insideCircle(int x,int y,ArrayList<Integer> X,ArrayList<Integer> Y,int r) //Function to check if point is inside circle
    {
        for(int i=0;i<X.size();i++) //Iterating over all circles
        {
            int cx=X.get(i),cy=Y.get(i);
            int dis=(int)Math.pow(cx-x,2)+(int)Math.pow(cy-y,2); //Calculating distance
            if(dis<=r*r)
             return true;
        }
        return false;
    }
}

