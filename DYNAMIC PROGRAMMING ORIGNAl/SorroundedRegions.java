import java.util.*;
public class SorroundedRegions 
{
    public static void main(String srgs[])
    {
        char mat[][]=new char [5][5];
        for(char row[]: mat)
        Arrays.fill(row, 'X');

        mat[1][1]='O';
        mat[2][1]='O';
        mat[2][2]='O';
        mat[3][3]='O';
        mat[4][3]='O';

        char ans[][]=new char[5][5];

        ans=fill(mat);

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
    static char[][] fill(char[][] mat)
    {
        int vis[][]=new int[5][5];
        for(int row[]:vis)
        Arrays.fill(row, 0);

        for(int i=0;i<5;i++)
        {
            if(mat[i][0]=='O' && vis[i][0]==0)
            dfs(i,0,mat,vis);
        }
        for(int j=0;j<5;j++)
        {
            if(mat[4][j]=='O' && vis[4][j]==0)
            dfs(4,j,mat,vis);
        }
        for(int i=0;i<5;i++)
        {
            if(mat[i][4]=='O' && vis[i][4]==0)
            dfs(i,0,mat,vis);
        }
        for(int j=0;j<5;j++)
        {
            if(mat[0][j]=='O' && vis[0][j]==0)
            dfs(0,j,mat,vis);
        }

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(vis[i][j]==0 && mat[i][j]=='O')
                mat[i][j]='X';
            }
        }
        return mat;
    }
    static void dfs(int row,int col,char[][] mat,int [][] vis)
    {
        vis[row][col]=1;

        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};

        for(int i=0;i<4;i++)
        {
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];

            if(nrow>=0 && nrow<5 && ncol>=0 && ncol<5 && mat[nrow][ncol]=='O' && vis[nrow][ncol]==0)
            {
                dfs(nrow,ncol,mat,vis);
            }
        }
    }
    
}
