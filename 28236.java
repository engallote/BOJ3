import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		int res = Integer.MAX_VALUE, idx = 0;
		for(int i = 1; i <= K; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(x == 1) {
				if(res > M - y) {
					res = M - y;
					idx = i;
				}
				continue;
			}
			
			int tmp = y + (x - 1) + M;
			tmp = Math.min(tmp, (M - y) + (x - 1));
			
			if(res > tmp) {
				res = tmp;
				idx = i;
			}
		}
		
		System.out.println(idx);
	}
}