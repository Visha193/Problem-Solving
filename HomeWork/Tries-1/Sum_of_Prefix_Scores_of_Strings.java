class Sum_of_Prefix_Scores_of_Strings {
    class TrieNode
    {
        TrieNode[] ch;
        short count;
        TrieNode()
        {
            ch=new TrieNode[26];
            count=0;
        }
    }
    public int[] sumPrefixScores(String[] words) { //Function to get prefix scores
        TrieNode root=new TrieNode(); //Root of Trie
        for(String s:words) //Iterating over all words
         insert(root,s);
        int[] ans=new int[words.length]; //Answer array
        for(int i=0;i<words.length;i++)
        {
            ans[i]=getAns(words[i],root);
        }
        return ans;
    }
    public void insert(TrieNode root,String s)
    {
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(root.ch[c-'a']==null)
             root.ch[c-'a']=new TrieNode();
            root=root.ch[c-'a'];
            root.count++;
        }
    }
    public int getAns(String s,TrieNode root)
    {
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            root=root.ch[c-'a'];
            ans+=root.count;
        }
        return ans;
    }
}
