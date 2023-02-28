import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] map = new String[9][9];
		
		HashMap<String, Integer> hm = new HashMap<>();
		PriorityQueue<String> pq = new PriorityQueue<>();
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++) {
				map[i][j] = sc.next();
				if(i == 1 || i == 4 || i == 7) {
					if(j == 1 || j == 4 || j == 7) {
						if(i == 4 && j == 4) continue;
						hm.put(map[i][j], i * 100 + j);
						pq.offer(map[i][j]);
					}
				}
			}	
		
		StringBuilder sb = new StringBuilder();
		PriorityQueue<String> order = new PriorityQueue<>();
		for(int t = 1; !pq.isEmpty(); t++) {
			String main = pq.poll();
			int x = hm.get(main) / 100, y = hm.get(main) % 100;
			
			sb.append("#" + t + ". " + main + "\n");
			for(int i = x - 1; i <= x + 1; i++)
				for(int j = y - 1; j <= y + 1; j ++) {
					if(i == x && j == y) continue;
					order.offer(map[i][j]);
				}
			
			for(int i = 1; !order.isEmpty(); i++) {
				sb.append("#" + t + "-" + i + ". " + order.poll() + "\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}