import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<String, Integer> hm = new HashMap<>();
		String[] arr = new String[N + 1];
		int[] get = new int[N + 1];
		
		sc.nextLine();
		for(int i = 1; i <= N; i++) {
			String  name = sc.nextLine();
			hm.put(name, i);
			arr[i] = name;
		}
		
		Queue<Integer>[] q = new LinkedList[1001];
		int cnt = 0;
		while(sc.hasNextInt()) {
			q[cnt] = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				int num = sc.nextInt();
				q[cnt].offer(num);
			}
			
			++cnt;
		}
		
		boolean[] chk = new boolean[N + 1];
		while(true) {
			//과반 확인
			int max = 0, min = Integer.MAX_VALUE;
			for(int i = 0; i < cnt; i++) {
				while(!q[i].isEmpty() && chk[q[i].peek()]) q[i].poll();
				if(q[i].isEmpty()) continue;
				get[q[i].peek()] += 1;
			}
			
			for(int i = 1; i <= N; i++) {
				if(chk[i]) continue;
				max = Math.max(max, get[i]);
				min = Math.min(min, get[i]);
			}
			
			if(max > cnt / 2 || max == min) {//당선
				for(int i = 1; i <= N; i++)
					if(get[i] == max) System.out.println(arr[i]);
				return;
			}
			
			for(int i = 1; i <= N; i++) {
				if(get[i] == min) chk[i] = true;
				get[i] = 0;
			}
		}
	}
}