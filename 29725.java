import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] map = new char[8][8];
		
		int a = 0, b = 0;
		for(int i = 0; i < 8; i++) {
			map[i] = sc.next().toCharArray();
			for(int j = 0; j < 8; j++) {
				if(map[i][j] == '.') continue;
				if('A' <= map[i][j] && map[i][j] <= 'Z') a += score(map[i][j]);
				else b += score(map[i][j]);
			}
		}
		
		System.out.println(a-b);
	}

	private static int score(char c) {
		if(c == 'K' || c == 'k') return 0;
		else if(c == 'p' || c == 'P') return 1;
		else if(c == 'N' || c == 'n') return 3;
		else if(c == 'B' || c == 'b') return 3;
		else if(c == 'R' || c == 'r') return 5;
		else return 9;
	}
}