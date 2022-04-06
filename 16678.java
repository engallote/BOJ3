import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		long res = 0;
		
		if(arr[0] > 1) {
			res = arr[0] - 1;
			arr[0] = 1;
		}
		
		for(int i = 1; i < N; i++) {
			if(arr[i - 1] >= arr[i]) continue;
			res += (long)(arr[i] - (arr[i - 1] + 1));
			arr[i] = arr[i - 1] + 1;
		}
		
		System.out.println(res);
	}
}