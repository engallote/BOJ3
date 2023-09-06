import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		int[] arr2 = new int[M];
		for(int i = 0; i < M; i++) arr2[i] = sc.nextInt();
		
		int res = 0, idx = 0;
		while(idx < N) {
			
			int lastIdx = -1;
			boolean flag = false;
			
			for(int j = 0; j < M; j++) {
				if(arr[idx] == arr2[j]) {
					flag = true;
					break;
				}
			}
			
			if(flag) {
				idx += 1;
				continue;
			}
			
			loop:for(int i = N - 1; i >= idx; i--) {
				for(int j = 0; j < M; j++)
					if(arr[i] == arr2[j]) {
						lastIdx = i;
						break loop;
					}
			}
			
			if(lastIdx == -1) break;
			
			int tmp = arr[idx];
			arr[idx] = arr[lastIdx];
			arr[lastIdx] = tmp;
			
			res += 1;
			idx += 1;
		}
		
		System.out.println(res);
	}
}