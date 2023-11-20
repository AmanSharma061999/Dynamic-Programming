import java.util.*;
public class krushkal 
{
    static class Node
    {
        private int u;
        private int v;
        private int weight;

        Node(int u, int v, int weight)
        {
            this.u=u;
            this.v=v;
            this.weight=weight;
        }

        int getU()
        {
            return u;
        }

        int getV()
        {
            return v;
        }

        int getWeight()
        {
            return weight;
        }
    }
    static class SortComparator implements Comparator<Node>
    {        
        @Override
        public int compare(Node n1, Node n2)
        {
            if(n1.getWeight()<n2.getWeight())
            return -1;
            if(n1.getWeight()>n2.getWeight())
            return 1;
            return 0;
        }
    }

    static int parent(int u,int parent[])
    {
        if(u==parent[u])
        return u;

        return parent[u]=parent(parent[u],parent);
    }

    static void Union(int u,int v,int parent[],int rank[])
    {
        u=parent(u,parent);
        v=parent(v,parent);

        if(rank[u]<rank[v])
        {
            parent[u]=v;
        }
        if(rank[v]<rank[u])
        {
            parent[v]=u;
        }
        else
        {
            rank[u]++;
            parent[v]=u;
        }
    }

    static void krushkals(ArrayList<Node> adj, int n)
    {
        Collections.sort(adj, new SortComparator());
        int parent[]=new int[n];
        int rank[]=new int[n];

        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            rank[i]=0;
        }

        int costmst=0;
        ArrayList<Node> mst=new ArrayList<Node>();

        for(Node it:adj)
        {
            if(parent(it.getU(),parent)!=parent(it.getV(),parent))
            {
                costmst+=it.getWeight();
                mst.add(it);
                Union(it.getU(),it.getV(),parent,rank);
            }

        }
        System.out.println(costmst);

    }
    public static void main(String args[]) 
       {
            int n = 5;
            ArrayList<Node> adj = new ArrayList<Node>();


                adj.add(new Node(0, 1, 2));
                adj.add(new Node(0, 3, 6));
                adj.add(new Node(1, 3, 8));
                adj.add(new Node(1, 2, 3));
                adj.add(new Node(1, 4, 5));
                adj.add(new Node(2, 4, 7));


                krushkal obj = new krushkal(); 
                obj.krushkals(adj, n);
       }
}



