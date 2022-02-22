import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		int[] sum = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			sum[i] = sum[i - 1] + sc.nextInt();
		}
		
		int max = 0, cnt = 0;
		for(int i = X; i <= N; i++) {
			if(sum[i] - sum[i - X] > max) {
				max = sum[i] - sum[i - X];
				cnt = 1;
			}
			else if(sum[i] - sum[i - X] == max) ++cnt;
		}
		
		if(max == 0) {
			System.out.println("SAD");
			return;
		}
		System.out.println(max);
		System.out.println(cnt);
	}
}