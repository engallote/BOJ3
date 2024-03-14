import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[6];
		ArrayList<Integer>[] aly = new ArrayList[6];
		
		for(int i = 1; i <= 5; i++) {
			arr[i] = sc.nextInt();
			aly[i] = new ArrayList<>();
		}
		
		int res = 0;
		for(int i = 0; i < N; i++) {
			int k = sc.nextInt();
			int t = sc.nextInt();
			
			aly[k].add(t);
		}
		
		for(int i = 1; i <= 5; i++) Collections.sort(aly[i]);
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= 5; i++) {
			for(int j = 0, cnt = 0; j < aly[i].size() && cnt < arr[i]; j++, cnt++) {
				res += aly[i].get(j);
				q.offer(aly[i].get(j));
			}
			
			int pre = q.poll();
			while(!q.isEmpty()) {
				res += Math.abs(pre - q.peek());
				pre = q.poll();
			}
			
			if(i != 5) res += 60;
		}
		
		System.out.println(res);
	}
}