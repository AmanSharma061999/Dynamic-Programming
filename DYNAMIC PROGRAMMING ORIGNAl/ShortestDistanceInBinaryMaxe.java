import java.util.*;
public class ShortestDistanceInBinaryMaxe 
{
    public static void main(String[] args) {
        int[] source={0,1};
        int[] destination={2,2};
        
        int[][] grid={{1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}};

            ShortestDistanceInBinaryMaxe obj= new ShortestDistanceInBinaryMaxe();
            int ans=obj.findShortestPath(grid,source,destination);
            if(ans==10000)
            System.out.print("No Such Path Exist");
            else
            System.out.println("Shortest Path is "+ans);
    }
    static class Pair 
    {
        int row;
        int col;
        int dist;
        Pair(int dist, int row, int col)
        {
            this.dist=dist;
            this.row=row;
            this.col=col;
        }
    }

    static int findShortestPath(int grid[][],int source[],int destination[]){
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> pq= new LinkedList<Pair>();
        pq.add(new Pair(0,source[0],source[1]));

        int dist[][]=new int[n][m];
        for(int row[]:dist)
        Arrays.fill(row,10000);

        dist[source[0]][source[1]]=0;

        while(!pq.isEmpty()){
            Pair curr=pq.peek();
            pq.remove();
            int row=curr.row;
            int col=curr.col;
            int distValue=curr.dist;

            int delrow[]={-1,0,1,0};
            int delcol[]={0,-1,0,1};

            for(int var=0;var<4;var++)
            {
                int nrow=row+delrow[var];
                int ncol=col+delcol[var];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && (distValue+1<dist[nrow][ncol]) && grid[nrow][ncol]==1)
                {
                    dist[nrow][ncol]=1+distValue;
                    if(nrow==destination[0] && ncol==destination[1])
                    return distValue+1;
                    pq.add(new Pair(distValue+1,nrow,ncol));
                }
            }
        }
        return -1;
    }
    
}
