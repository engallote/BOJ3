import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N], res = new int[N];
		
		for(int i = 0; i < N; i++) arr[i] = i + 1;
		
		int idx = 0;
		for(int i = N - 1; i >= 1 && K > 0; i--)
			if(K - i >= 0) {
				K -= i;
				arr[i] = 0;
				res[idx] = i + 1;
				idx += 1;
			}
		
		for(int i = 0; i < N; i++) {
			if(arr[i] > 0) res[idx++] = arr[i];
			System.out.print(res[i] + " ");
		}
	}
}