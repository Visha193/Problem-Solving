class Longest_Common_Suffix_Queries {
    class TrieNode
    {
        TrieNode[] ch;
        int ind;
        TrieNode()
        {
            ch=new TrieNode[26];
            ind=-1;
        }
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) { //Function to get indices
        TrieNode root=new TrieNode(); //Root of Trie
        for(int i=0;i<wordsContainer.length;i++) //Iterating over all words
         insert(root,i,wordsContainer[i],wordsContainer); //Inserting word
        
        int[] ans=new int[wordsQuery.length]; //Answer array
        for(int i=0;i<wordsQuery.length;i++) //Iterating over all queries
         ans[i]=retrieve(root,wordsQuery[i]); //Retrieving index
        return ans;
    }
    public void insert(TrieNode root,int ind,String word,String[] wordsContainer)
    {
        String wrd=(root.ind!=-1)?wordsContainer[root.ind]:"";
        if(wrd.equals("") || wrd.length()>word.length())
            root.ind=ind;
        for(int i=word.length()-1;i>=0;i--)
        {
            char c=word.charAt(i);
            if(root.ch[c-'a']==null)
             root.ch[c-'a']=new TrieNode();
            root=root.ch[c-'a'];
            wrd=(root.ind!=-1)?wordsContainer[root.ind]:"";
            if(wrd.equals("") || wrd.length()>word.length())
                root.ind=ind;
        }
    }
    public int retrieve(TrieNode root,String word)
    {
        for(int i=word.length()-1;i>=0;i--)
        {
            char c=word.charAt(i);
            if(root.ch[c-'a']==null)
             break;
            root=root.ch[c-'a'];
        }
        return root.ind;
    }

}
