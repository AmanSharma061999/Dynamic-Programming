import java.util.*;
public class DistanceofNearestCell 
{
    static class Pair
    {
        int row;
        int col;
        int distval;
        Pair(int row,int col,int distval)
        {
            this.row=row;
            this.col=col;
            this.distval=distval;
        }
    }
    public static void main(String args[])
    {
        int mat[][]=new int[3][3];
        for(int row[]:mat)
        Arrays.fill(row,0);

        int vis[][]=new int[3][3];
        for(int row[]:vis)
        Arrays.fill(row,0);

        int dist[][]=new int[3][3];
        for(int row[]:dist)
        Arrays.fill(row,0);

        mat[1][1]=1;
        mat[2][0]=1;
        mat[2][2]=1;

        vis[1][1]=1;
        vis[2][0]=1;
        vis[2][2]=1;

        Queue<Pair> q= new LinkedList<Pair>();
        q.add(new Pair(1,1,0));
        q.add(new Pair(2,0,0));
        q.add(new Pair(2,2,0));

        while(!q.isEmpty())
        {
            int row=q.peek().row;
            int col=q.peek().col;
            int val=q.peek().distval;
            q.remove();

            int delrow[]={-1,0,1,0};
            int delcol[]={0,1,-1,0};

            for(int i=0;i<4;i++)
            {
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];

                if(nrow>=0 && nrow<3 && ncol>=0 && ncol<3 && 
                   mat[nrow][ncol]==0 && vis[nrow][ncol]==0)
                   {
                    dist[nrow][ncol]=val+1;
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,val+1));
                   }
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(dist[i][j]);
            }
            System.out.println();
        }
    }
}
