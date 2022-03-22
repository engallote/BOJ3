import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		int l = 0, r = 1000000000, mid, res = 0;
		while(l <= r) {
			mid = (l + r) / 2;
			if(mid == 0) {
				l = mid + 1;
				continue;
			}
			
			int cnt = 0;
			
			for(int i = 0; i < N; i++)
				if(mid <= arr[i]) cnt += arr[i] / mid;
			
			if(cnt >= M) {
				res = Math.max(res, mid);
				l = mid + 1;
			}
			else r = mid - 1;
		}
		
		System.out.println(res);
	}
}