import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N], res = new int[N];
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		int idx = 0;
		if(arr[N - 1] != 0) idx = 1;
		
		for(int i = N - 1; i >= 0; i--) {
			res[i] = idx;
			if(i - 1 >= 0 && arr[i] < arr[i - 1]) idx += 1;
			else continue;
		}
		
		if(idx > 0 && res[0] != M) {
			System.out.println("ambiguous");
			return;
		}
		for(int i = 0; i < N; i++) System.out.println(res[i]);
	}
}