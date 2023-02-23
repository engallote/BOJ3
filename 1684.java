import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N], chk = new int[N-1];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		if(N == 1) {
			System.out.println(1000000);
			return;
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < N - 1; i++)
			chk[i] = arr[i+1] - arr[i];
			
		Arrays.sort(chk);
		int r = chk[0];
		
		for(int i = 1; i < N-1; i++)
			r = gcd(r, chk[i]);
		
		System.out.println(r);
	}

	private static int gcd(int a, int b) {
//		System.out.println(a + " " + b);
		if(b == 0) return a;
		if(a == 0) return b;
		if(a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		return gcd(b, a % b);
	}
}