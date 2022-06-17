import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0) {
			int N = sc.nextInt();
			int[] arr = new int[N + 1];
			boolean flag = true;
			
			for(int i = 1; i <= N; i++) arr[i] = sc.nextInt();
			
			for(int i = 1; i <= N; i++) {
				arr[i] = Math.min(arr[i], N - arr[i] + 1);
				if(arr[i] < arr[i - 1]) {
					if(N - arr[i] + 1 < arr[i - 1]) {
						flag = false;
						break;
					}
					arr[i] = N - arr[i] + 1;
				}
			}
			
			System.out.println(flag ? "YES" : "NO");
		}
	}
}