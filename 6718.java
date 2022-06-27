import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> prime = new ArrayList<>();
		boolean[] chk = new boolean[33000];
		chk[0] = chk[1] = true;
		for(int i = 2; i < 33000; i++) {
			if(chk[i]) continue;
			prime.add(i);
			for(int j = i + i; j < 33000; j+=i) chk[j] = true;
		}
		
		while(true) {
			int N = sc.nextInt();
			if(N == 0) break;
			
			int res = 0;
			for(int i = 0; i < prime.size() - 1; i++) {
				if(prime.get(i) >= N) break;
				for(int j = i; j < prime.size(); j++) {
					if(prime.get(i) + prime.get(j) > N) break;
					if(prime.get(i) + prime.get(j) == N) ++res;
				}
			}
			
			System.out.println(res);
		}
	}
}