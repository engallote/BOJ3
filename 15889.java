import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		if(N == 1) {
			System.out.println("권병장님, 중대장님이 찾으십니다");
			return;
		}
		
		int[] dist = new int[N];
		for(int i = 0; i < N - 1; i++) dist[i] = sc.nextInt();
		dist[N - 1] = 100000000;
		
		int idx = 0;
		
		while(idx < N - 1) {
			int d = arr[idx] + dist[idx];
			int next = -1, max = 0;
			
			for(int i = idx + 1; i < N; i++) {
				if(arr[i] <= d) {
					if(dist[i] > max && arr[i] + dist[i] >= arr[i + 1]) {
						max = dist[i];
						next = i;
					}
				}
				else break;
			}
			
			if(next == -1) {
				System.out.println("엄마 나 전역 늦어질 것 같아");
				return;
			}
			idx = next;
		}
		
		System.out.println("권병장님, 중대장님이 찾으십니다");
	}
}