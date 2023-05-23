import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int res = 0;
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			
			res = Math.max(res, num - (N - i));
		}
		
		System.out.println(res);
	}
}