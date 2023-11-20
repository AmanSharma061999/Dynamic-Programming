import java.util.*;
public class prims
 {
    static class Node implements Comparator<Node>
    {
        int val;
        int weight;

        Node(int val,int weight)
        {
            this.val=val;
            this.weight=weight;
        }

        Node()
        {}

        int getVal()
        {
            return val;
        }

        int getWeight()
        {
            return weight;
        }

        public int compare(Node n1, Node n2)
        {
            if(n1.weight<n2.weight)
            return -1;
            if(n1.weight>n2.weight)
            return 1;
            return 0;
        }
    }

    private static int V;
    private static ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();

    prims(int v)
    {
        V=v;
        for(int i=0;i<v;i++)
        adj.add(new ArrayList<Node>());
    }

    static void addEdge(int source, int destination, int weight)
    {
        adj.get(source).add(new Node(destination,weight));
    }

    static void prims()
    {
        int vis[]=new int[V];
        int dist[]=new int[V];
        int parent[]=new int[V];

        for(int i=0;i<V;i++)
        dist[i]=10000;

        PriorityQueue<Node> pq = new PriorityQueue<Node>(V,new Node()) ;
        pq.add(new Node(0,0));
        dist[0]=0;
        parent[0]=-1;

        while(!pq.isEmpty())
        {
            int curr=pq.poll().getVal();
            vis[curr]=1;

            for(Node it: adj.get(curr))
            {
                if(vis[it.getVal()]==0 && it.getWeight()<dist[it.getVal()])
                {
                    parent[it.getVal()]=-1;
                    dist[it.getVal()]=it.getWeight();
                    pq.add(new Node(it.getVal(),dist[it.getVal()]));
                }
            }
        }

    }


}
