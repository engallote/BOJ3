import java.util.*;

public class Main {
	static int N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		long[] arr = new long[N];
		long[] a = new long[N];
		long[] b = new long[N];
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextLong();
		Arrays.sort(arr);
        
		for(int i = 0; i < K; i++) {
			int L = sc.nextInt() - 1;
			int R = sc.nextInt() - 1;
			long X = sc.nextLong();
			
			solve(L, R, X, arr, a, b);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) sb.append(arr[i] + " ");
		System.out.println(sb);
	}
	private static void solve(int l, int r, long x, long[] arr, long[] a, long[] b) {
		int idx1 = 0, idx2 = 0;
		
		for(int i = 0; i < N; i++) {
			if(l <= i && i <= r) {
				b[idx2] = arr[i] + x;
				idx2 += 1;
			}
			else {
				a[idx1] = arr[i];
				idx1 += 1;
			}
		}
		
		int aIdx = 0, bIdx = 0, idx = 0;
		while(aIdx < idx1 && bIdx < idx2) {
			if(a[aIdx] < b[bIdx]) {
				arr[idx] = a[aIdx];
				aIdx += 1;
			}
			else {
				arr[idx] = b[bIdx];
				bIdx += 1;
			}
			++idx;
		}
		
		while(aIdx < idx1) {
			arr[idx] = a[aIdx];
			idx += 1;
			aIdx += 1;
		}
		while(bIdx < idx2) {
			arr[idx] = b[bIdx];
			idx += 1;
			bIdx += 1;
		}
	}
}