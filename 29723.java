import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String name = sc.next();
			int p = sc.nextInt();
			
			hm.put(name, p);
		}
		
		int min = 0, max = 0, sum = 0;
		for(int i = 0; i < K; i++) {
			String name = sc.next();
			
			sum += hm.get(name);
			
			hm.remove(name);
		}
		
		ArrayList<Integer> aly = new ArrayList<>();
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			int value = hm.get(key);
			
			aly.add(value);
		}
		
		Collections.sort(aly);
		
		int cnt = 0, l = 0, r = aly.size() - 1;
		while(cnt < M - K) {
			min += aly.get(l);
			max += aly.get(r);
			
			l += 1;
			r -= 1;
			cnt += 1;
		}
		
		System.out.println((sum + min) + " " + (sum + max));
	}
}