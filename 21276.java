import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] indgree = new int[N];
		boolean[] chk = new boolean[N];
		String[] name = new String[N];
		ArrayList<Integer>[] aly = new ArrayList[N];
		ArrayList<Integer>[] fam = new ArrayList[N];
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			hm.put(str, i);
			name[i] = str;
			aly[i] = new ArrayList<>();
			fam[i] = new ArrayList<>();
		}
		
		int M = sc.nextInt();
		while(--M >= 0) {
			String a = sc.next();
			String b = sc.next();
			
			aly[hm.get(b)].add(hm.get(a));
			indgree[hm.get(a)] += 1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		PriorityQueue<String> root = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++)
			if(indgree[i] == 0) {
				q.offer(i);
				chk[i] = true;
				root.offer(name[i]);
			}
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				int x = q.poll();
				
				for(int next : aly[x]) {
					--indgree[next];
					if(indgree[next] == 0) {//0이 되면 직계
						fam[x].add(next);
						q.offer(next);
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		
		sb.append(root.size() + "\n");
		while(!root.isEmpty()) sb.append(root.poll() + " ");
		sb.append("\n");
		
		for(int i = 0; i < N; i++) root.offer(name[i]);
		
		PriorityQueue<String> pq = new PriorityQueue<>();
		while(!root.isEmpty()) {
			String n = root.poll();
			int idx = hm.get(n);
			
			sb.append(n + " " + fam[idx].size() + " ");
			for(int next : fam[idx]) pq.offer(name[next]);
			while(!pq.isEmpty()) sb.append(pq.poll() + " ");
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}