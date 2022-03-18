import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		int l = 0, r = 1000000000, mid, res = r;
		while(l <= r) {
			mid = (l + r) / 2;
			
			int cnt = 0, cur = 0;
			for(int i = 0; i < N; i++) {
				if(arr[i] > mid) {
					cnt = Integer.MAX_VALUE;
					break;
				}
				if(arr[i] <= cur) cur -= arr[i];
				else {
					cur = mid - arr[i];
					++cnt;
				}
			}
			
			if(cnt > M) l = mid + 1;
			else {
				res = Math.min(res, mid);
				r = mid - 1;
			}
		}
		
		System.out.println(res);
	}
}