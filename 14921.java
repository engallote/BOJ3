import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		Arrays.sort(arr);
		
		int l = 0, r = N - 1, res = Integer.MAX_VALUE;
		
		while(l < r) {
			if(Math.abs(arr[l] + arr[r]) < Math.abs(res)) res = arr[l] + arr[r];
			
			if(Math.abs(arr[l + 1] + arr[r]) < Math.abs(arr[l] + arr[r - 1])) l++;
			else --r;
		}
		
		System.out.println(res);
	}
}