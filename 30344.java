import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		long[] arr = new long[N], r = new long[N], l = new long[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextLong();
			
			if(i == 0) r[i] = arr[i];
			else if(r[i - 1] > arr[i]) r[i] = r[i - 1];
			else r[i] = arr[i];
		}
		
		l[N - 1] = arr[N - 1];
		for(int i = N - 2; i >= 0; i--) {
			if(l[i + 1] < arr[i]) l[i] = arr[i];
			else l[i] = l[i + 1];
		}
		
		long res = 0, min = 0;
		for(int i = 0; i < N; i++) {
			min = Math.min(r[i], l[i]);
			
			if(min > arr[i]) res += min - arr[i];
		}
		
		System.out.println(res);
	}
}