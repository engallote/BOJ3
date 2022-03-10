import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int M = sc.nextInt();
		
		int res = 0;
		for(int i = 1;; i++) {
			if(X * i > M) break;
			
			int div = (M - X * i) / Y;
			res = Math.max(res, X * i + Y * div);
		}
		
		System.out.println(res);
	}
}