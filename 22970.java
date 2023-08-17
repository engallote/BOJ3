import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		boolean down;
		int res = 1, j;
		for(int i = 0; i < N; i++) {
			down = false;
			
			for(j = i + 1; j < N; j++) {
				if(down) {
					if(arr[j - 1] > arr[j]) continue;
					else break;
				}
				else {
					if(arr[j - 1] < arr[j]) continue;
					else if(arr[j] == arr[j - 1]) break;
					else down = true;
				}
			}
			
			res = Math.max(res, j - i);
		}
		
		System.out.println(res);
	}
}