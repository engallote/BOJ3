import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		int res = 0;
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(num >= arr[i]) res += 1;
		}
		
		System.out.println(res);
	}
}