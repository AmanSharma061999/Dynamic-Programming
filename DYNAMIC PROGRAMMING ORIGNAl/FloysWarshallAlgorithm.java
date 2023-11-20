public class FloysWarshallAlgorithm 
{
    public static void main(String[] args) 
    {
        int V = 4;
        int[][] matrix = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                matrix[i][j] = -1;
            }
        }

        matrix[0][1] = 2;
        matrix[1][0] = 1;
        matrix[1][2] = 3;
        matrix[3][0] = 3;
        matrix[3][1] = 5;
        matrix[3][2] = 4;

        int result[][]=new int[V][V];
        FloysWarshallAlgorithm obj= new FloysWarshallAlgorithm();
        result=obj.matfilldist(matrix,V);
        
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int[][] matfilldist(int mat[][],int V)
    {
        int n=V;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]== -1)
                mat[i][j]=(int)(1e9);

                if(i==j)
                mat[i][j]=0;
            }
        }

        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j]=Math.min(mat[i][j],mat[i][via]+mat[via][j]);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==(int)(1e9))
                mat[i][j]=-1;
            }
        }
        return mat;
    }
}
