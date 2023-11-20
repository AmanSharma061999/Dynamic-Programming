import java.util.*;
public class PrintShortestPathDijkstras 
{
    public static void main(String[] args) 
    {
        int V = 5, E = 6;

        int[][] edges = {{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}};

        PrintShortestPathDijkstras obj = new PrintShortestPathDijkstras();
        ArrayList<Integer> res= new ArrayList<Integer>();
        res=obj.findPath(edges,V,E);
        if(res.size()==1)
        System.out.println("No Such Path Exist");
        else
        System.out.println(res);
    }
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
    static ArrayList<Integer> findPath(int edges[][],int v, int e)
    {
        ArrayList<ArrayList<Node>> adj= new ArrayList<ArrayList<Node>>();
        for(int i=0;i<=v;i++)
        adj.add(new ArrayList<Node>());
        
        for(int i=0;i<e;i++)
        {
            adj.get(edges[i][0]).add(new Node(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Node(edges[i][0],edges[i][2]));
        }

        PriorityQueue<Node> pq= new PriorityQueue<Node>(v,new Node());
        pq.add(new Node(1,0));

        int parent[]=new int[v+1];
        int dist[]=new int[v+1];


        for(int i=1;i<=v;i++)
        {
            parent[i]=i;
            dist[i]=100000;
        }

        dist[1]=0;

        while(!pq.isEmpty())
        {
            Node curr=pq.poll();

            for(Node it: adj.get(curr.getVal()))
            {
                if(dist[curr.getVal()]+it.getWeight()<dist[it.getVal()])
                {
                    parent[it.getVal()]=curr.getVal();
                    dist[it.getVal()]=dist[curr.getVal()]+it.getWeight();
                    pq.add(new Node(it.getVal(),dist[it.getVal()]));
                }
            }
        }

        ArrayList<Integer> res= new ArrayList<Integer>();
        if(dist[v]==100000)
        {
            res.add(-1);
            return res;
        }

        int var=v;

        while(parent[var] != var)
        {
            res.add(var);
            var=parent[var];
        }
        res.add(1);

        Collections.reverse(res);
        return res;


    }
    
}
