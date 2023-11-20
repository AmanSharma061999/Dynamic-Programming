import java.util.*;
public class bipartite 
{
    public static void main(String args[])
    {
        int v=7;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<v;i++)
        adj.add(new ArrayList<Integer>());

        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(1).add(4);
        adj.get(4).add(5);
        adj.get(3).add(6);
        adj.get(6).add(5);

        if(bipartite(adj,v)==true)
        System.out.println("its a bipartite Graph");
        else 
        System.out.println("its not a bipartite graph");
    }
    static boolean bipartite(ArrayList<ArrayList<Integer>> adj, int v)
    {
        int color[]=new int[v];
        Arrays.fill(color,-1);

        for(int i=0;i<v;i++)
        {
            if(color[i]==-1)
            {
                if(bipartiteutil(i,adj,v,color)==false)
                return false;
            }
        }
        return true;
    }
    static boolean bipartiteutil(int start, ArrayList<ArrayList<Integer>> adj,int v, int color[])
    {
        Queue<Integer> q= new LinkedList<Integer>();
        q.add(start);
        color[start]=0;

        while(!q.isEmpty())
        {
            int curr=q.peek();
            q.remove();

            for(int it : adj.get(curr))
            {
                if(color[it]==-1)
                {
                    q.add(it);
                    color[it]=1-color[curr];
                }
                else if(color[it]==color[curr])
                return false;
            }
        }
        return true;
    }
}
