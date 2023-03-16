import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] chk = new boolean[1000001];
		chk[0] = chk[1];
		ArrayList<Long> prime = new ArrayList<>();
		for(int i = 2; i <= 1000000; i++) {
			if(chk[i]) continue;
			prime.add((long)i);
			for(int j = i + i; j <= 1000000; j+=i) chk[j] = true;
		}
		
		long N = sc.nextLong();
		
		Deque<Long> ans = new LinkedList<>();
		Queue<Long> q = new LinkedList<>();
		for(int i = 0; i < prime.size() && N > 1; i++) {
			long num = prime.get(i); 
			while(N % num == 0) {
				N /= num;
				q.offer(num);
			}
		}
		
		if(N > 1) q.offer(N);
		
		if(q.size() == 1) System.out.println(-1);//¼Ò¼ö
		else {
			long a = 0, b = 0;
			while(!q.isEmpty()) {
				if(q.size() == 1) {
					a = ans.pollLast();
					b = q.poll();
					ans.offer(a * b);
					break;
				}
				a = q.poll();
				b = q.poll();
				ans.offer(a * b);
			}
			
			StringBuilder sb = new StringBuilder();
			while(!ans.isEmpty()) sb.append(ans.poll() + " ");
			System.out.println(sb.toString());
		}
	}
}