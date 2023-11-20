//BellmanFord Lgorithm only works with DIRECTED graph.
import java.util.*;
public class BellmanFordAlgorithm 
{
    public static void main(String[] args) 
    {
        int V = 6;
        int S = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
        };



        int[] dist = BellmanFordAlgorithm.bellman_ford(V, edges, S);
        for(int i=0;i<V;i++)
        System.out.print(dist[i]+ " ");
        System.out.println();
    }
    static int[] bellman_ford(int V,ArrayList<ArrayList<Integer>> adj,int s)
    {
        int dist[]=new int[V];
        for(int i=0;i<V;i++)
        dist[i]=10000;

        dist[s]=0;

        for(int i=0;i<V;i++)
        {
            for(ArrayList<Integer> it : adj)
            {
                int u=it.get(0);
                int v=it.get(1);
                int wt=it.get(2);
                if(dist[u]!=10000 && dist[u]+wt<dist[v])
                dist[v]=wt+dist[u];
            }
        }
        for(ArrayList<Integer> it : adj)
        {
            int u=it.get(0);
            int v=it.get(1);
            int wt=it.get(2);
            if(dist[u]!=10000 && dist[u]+wt<dist[v])
            {
                int temp[]=new int[1];
                temp[0]=-1;
                return temp;
            }
        }
        return dist;
    }
}
