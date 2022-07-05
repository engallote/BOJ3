import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		
		while(true) {
			int num = sc.nextInt();
			
			if(num == -1) break;
			else if(num == 0) q.poll();
			else if(q.size() < N) q.offer(num);
		}
		
		if(q.isEmpty()) System.out.println("empty");
		else while(!q.isEmpty()) System.out.print(q.poll() + " ");
	}
}