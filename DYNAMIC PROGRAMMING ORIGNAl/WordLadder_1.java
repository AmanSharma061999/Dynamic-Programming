import java.util.*;
public class WordLadder_1 
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
        WordLadder_1 obj = new WordLadder_1();
        int ans = obj.wordLadderLength(startWord,targetWord,wordList);
        System.out.println(ans);
    }

    static int wordLadderLength(String startWord,String targetWord,String [] wordList)
    {
        HashSet<String> set = new HashSet<String>();
        for(int i=0;i<wordList.length;i++)
        set.add(wordList[i]);

        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(startWord,1));
        set.remove(startWord);

        while(!q.isEmpty())
        {
            String currWord=q.peek().Word;
            int lev=q.peek().level;
            q.remove();

            if(currWord.equals(targetWord)==true)
            return lev;

            for(int i=0;i<currWord.length();i++)
            {
                for(char ch ='a';ch <= 'z';ch++)
                {
                    char replacedArray[]= currWord.toCharArray();
                    replacedArray[i]=ch;
                    String temp = new String(replacedArray);
                    if(set.contains(temp))
                    {
                        q.add(new Pair(temp,lev+1));
                        set.remove(temp);
                    }

                }
            }
        }
        return 0;

    }

    static class Pair
    {
        String Word;
        int level;
        Pair(String Word, int level)
        {
            this.Word=Word;
            this.level=level;
        }
    }
}
