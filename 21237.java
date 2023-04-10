import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(--T >= 0) {
			char[] ch = sc.next().toCharArray();
			
			char pre = '.';
			int a = 0, b = 0;
			for(char c : ch) {
				if(pre == 'E') {
					if(c == 'N') a += 1;
					else if(c == 'S') b += 1;
				}
				else if(pre == 'W') {
					if(c == 'N') b += 1;
					else if(c == 'S') a += 1;
				}
				else if(pre == 'N') {
					if(c == 'W') a += 1;
					else if(c == 'E') b += 1;
				}
				else {
					if(c == 'W') b += 1;
					else if(c == 'E') a += 1;
				}
				pre = c;
			}
			
			System.out.println(b - a >= 0 ? "CW" : "CCW");
		}
	}
}