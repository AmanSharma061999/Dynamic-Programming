import java.net.SocketImpl;
import java.util.*;
public class EventualSafeState 
{
    private static int V;
    private static ArrayList<ArrayList<Integer>> adj= new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) 
    {
        EventualSafeState obj= new EventualSafeState(12);
        obj.addEdge(0,1);
        obj.addEdge(1,2);
        obj.addEdge(2,3);
        obj.addEdge(2,4);
        obj.addEdge(3,4);
        obj.addEdge(3,5);
        obj.addEdge(4,6);
        obj.addEdge(5,6);
        obj.addEdge(6,7);
        obj.addEdge(8,1);
        obj.addEdge(8,9);
        obj.addEdge(9,10);
        obj.addEdge(10,8);
        obj.addEdge(11,9);
        safestate();
    }
    EventualSafeState(int v)
    {
        V=v;
        for(int i=0;i<V;i++)
        adj.add(new ArrayList<Integer>());
    }
    static void addEdge(int source,int destination)
    {
        adj.get(source).add(destination);
    }

    static void safestate()
    {
        int indegree[]=new int[V];
        ArrayList<ArrayList<Integer>> adjrev = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++)
        {
            adjrev.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<V;i++)
        {
            for(int it : adj.get(i))
            {
                adjrev.get(it).add(i);
                indegree[i]++;
            }
            
        }

        Queue<Integer> q= new LinkedList<Integer>();
        ArrayList<Integer> safe= new ArrayList<Integer>();

        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            q.add(i);
        }

        //System.out.println(1);

        while(!q.isEmpty())
        {
            int curr=q.peek();
            q.remove();
            safe.add(curr);

            for(int it : adjrev.get(curr))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.add(it);
                }
            }
        }
        Collections.sort(safe);
        System.out.println(safe);
    }
}
