import java.util.*;
public class rottenOranges 
{
    public static void main(String Args[])
    {
        int mat[][]=new int[4][4];
        for(int row[]:mat)
        Arrays.fill(row,0);

        mat[0][1]=1;
        mat[0][2]=1;
        mat[1][1]=1;
        mat[1][2]=1;
        mat[2][0]=1;
        mat[2][1]=1;
        mat[3][2]=1;
        mat[3][3]=1;
        mat[1][3]=2;
        mat[3][0]=2;

        System.out.println("Time Taken to rot Oranges are "+rottenOrange(mat));
    }
    static class Pair
    {
        int row;
        int col;
        int time;
        Pair(int row,int col,int time)
        {
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }

    static int rottenOrange(int mat[][])
    {
        int vis[][]=new int[4][4];
        for(int row[]:vis)
        Arrays.fill(row,0);

        Queue<Pair> q = new LinkedList<Pair>();

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(mat[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }

        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        int mintime=0;

        while(!q.isEmpty())
        {
            int row=q.peek().row;
            int col=q.peek().col;
            int tim=q.peek().time;
            q.remove();

            mintime=Math.max(mintime,tim);

            for(int i=0;i<4;i++)
            {
                int nrow=row+drow[i];
                int ncol=col+dcol[i];

                if(nrow>=0 && nrow<4 && ncol>=0 && ncol<4
                   && vis[nrow][ncol]==0 && mat[nrow][ncol]==1)
                   {
                    q.add(new Pair(nrow,ncol,tim+1));
                    vis[nrow][ncol]=1;
                   }
            }
        }
        return mintime;

    }
}
