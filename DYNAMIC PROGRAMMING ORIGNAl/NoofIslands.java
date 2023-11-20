import java.util.*;
public class NoofIslands 
{
    public static void main(String args[])
    {
        int mat[][]= new int[5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                mat[i][j]=0;
            }
        }
        mat[0][1]=1;
        mat[0][2]=1;
        mat[1][2]=1;
        mat[2][2]=1;
        mat[2][3]=1;
        mat[4][0]=1;
        mat[4][1]=1;
        //mat[3][4]=1;
        mat[4][3]=1;
        mat[4][4]=1;

        System.out.println(noofcomp(mat));
    }
    static int noofcomp(int mat[][])
    {
        int vis[][]=new int[5][5];
        for(int row[] : vis)
        Arrays.fill(row,0);
        int count=0;

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(vis[i][j]==0 && mat[i][j]==1)
                {
                    ++count;
                    bfs(i,j,vis,mat);
                }
            }
        }
        return count;
    }
    static void bfs(int i,int j,int vis[][], int mat[][])
    {
        vis[i][j]=1;

        Queue<Pair> q= new LinkedList<Pair>();
        q.add(new Pair(i,j));

        while(!q.isEmpty())
        {
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();

            for(int del=-1;del<=1;del++){
                for(int led=-1;led<=1;led++){
                    int nrow=row+del;
                    int ncol=col+led;
                    if(nrow>=0 && nrow<5 && ncol>=0 && ncol<5 && vis[nrow][ncol] == 0 && mat[nrow][ncol]==1)
                    {
                        q.add(new Pair(nrow,ncol));
                        vis[nrow][ncol]=1;

                    }
                }
            }
        }
    }
    static class Pair
    {
        int first;
        int second;
        Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
}
