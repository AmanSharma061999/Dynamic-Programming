import java.util.*;
public class cheapestFlight {
    public static void main(String[] args) {

        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        cheapestFlight obj=new cheapestFlight();
        int ans=obj.cheapestFlight(flights,n,src,dst,K);
        if(ans==0)
        System.out.println("No such Flights with this stop");
        else
        System.out.println("Minimum cost to reach the destination "+ ans);
    }
    
    static class Node
    {
        int val;
        int weight;
        Node(int val,int weight)
        {
            this.val=val;
            this.weight=weight;
        }
    }
    static class tuple
    {
        int stops;
        int val;
        int weight;
        tuple(int stops,int val,int weight)
        {
            this.stops=stops;
            this.val=val;
            this.weight=weight;
        }
    }
    static int cheapestFlight(int flights[][],int n,int src,int dest,int k)
    {
        ArrayList<ArrayList<Node>> adj=new ArrayList<ArrayList<Node>>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<Node>());

        int m=flights.length;
        for(int i=0;i<m;i++)
        adj.get(flights[i][0]).add(new Node(flights[i][1],flights[i][2]));

        Queue<tuple> q= new LinkedList<tuple>();
        q.add(new tuple(0,src,0));

        int dist[]=new int[n+1];
        for(int i=0;i<n+1;i++)
        dist[i]=10000;

        dist[src]=0;

        while(!q.isEmpty())
        {
            tuple curr=q.peek();
            int stop=curr.stops;
            int val=curr.val;
            int cost=curr.weight;
            q.remove();

            if(stop>k)
            continue;

            for(Node it:adj.get(val))
            {
                if(cost+it.weight<dist[it.val])
                {
                    dist[it.val]=cost+it.weight;
                    q.add(new tuple(stop+1,it.val,it.weight));
                }
            }
        }

        return dist[dest];
    }
    
}
