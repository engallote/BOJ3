import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[50001];
		
		for(int k = 1; k <= N; k++) {
			int min = Integer.MAX_VALUE;
			
			for(int i = 1; i * i <= k; i++) 
				min = Math.min(min, arr[k - i * i]);
			
			arr[k] = min + 1;
		}
		
		System.out.println(arr[N]);
	}
}