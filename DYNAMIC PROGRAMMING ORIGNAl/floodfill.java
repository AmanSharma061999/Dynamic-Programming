import java.util.*;
public class floodfill 
{
    public static void main(String args[])
    {
        int grid[][]=new int[3][3];
        for(int row[]:grid)
        Arrays.fill(row,0);

        grid[0][0]=1;
        grid[0][1]=1;
        grid[0][2]=1;
        grid[1][0]=1;
        grid[1][1]=1;
        grid[2][0]=1;
        grid[2][2]=1;

        floodfill(grid,1,1);

    }
    static class Pair
    {
        int first;
        int second;
        Pair(int first, int second)
        {
            this.first=first;
            this.second=second;
        }
    }

    static void floodfill(int grid[][],int srow,int scol)
    {
        int color[][]=new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                color[i][j]=grid[i][j];
            }
        }

        Queue<Pair> q= new LinkedList<Pair>();
        q.add(new Pair(srow,scol));

        /*for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                f
            }
        }*/

        color[srow][scol]=2;

        while(!q.isEmpty())
        {
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();

            int delrow[]= {-1,0,1,0};
            int delcol[]={0,1,0,-1};

            for(int i=0;i<4;i++)
            {
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];

                if(nrow>=0 && nrow<3 && ncol>=0 && ncol<3 && grid[nrow][ncol]==1 && (color[nrow][ncol]==0 || color[nrow][ncol]==1))
                {
                    q.add(new Pair(nrow,ncol));
                    color[nrow][ncol]=2;
                }
            }

        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(color[i][j]);
            }
            System.out.println();
        }

    }
    
}
