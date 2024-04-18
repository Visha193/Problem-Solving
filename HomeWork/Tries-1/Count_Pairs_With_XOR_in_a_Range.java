class Count_Pairs_With_XOR_in_a_Range {
    class TrieNode
    {
        TrieNode[] ch; //Children
        int freq; //Frequency
        TrieNode()
        {
            freq=0;
            ch=new TrieNode[2];
        }
    }
    public int countPairs(int[] nums, int low, int high) { //Function to count pairs
        TrieNode root=new TrieNode(); //Root of Trie
        insert(root,nums[0]); //Inserting first element
        int count=0; //Count of pairs
        for(int i=1;i<nums.length;i++)//Iterating over all elements
        {
            count+=getAns(root,nums[i],high,14);//Getting answer for high
            count-=getAns(root,nums[i],low-1,14);//Getting answer for low-1
            insert(root,nums[i]);//Inserting element
        }
        
        return count;
    }
    public void insert(TrieNode root,int num)//Function to insert element
    {
        int ind=14;//Index
        while(ind>=0)
        {
            int bit=(num>>ind)&1;//Getting bit
            if(root.ch[bit]==null)//If bit is not present
             root.ch[bit]=new TrieNode();//Create new TrieNode
            root=root.ch[bit];
            root.freq++;
            ind--;
        }
    }
    public int getAns(TrieNode root,int num,int high,int bit)
    {
     if(bit==-1)
         return root.freq;
     int bitInHigh=(high>>bit)&1;
     int bitInNum=(num>>bit)&1;
     int ans=0;
     if(bitInHigh==1)
     {
      int bitReq=(1+bitInNum)%2;
      ans+=(root.ch[bitInNum]==null)?0:root.ch[bitInNum].freq;
      if(root.ch[bitReq]!=null)
       ans+=getAns(root.ch[bitReq],num,high,bit-1);
     }
     else
     {
      if(root.ch[bitInNum]!=null)
       ans+=getAns(root.ch[bitInNum],num,high,bit-1);
     }
     return ans;
    }

}
