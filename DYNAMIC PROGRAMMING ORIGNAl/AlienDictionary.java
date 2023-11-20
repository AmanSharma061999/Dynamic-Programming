import java.util.*;
public class AlienDictionary 
{
    public static void main(String[] args) 
    {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        AlienDictionary obj = new AlienDictionary();
        System.out.println(obj.findOrder(N,K,dict));
    }
    static String findOrder(int n, int k, String dict[])
    {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<k;i++)
        adj.add(new ArrayList<Integer>());

        for(int i=0;i<n-1;i++)
        {
            String s1=dict[i];
            String s2=dict[i+1];

            int len1=s1.length();
            int len2=s2.length();
            int len=Math.min(len1,len2);

            for(int ptr=0;ptr<len;ptr++)
            {
                if(s1.charAt(ptr)!= s2.charAt(ptr))
                {
                    adj.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
                    //System.out.println(s1.charAt(ptr)-'a');
                    break;
                }
            }
        }
        ArrayList<Integer> topo= toposort(adj,k);
        String ans="";

        for(int it:topo)
        ans=ans+ (char)(it+ (int)('a'))+ " ";

        return ans;
    }
    static ArrayList<Integer> toposort(ArrayList<ArrayList<Integer>> adj,int v)
    {

        Queue<Integer> q= new LinkedList<Integer>();
        ArrayList<Integer> ans= new ArrayList<Integer>();

        int indegree[]= new int[v];
        for(int i=0;i<v;i++)
        {
            for(int it:adj.get(i))
            indegree[it]++;
        }

        for(int i=0;i<v;i++)
        {
            if(indegree[i]==0)
            q.add(i);
        }

        while(!q.isEmpty())
        {
            int curr=q.peek();
            q.remove();
            ans.add(curr);

            for(int it:adj.get(curr))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.add(it);
                }
            }
        }
        return ans;

    }
    
}
