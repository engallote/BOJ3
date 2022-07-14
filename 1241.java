import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] sum = new int[1000001];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			sum[arr[i]] += 1;
		}
		
		int res = 0;
		for(int i = 0; i < N; i++) {
			res = 0;
			for(int j = 1; j * j <= arr[i]; j++)
				if(arr[i] % j == 0) {
					if(arr[i] / j == j) res += sum[j];
					else res += sum[arr[i] / j] + sum[j];
				}
			if(res > 0) res -= 1;
			System.out.println(res);
		}
	}
}