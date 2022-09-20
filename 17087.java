import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int S = sc.nextInt();
    	int[] arr = new int[N];
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
    	
    	Arrays.sort(arr);
    	int g = Math.abs(S - arr[0]);
    	for(int i = 1; i < N; i++) g = gcd(g, arr[i] - arr[i - 1]);
    	
    	System.out.println(g);
	}

	private static int gcd(int a, int b) {
		if(a == 0) return b;
		if(b == 0) return a;
		if(a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		return gcd(b, a % b);
	}
}