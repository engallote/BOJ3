import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		ArrayList<Long> prime = new ArrayList<>();
		boolean[] chk = new boolean[100000];
		for(int i = 2; i < 100000; i++) {
			if(chk[i]) continue;
			prime.add((long)i);
			for(int j = i + i; j < 100000; j+=i) chk[j] = true;
		}
		while(--T >= 0) {
			long N = sc.nextLong();
			
			if(N <= 2) {
				System.out.println(2);
				continue;
			}
			
			boolean flag = false;
			for(long i = N; i <= 2 * N; i++) {
				flag = false;
				for(long num : prime) {
					if(i == num) break;
					if(i % num == 0) {
						flag = true;
						break;
					}
					if(num > i) break;
				}
				
				if(!flag) {
					System.out.println(i);
					break;
				}
			}
		}
	}
}