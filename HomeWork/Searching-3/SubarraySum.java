public class SubarraySum {
    public static void main(String[] args) {     
        int a[] = {1,3,4,2};
        int n =a.length;
        int s=7;
        int low=1;
        int high=n-1;
        int ans=0;

        while(low<high){ 
        int mid=low + (high-low)/2;
            if(!satisfying(a , mid ,s))
            {
                high = mid-1;
            }
            else {
                ans=mid;
                low=mid+1;
            }
        }
        System.out.println(ans);    
    }

    static boolean satisfying(int a[] , int size , int s){
        int i =0;
        int j=size;
        int sum=0;

    for(int q=0; q<size; q++){
        sum+=a[i];
    }
        while(j<a.length){
            if(sum>s)
            {
                return false;
            }
            else 
            {
                
                sum=sum-a[i];
                i++;
                sum=sum+a[j];
                j++;
            }
        }
        return true;
    }    
}