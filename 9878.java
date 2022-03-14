import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		PriorityQueue<Long> time = new PriorityQueue<>(), dis = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			char c = sc.next().charAt(0);
			long num = sc.nextLong();
			
			if(c == 'T') time.offer(num);
			else dis.offer(num);
		}
		
		double dist = 0, speed = 1, res = 0;
		
		while(!time.isEmpty() || !dis.isEmpty()) {
			if(time.isEmpty()) {
				long d = dis.poll();
				res += (d - dist) * speed;
				dist = d;
			}
			else if(dis.isEmpty()) {
				long t = time.poll();
				dist += (t - res) * (1.0 / (double)speed);
				res = t;
			}
			else {
				long t = time.peek(), d = dis.peek();
				if(res + (d - dist) * speed <= t) {
					dis.poll();
					res += (d - dist) * speed;
					dist = d;
				}
				else {
					time.poll();
					dist += (t - res) * (1.0 / (double)speed);
					res = t;
				}
			}
			++speed;
		}
		
		res += (1000 - dist) * speed;
		
		System.out.println(Math.round(res));
	}
}