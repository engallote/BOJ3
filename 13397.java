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
			
			int cnt = 1, min = Integer.MAX_VALUE, max = 0;
			for(int i = 0; i < N; i++) {
				min = Math.min(min, arr[i]);
				max = Math.max(max, arr[i]);
				if(max - min > mid) {
					++cnt;
					min = arr[i];
					max = arr[i];
				}
			}
			
			if(cnt <= M) {
				res = Math.min(res, mid);
				r = mid - 1;
			}
			else l = mid + 1;
		}
		
		System.out.println(res);
	}
}