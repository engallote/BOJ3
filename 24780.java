import java.util.*;

public class Main {
	static int N;
	static ArrayList<Integer>[] aly;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		aly = new ArrayList[101];
		
		for(int i = 0; i <= 100; i++) aly[i] = new ArrayList<>();
		
		while(true) {
			String[] str = sc.nextLine().split(" ");
			if(str.length == 1) break;
			
			int root = Integer.parseInt(str[0]);
			for(int i = 1; i < str.length; i++) {
				int num = Integer.parseInt(str[i]);
				aly[num].add(root);
			}
		}
		
		go();
	}
	private static void go() {
		int[] par = new int[101], chk = new int[101];
		Arrays.fill(chk, 1000000);
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		chk[N] = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				int x = q.poll();
				
				for(int next : aly[x]) {
					if(chk[next] <= chk[x] + 1) continue;
					chk[next] = chk[x] + 1;
					par[x] = next;
					q.offer(next);
				}
			}
		}
		
		int idx = N;
		while(idx != 0) {
			System.out.print(idx + " ");
			idx = par[idx];
		}
	}
}