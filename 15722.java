import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt();
		int x = 0, y = 0, cnt = 1, cur = 0, round = 0, d = 0;
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		
		while(--time >= 0) {
			x += dy[d];
			y += dx[d];
			
			cur += 1;
			if(cur == cnt) {
				cur = 0;
				round += 1;
				
				if(round == 2) {
					cnt += 1;
					round = 0;
				}
				
				d += 1;
				d %= 4;
			}
		}
		
		System.out.println(x + " " + y);
	}
}