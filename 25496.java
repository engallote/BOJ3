import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int p = P, res = 0;
		for(int i = 0; i < N; i++) {
			if(p < 200) {
				p += arr[i];
				++res;
			}
			else break;
		}
		
		System.out.println(res);
	}
}