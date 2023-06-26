import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		Arrays.sort(arr);
		
		int res = -1, max = -1;
		for(int i = 1; i < N; i++) {
			int sub = arr[i] - arr[i - 1];
			
			if(sub == 1) continue;
			
			sub /= 2;
			if(max < sub) {
				max = sub;
				res = Math.min(arr[i - 1] + sub, arr[i] - sub);
			}
		}
		
		System.out.println(res);
	}
}