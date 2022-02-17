import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		Arrays.sort(arr);
		
		int res = Integer.MAX_VALUE;
		int mid = N / 2 - 1, min = Integer.MAX_VALUE;
		
		for(int i = Math.max(0, mid); i < Math.min(mid + 2, N); i++) {
			int sum = 0;
			for(int j = 0; j < N; j++)
				sum += Math.abs(arr[i] - arr[j]);
			
			if(sum < min) {
				min = sum;
				res = arr[i];
			}
		}
		
		System.out.println(res);
	}
}