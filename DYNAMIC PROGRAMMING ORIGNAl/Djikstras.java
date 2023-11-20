import java.io.*;
import java.util.*;
public class Djikstras 
{
    private static ArrayList<ArrayList<Node>> adj= new ArrayList<ArrayList<Node>>();
    private static int V;

    Djikstras(int v)
    {
        V=v;
        for(int i=0;i<v;i++)
        adj.add(new ArrayList<Node>());
    }
    public static void addEdge(int source, int destination,int weight)
    {
        adj.get(source).add(new Node(destination,weight));
    }
    public static class Node implements Comparator<Node>
    {
        int val;
        int weight;

        Node()
        {}

        Node(int val,int weight)
        {
            this.val=val;
            this.weight=weight;
        }

        int getVal()
        {
            return val;
        }

        int getWeight()
        {
            return weight;
        }
        @Override
        public int compare(Node n1, Node n2)
        {
            if(n1.weight<n2.weight)
            return -1;
            if(n1.weight>n2.weight)
            return 1;
            return 0;
        }
    }

    public static void djisktras(int src)
    {
        int dist[]=new int[V];
        for(int i=0;i<V;i++)
        dist[i]=10000;

        PriorityQueue<Node> pq= new PriorityQueue<Node>(V, new Node());
        
        //6
        //for(int i=0;i<V;i++)
        pq.add(new Node(src,0));

        dist[src]=0;

        while(!pq.isEmpty())
        {
            Node curr=pq.poll();

            for(Node it:adj.get(curr.getVal()))
            {
                if(dist[curr.getVal()]+it.getWeight()<dist[it.getVal()])
                {
                    dist[it.getVal()]=dist[curr.getVal()]+it.getWeight();
                    pq.add(new Node(it.getVal(),dist[it.getVal()]));
                }
            }
        }
        for(int i=0;i<V;i++)
        System.out.print(dist[i]+">"+" >");
    }
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of vertices and Edges");
        int v = scan.nextInt();
        int e= scan.nextInt();
  
        Djikstras graph = new Djikstras(v);
  
  
        /*graph.addEdge(5,0);
        graph.addEdge(5,2);
        graph.addEdge(4,0);
        graph.addEdge(4,1);
        graph.addEdge(2,3);
        graph.addEdge(3,1);*/
        graph.addEdge(0,1,2);
        graph.addEdge(1,2,4);
        graph.addEdge(0,3,1);
        graph.addEdge(3,2,3);
        graph.addEdge(1,4,5);
        graph.addEdge(2,4,1);
  
  
        djisktras(0);
    }
}
