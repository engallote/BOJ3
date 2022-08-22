import java.util.*;

public class Main {
	static int N, W, T, K, res;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		W = sc.nextInt();
		T = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N];
		res = 0;
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		find(1, W, N);
		
		System.out.println(res);
	}
	private static void find(int time, int idx, int chk) {
		int[] tmp = new int[N];
		
		//화력 감소
		for(int i = 0; i < N; i++) {
			if(i == chk) continue;
			tmp[i] = 3;
			if(i - 1 >= 0 && arr[i - 1] > 0) tmp[i] -= 1;
			if(i + 1 < N && arr[i + 1] > 0) tmp[i] -= 1;
		}
		
		for(int i = 0; i < N; i++) arr[i] -= tmp[i];
		
		if(time == T) {
			int k = 0;
			for(int i = 0; i < N; i++) {
				if(arr[i] > 0) ++k;
				arr[i] += tmp[i];
			}
			
			if(k >= K) ++res;
			return;
		}
		
		//이동
		find(time + 1, idx, idx);
		if(idx - 1 >= 0) find(time + 1, idx - 1, idx - 1);
		if(idx + 1 < N) find(time + 1, idx + 1, idx + 1);
		
		for(int i = 0; i < N; i++) arr[i] += tmp[i];
	}
}