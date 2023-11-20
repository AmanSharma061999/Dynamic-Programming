import java.util.*;
public class CycleDetection
{
    private static int V;
    private static ArrayList<ArrayList<Integer>> adj= new ArrayList<ArrayList<Integer>>();

    CycleDetection(int v)
    {
        V=v;
        for(int i=0;i<v;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
    }
    static void addEdge(int source, int destination)
    {
        adj.get(source).add(destination);
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
    public static void main(String args[])
    {
        int v=7;
        CycleDetection obj= new CycleDetection(v);
        obj.addEdge(1,2);
        obj.addEdge(2,3);
        obj.addEdge(3,4);
        obj.addEdge(1,5);
        obj.addEdge(5,6);
        

        boolean check = isCycle();

        if(check==true)
        System.out.println("Cycle Detected");
        else
        System.out.println("Cycle Not Detected");
    }
    static boolean isCycle()
    {
        int vis[]=new int[V];
        Arrays.fill(vis,-1);

        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                if(CheckCycleUtil(i,vis)==true)
                return true;
            }
        }
        return false;
    }
    static boolean CheckCycleUtil(int i,int vis[])
    {
        Queue<Pair> q= new LinkedList<Pair>();
        q.add(new Pair(i,-1));

        vis[i]=1;

        while(!q.isEmpty())
        {
            int curr=q.peek().first;
            int par=q.peek().second;
            q.remove();

            for(int it:adj.get(curr))
            {
                if(vis[it]==0)
                {
                    q.add(new Pair(it,curr));
                    vis[it]=1;
                }
                else if(par!=it)
                {
                    return true;
                }
            }
        }
        return false;

    }
}