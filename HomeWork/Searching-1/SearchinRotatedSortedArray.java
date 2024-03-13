class SearchinRotatedSortedArray {
    public int search(int[] n, int key) {
      int l = 0;
      int array = n.length - 1;
  
      while (l <= array) 
      {
        final int m = (l + array) / 2;
        if (n[m] == key)
          return m;
  
        if (n[l] <= n[m]) 
        { 
  
          if (n[l] <= key && key < n[m])
            array = m - 1;
          else
            l = m + 1;
        } 
        else 
        { 
          if (n[m] < key && key <= n[array])
            l = m + 1;
          else
            array = m - 1;
        }
      }
  
      return -1;
    }
  }