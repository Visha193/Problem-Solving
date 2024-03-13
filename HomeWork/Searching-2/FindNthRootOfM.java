
    public class FindNthrootofM {
        public int NthRoot(int n, int m)
        {
            int start =0;
            int end = m;
            int mid=-1;
            // using binary search   
            while(start<=end)
            {
                 mid = start  +(end-start)/2;
                double ch = Math.pow(mid,n);
                if((int)ch == m){
                    return mid;
                }
                else if((int)ch > m){
                    end=mid-1;
                }
                else 
                {
                    start =mid+1;
                }
            }
            
            return -1;
        }
    }

