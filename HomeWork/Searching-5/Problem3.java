import java.util.*;

public class Problem3 {
	
	public static int gcd(int a, int b) 
	{ 
		if (a == 0) 
			return b; 
		return gcd(b % a, a); 
	} 
	public static int lcm(int a, int b) 
	{ 
		return (a * b) / gcd(a, b); 
	} 
	public static int divTermCount(int a, int b, int c, int num) 
	{ 
		return ((num / a) + (num / b) + (num / c) - (num / lcm(a, b)) - (num / lcm(b, c)) - (num / lcm(a, c)) + (num / lcm(a, lcm(b, c)))); 
	} 
	public static int findNthTerm(int a, int b, int c, int n) 
	{  
		int low = 1, high = Integer.MAX_VALUE, mid; 
		while (low < high) { 
			mid = low + (high - low) / 2; 
			if (divTermCount(a, b, c, mid) < n) 
				low = mid + 1; 
			else
				high = mid; 
		}
		return low; 
	} 
	public static void main(String[] args) 
	{ 
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int n = sc.nextInt();
		System.out.println(findNthTerm(a, b, c, n)); 

	} 
}
