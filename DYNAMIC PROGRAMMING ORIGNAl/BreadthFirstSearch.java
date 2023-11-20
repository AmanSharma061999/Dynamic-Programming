import java.util.*;
public class BreadthFirstSearch
{
    private static ArrayList<ArrayList<Integer>>adj= new ArrayList<ArrayList<Integer>>();
    private static int V;

    BreadthFirstSearch(int v)
    {
        V=v;
        for(int i=0;i<V;i++)
        adj.add(new ArrayList<Integer>());
    }

    static void addEdge(int source,int destination)
    {
        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }

    static void bfs()
    {
        int vis[]=new int[V+2];
        Queue<Integer>q=new ArrayDeque<Integer>();

        vis[0]=1;
        q.add(0);

        while(!q.isEmpty())
        {
            int curr=q.poll();
            for(Integer it:adj.get(curr))
            {
                if(vis[it]==0)
                {
                    System.out.print(it);
                    q.add(it);
                    vis[curr]=1;
                }
            }
        }
    }
    public static void main(String args[])
    {
        int n=8;
        BreadthFirstSearch obj= new BreadthFirstSearch(6);
        obj.addEdge(0,1);
        obj.addEdge(0,2);
        obj.addEdge(0,3);
        obj.addEdge(2,4);
        //obj.addEdge(3,5);
        /*obj.addEdge(1,5);
        obj.addEdge();
        obj.addEdge();*/

        bfs();

    }

}
