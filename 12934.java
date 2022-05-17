import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long X = sc.nextLong();
		long Y = sc.nextLong();
		long sum = X + Y;
		long N = 0;
		
		for(long i = 1;; i++) {
			if(i * (i + 1) / 2 == sum) {
				N = i;
				break;
			}
			else if(i * (i + 1) / 2 > sum) {
				System.out.println(-1);
				return;
			}
		}
		
		long res = 0;
		while(X > 0) {
			X -= N;
			N -= 1;
			++res;
		}
		
		System.out.println(res);
	}
}