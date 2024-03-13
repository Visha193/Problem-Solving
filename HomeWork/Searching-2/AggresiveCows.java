        public class AggressiveCows {
            public static int solve(int n, int k, int[] stalls) {
            Arrays.sort(stalls);
            int low=1;
            int high=stalls[n-1]-stalls[0];
            
            while(low<=high){
                int mid= (low+high)/2;
                if(canWePlace(stalls ,k,mid)){
                    low=mid+1;
                }
                else {
                    high =mid-1;
                }
            }
            return high;
        }
        
        static boolean canWePlace(int a[] , int cows ,int minD)
        {
            
            int countCow=1;
            int last=a[0];
            for(int i =1; i<a.length; i++){
                
                if(a[i] - last>=minD){
                    last=a[i];
                    countCow++;
                }
                
                if(countCow>=cows){
                    return true;
                }
            }
            return false;
        }
        }