import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int T = sc.nextInt();
		long[] arr = new long[N];
		long sum = 0;
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextLong();
			sum += arr[i];
		}
		
		if(sum % K != 0) {
			System.out.println("NO");
			return;
		}
		
		Arrays.sort(arr);
		
		int s = 0, e = N - 1;
		while(s <= e && arr[e] != 0) {
			long sub = K - arr[e];
			
			if(T < sub) {
				System.out.println("NO");
				return;
			}
			
			for(int i = s; i < e; i++) {
				if(arr[i] > sub) {
					arr[i] -= sub;
					T -= sub;
					arr[e] = K;
					s = i;
					break;
				}
				else {
					T -= arr[i];
					sub -= arr[i];
					arr[e] += arr[i];
					arr[i] = 0;
					s = i + 1;
				}
			}
			
			if(arr[e] == K) {
				arr[e] = 0;
				e -= 1;
			}
			else {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}
}