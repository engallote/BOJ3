import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] map = new String[10][10];
		
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++) map[i][j] = sc.next();
		
		for(int i = 0; i < 10; i++) {
			String str = map[i][0];
			int cnt = 1;
			
			//row
			for(int j = 1; j < 10; j++, cnt++)
				if(!map[i][j].equals(str)) break;
			
			if(cnt >= 10) {
				System.out.println(1);
				return;
			}
			
			//col
			str = map[0][i];
			cnt = 1;
			for(int j = 1; j < 10; j++, cnt++)
				if(!map[j][i].equals(str)) break;
			
			if(cnt >= 10) {
				System.out.println(1);
				return;
			}
		}
		
		System.out.println(0);
	}
}