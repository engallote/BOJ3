import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//개수
		long C = sc.nextLong();//비용
		long W = sc.nextLong();//가격
		long[] arr = new long[N];
		long res = 0;
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextLong();
			res = Math.max(res, arr[i] * W);
		}
		
		for(long k = 1; k <= 10000; k++) {
			long cnt = 0, sum = 0;
			
			for(int i = 0; i < N; i++) {
				if(arr[i] < k) continue;
				
				long tree = arr[i] / k;
				cnt = arr[i] / k;
				if(arr[i] % k == 0) cnt -= 1;
				
				if(tree * W * k - cnt * C > 0) sum += tree * W * k - cnt * C;
			}
			
			res = Math.max(res, sum);
		}
		
		System.out.println(res);
	}
}