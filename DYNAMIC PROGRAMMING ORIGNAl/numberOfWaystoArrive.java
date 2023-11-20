import java.util.*;
public class numberOfWaystoArrive 
{
    public static void main(String[] args) 
    {
        int n=7;
        int[][]edges={{0,6,7},{0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, 
        {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
        /*List < List < Integer >> roads = new ArrayList < > () {
            {
                add(new ArrayList<Integer>(Arrays.asList(0, 6, 7)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 2)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 3, 3)));
                add(new ArrayList<Integer>(Arrays.asList(6, 3, 3)));
                add(new ArrayList<Integer>(Arrays.asList(3, 5, 1)));
                add(new ArrayList<Integer>(Arrays.asList(6, 5, 1)));
                add(new ArrayList<Integer>(Arrays.asList(2, 5, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 4, 5)));
                add(new ArrayList<Integer>(Arrays.asList(4, 6, 2)));
            }
        };*/
        int ans=findways(edges,n);
        System.out.println("No.of ways to arrive at destination = "+ans);
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

        public int compare(Node n1, Node n2)
        {
            if(n1.weight<n2.weight) 
            return -1;
            if(n1.weight>n2.weight) 
            return 1;
            return 0;
        }
    }
    static int findways(int edges[][],int n)
    {
        ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<Node>());

        for(int i=0;i<edges.length;i++)
        {
            //adj.get(roads.get(i).get(0)).add(new Node(roads.get(i).get(1),roads.get(i).get(2)));
            //adj.get(roads.get(i).get(1)).add(new Node(roads.get(i).get(0),roads.get(i).get(2)));
            adj.get(edges[i][0]).add(new Node(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Node(edges[i][0],edges[i][2]));
        }
        
        int mod=(int)(1e9 + 7);
        int dist[]=new int[n];
        int ways[]=new int[n];

        for(int i=0;i<n;i++)
        {
            dist[i]=10000;
            ways[i]=0;
        }

        PriorityQueue<Node> pq= new PriorityQueue<Node>(n,new Node());
        pq.add(new Node(0,0));
        dist[0]=0;
        ways[0]=1;

        while(pq.size()!=0)
        {
            Node curr=pq.peek();
            pq.remove();

            for(Node it : adj.get(curr.getVal()))
            {
                if(dist[curr.getVal()]+it.getWeight()<dist[it.getVal()])
                {
                    dist[it.getVal()]=dist[curr.getVal()]+it.getWeight();
                    pq.add(new Node(it.getVal(),dist[it.getVal()]));
                    ways[it.getVal()]=ways[curr.getVal()];
                }
                else if(dist[curr.getVal()]+it.getWeight()==dist[it.getVal()])
                {
                    ways[it.getVal()]=(ways[it.getVal()]+ways[curr.getVal()])%mod;
                }
            }
        }
        return ways[n-1];
    }
}
