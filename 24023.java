import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		int l = -1, sum = 0;
		for(int i = 0; i < N; i++) {
			if(l == -1) l = i;
			if((arr[i] | K) > K) {
				sum = 0;
				l = -1;
			}
			else {
				sum |= arr[i];
				if(sum == K) {
					System.out.println((l + 1) + " " + (i + 1));
					return;
				}
			}
		}
		
		System.out.println(-1);
	}
}