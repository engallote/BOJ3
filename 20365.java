import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] ch = sc.next().toCharArray();
		
		int b = 0, r = 0;
		char pre = ch[0];
		for(int i = 1; i < N; i++) {
			if(pre == ch[i]) continue;
			else {
				if(pre == 'B') b += 1;
				else r += 1;
			}
			
			pre = ch[i];
		}
		
		if(pre == 'B') b += 1;
		else r += 1;
		
		int bbr = r + 1, brb = b + 1;
		
		System.out.println(Math.min(bbr, Math.min(brb, b + r)));
	}
}