import java.util.*;

public class Main {
	static int x, y;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[6][7];
		// map[4] = /, map[5] = \
		
		int turn = 0;
		x = 0;
		y = 0;
		boolean win = false, flag = false;
		
		while(sc.hasNext()) {
			char[] ch = sc.next().toCharArray();
			int zero = 0;
			flag = false;
			
			if(win) continue;
			
			for(int i : ch)
				if(i == '0') zero += 1;
			
			if(zero == 0) {//��
				flag = go(5);
//				System.out.println("�� > " + x + ", " + y);
				continue;
			}
			else if(zero == 1) {//��
				flag = go(1);
//				System.out.println("�� > " + x + ", " + y);
			}
			else if(zero == 2) {//��
				flag = go(2);
//				System.out.println("�� > " + x + ", " + y);
			}
			else if(zero == 3) {//��
				flag = go(3);
//				System.out.println("�� > " + x + ", " + y);
			}
			else if(zero == 4) {//��
				flag = go(4);
//				System.out.println("�� > " + x + ", " + y);
				continue;
			}
			
			++turn;
			if(flag && turn <= 10) win = true;
		}
		
		System.out.println(win ? "WIN" : "LOSE");
	}

	private static boolean go(int num) {
		y += num;
		if(y == 3) {
			if(x == 4) x = 5;
		}
		if(y == 5) {
			if(x >= 3) return false;
			if(x == 0) x = 4;
			else if(x == 1) x = 5;
			else if(x == 2) x = 3;
			y = 0;
		}
		else if(y == 6) {
			if(x < 3) {
				x += 1;
				y = 1;
			}
			else if(x == 3) return true;
			else if(x == 4) {
				x = 3;
				y = 0;
			}
			else if(x == 5) return false;
		}
		else if(y >= 7) {
			if(x < 3) {
				x += 1;
				y %= 5;
			}
			else if(x == 3 || x == 5) return true;
			else if(x == 4) {
				x = 3;
				y %= 6;
			}
		}
		
		return false;
	}
}