import java.util.*;
public class TopologicalSort 
{
    public static void main(String args[])
    {
        TopologicalSort sort = new TopologicalSort(6);
        sort.addEdge(2,3);
        sort.addEdge(3,1);
        sort.addEdge(4,0);
        sort.addEdge(5,0);
        sort.addEdge(5,2);

        TopoSort();
        kahnsAlgo();

    }
    private static int V;
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

    TopologicalSort(int v)
    {
        V=v;
        for(int i=0;i<v;i++)
        adj.add(new ArrayList<Integer>());
    }

    static void addEdge(int source, int destination)
    {
        adj.get(source).add(destination);
    }

    static void TopoSort()
    {
        int vis[]= new int[V];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,st,vis);
            }
        }

        while(!st.isEmpty())
        {
            System.out.print(st.pop()+"<>");
        }

    }

    static void dfs(int curr, Stack<Integer> st, int vis[])
    {
        vis[curr]=1;
        for(int it : adj.get(curr))
        {
            if(vis[it]==0)
            {
                dfs(it,st,vis);
            }
        }
        st.push(curr);
    }
    static void kahnsAlgo()
    {
        int indegree[]=new int[V];
        for(int i=0;i<V;i++)
        {
            for(int it: adj.get(i))
            indegree[it]++;
        }

        Queue<Integer> q= new LinkedList<Integer>();
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            q.add(i);
        }

        int i=0;
        int topo[]=new int[V];

        while(!q.isEmpty())
        {
            int curr=q.peek();
            q.remove();

            topo[i++]=curr;

            for(int it : adj.get(curr))
            {
                indegree[it]--;
                if(indegree[it]==0)
                q.add(it);
            }
        }
        System.out.println();
        for(int k=0;k<topo.length;k++)
        System.out.print(topo[k]+"<>");
    }

}
