import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		HashSet<Long> hs = new HashSet<>();
		long res = 1, num = (long)N, t = (long)Math.pow(10, Integer.toString(N).length());
		while(true) {
			if(num % K == 0) break;
			num %= K;
			if(hs.contains(num)) {
				res = -1;
				break;
			}
			hs.add(num);
			
			num = num * t + N;
			++res;
		}
		
		System.out.println(res);
	}
}