import java.util.*;
public class WordLadder_2 
{
    public static void main(String[] args) 
    {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
            "des",
            "der",
            "dfr",
            "dgt",
            "dfs"
        };
        
        WordLadder_2 obj = new WordLadder_2();
        ArrayList<ArrayList<String>> result= new ArrayList<ArrayList<String>>();
        result=obj.findList(startWord,targetWord,wordList);

        //Now Answer is Stored in result as an ArrayList within ArrayList.

        if(result.size()==0)
        System.out.println(-1 + "Not found");

        else
        {
            for(int i=0;i<result.size();i++)
            {
                ArrayList <String> temp = new ArrayList<String>();
                temp=result.get(i);
                for(int j=0;j<temp.size();j++)
                {
                    System.out.print(temp.get(j)+">");
                }
                System.out.println();
            }
        }
    }

    static ArrayList<ArrayList<String>> findList(String startWord,String targetWord,String []wordList)
    {
        HashSet<String> set = new HashSet<String>();
        for(int i=0;i<wordList.length;i++)
        {
            set.add(wordList[i]);
        }

        Queue<ArrayList<String>> q= new LinkedList<ArrayList<String>>();
        ArrayList<String> ls= new ArrayList<String>();
        ls.add(startWord);
        q.add(ls);

        ArrayList<String> usedOnLevel = new ArrayList<String>();
        usedOnLevel.add(startWord);

        int level=0;
        int count=0;

        ArrayList<ArrayList<String>> ans= new ArrayList<ArrayList<String>>();

        while(!q.isEmpty())
        {
            count++;
            ArrayList<String> vis = new ArrayList<String>();
            vis=q.peek();
            q.remove();

            if(vis.size()>level)
            {
                level++;
                for(String it:vis)
                set.remove(it);
            }

            String word=vis.get(vis.size()-1);

            if(word.equals(targetWord))
            {
                if(ans.size()==0)
                ans.add(vis);
                else if (ans.get(0).size()== vis.size())
                ans.add(vis);
            }

            for(int i=0;i<word.length();i++)
            {
                for(char ch = 'a';ch <= 'z'; ch++)
                {
                    char[] replacedCharArray=word.toCharArray();
                    replacedCharArray[i]= ch;
                    String newWord= new String(replacedCharArray);

                    if(set.contains(newWord))
                    {
                        vis.add(newWord);
                        ArrayList<String> temp = new ArrayList<String>(vis);
                        q.add(temp);
                        usedOnLevel.add(newWord);
                        vis.remove(vis.size()-1);
                    }

                }
            }
        }
        return ans;

    }

}
