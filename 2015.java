import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		HashMap<Long, Long> hm = new HashMap<>();
		long res = 0, pre = 0;
		
		for(int i = 0; i < N; i++) {
			long num = sc.nextInt() + pre;
			
			if(num == K) ++res;
			if(hm.containsKey(num - K)) res += hm.get(num - K);
			
			if(!hm.containsKey(num)) hm.put(num, 1l);
			else hm.replace(num, hm.get(num) + 1);
			
			pre = num;
		}
		
		System.out.println(res);
	}
}