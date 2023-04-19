import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String name = sc.next();
			hm.put(name, 0);
		}
		
		sc.nextLine();
		for(int i = 0; i < N; i++) {
			String[] name = sc.nextLine().split(" ");
			for(String str : name) {
				if(hm.containsKey(str)) hm.replace(str, hm.get(str) + 1);
				else hm.put(str, 1);
			}
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			int v = hm.get(key);
			
			pq.offer(new Pair(key, v));
		}
		
		while(!pq.isEmpty()) System.out.println(pq.peek().name + " " + pq.poll().cnt);
	}
}
class Pair implements Comparable<Pair> {
	String name;
	int cnt;
	Pair(String name, int cnt) {
		this.name = name;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.cnt > o.cnt) return -1;
		else if(this.cnt == o.cnt) {
			char[] a = this.name.toCharArray(), b = o.name.toCharArray();
			for(int i = 0; i < Math.min(a.length, b.length); i++) {
				if(a[i] < b[i]) return -1;
				else if(a[i] > b[i]) return 1;
			}
			
			if(a.length > b.length) return 1;
			else if(a.length == b.length) return 0;
			else return -1;
		}
		else return 1;
	}
}