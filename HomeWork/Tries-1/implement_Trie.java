class Trie {

    class Node
    {
        Node[] ch;
        boolean flag;
        Node()
        {
            ch=new Node[26];
            flag=false;
        }
    }
    Node root; // root of the trie
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) { // insert a word in the trie
        Node pos=root; // pointer to the root
        for(int i=0;i<word.length();i++) // iterate over the word
        {
         char c=word.charAt(i); // get the character
         if(pos.ch[c-'a']==null) // if the character is not present in the trie
          pos.ch[c-'a']=new Node(); // create a new node
         pos=pos.ch[c-'a'];
        }
        pos.flag=true;
    }
    
    public boolean search(String word) { // search for a word in the trie
        Node pos=root; // pointer to the root
        for(int i=0;i<word.length();i++) // iterate over the word
        {
         char c=word.charAt(i);
         if(pos.ch[c-'a']==null)
          return false;
         pos=pos.ch[c-'a'];
        }
        return pos.flag==true;
    }
    
    public boolean startsWith(String prefix) {
        Node pos=root;
        for(int i=0;i<prefix.length();i++)
        {
         char c=prefix.charAt(i);
         if(pos.ch[c-'a']==null)
          return false;
         pos=pos.ch[c-'a'];
        }
        return true;
    }
}
