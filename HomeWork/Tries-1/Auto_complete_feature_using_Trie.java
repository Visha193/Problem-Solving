import java.util.Scanner;

public class Auto_complete_feature_using_Trie {
    static class TrieNode //TrieNode class
    {
        TrieNode[] ch;//Array of TrieNode
        boolean flag;

        public TrieNode() {
            this.flag = false;
            this.ch = new TrieNode[26];
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of Strings:"); //Number of words
        int n=sc.nextInt();
        String[] words=new String[n];
        System.out.printf("Enter words"); //Words
        for(int i=0;i<n;i++)
         words[i]=sc.next();
        System.out.println("Enter query"); //Query
        String query=sc.next();

        TrieNode root=new TrieNode(); //Root of Trie
        for(int i=0;i<n;i++) //Inserting all words in Trie
         insert(root,words[i]); //Inserting word in Trie

        getAns(root,query);
    }
    public static void insert(TrieNode root,String s) 
    {
        TrieNode node=root; //Starting from root
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);//Taking character
            if(node.ch[c-'a']==null) //If character is not present in Trie
                 node.ch[c-'a']=new TrieNode(); //Create new TrieNode
            node=node.ch[c-'a']; //Move to next TrieNode
        }
        node.flag=true; //Marking end of word
    }
    public static void getAns(TrieNode root,String query)
    {
        TrieNode node=root; //Starting from root
        for(int i=0;i<query.length();i++)
        {
            char c=query.charAt(i);
            if(node.ch[c-'a']==null) //If character is not present in Trie
            {
                System.out.println("-1");
                return ;
            }
            node=node.ch[c-'a'];
        }
        printAllAns(node,new StringBuilder(query)); //Printing all words
    }
    public static void printAllAns(TrieNode node,StringBuilder s)
    {
        if(node.flag)
            System.out.println(s.toString());
        for(int i=0;i<26;i++)
        {
            if(node.ch[i]!=null)
            {
                s.append((char)(97+i));
                printAllAns(node.ch[i],s);
                s.delete(s.length()-1,s.length());
            }
        }
    }
}

