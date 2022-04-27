import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			long N = sc.nextLong();
			if(N == 0) break;
			
			long tmp = N * N;
			long res = 0;
			for(int i = 1; i <= N; i++)
				if(tmp % i == 0) {
					long a = (i + (tmp / i)) / 2;
					long b = Math.abs(i - (tmp / i)) / 2;
					
					if(Math.min(a, b) > N && tmp == a * a - b * b) res += 1;
				}
			
			System.out.println(res);
		}
	}
}