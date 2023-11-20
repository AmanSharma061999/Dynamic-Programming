import java.util.*;
public class cycleinDirectedGraph 
{
    public static void main (String args[])
    {
        int v=13;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<v;i++)
        adj.add(new ArrayList<Integer>());

        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(3).add(7);
        adj.get(7).add(5);
        adj.get(8).add(2);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        if(checkCycle(v,adj)==true)
        {
            System.out.println("Its a cycle");
        }
        else
        System.out.println("its not a Cycle");
    }
    static boolean checkCycle(int v, ArrayList<ArrayList<Integer>> adj)
    {
        int vis[] = new int [v];
        Arrays.fill(vis,0);

        int pathvis[]=new int [v];
        Arrays.fill(pathvis,-1);

        for(int i=0;i<v;i++)
        {
            if(vis[i]==0)
            {
                if(checkCycleUtil(i,adj,v,vis,pathvis)==true)
                {
                    return true;
                }
            }
        }
        return false;
    }
    static boolean checkCycleUtil(int curr, ArrayList<ArrayList<Integer>> adj, int v, int vis[],int pathvis[])
    {
        vis[curr]=1;
        pathvis[curr]=1;

        for(int it:adj.get(curr))
        {
            if(vis[it]==0)
            {
                if(checkCycleUtil(it, adj, v, vis, pathvis)==true)
                return true;
            }
            else if(pathvis[it]== 1)
            {
                return true;
            }
        }
        pathvis[curr]=0;
        return false;
    }
    
}
