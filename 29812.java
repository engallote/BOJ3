import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		char[] ch = sc.next().toCharArray();
		
		int D = sc.nextInt();
		int M = sc.nextInt();
		
		int h = 0, y = 0, u = 0;
		for(int i = 0; i < S; i++) {
			if(ch[i] == 'H') h += 1;
			else if(ch[i] == 'Y') y += 1;
			else if(ch[i] == 'U') u += 1;
		}
		
		int max = Math.min(y, Math.min(h, u));
		int res = 0, cnt = 0;
		
		for(int i = 0; i < S; i++) {
			if(ch[i] == 'H' || ch[i] == 'Y' || ch[i] == 'U') {
				if(cnt * D > D + M) res += D + M;
				else res += cnt * D;
				
				cnt = 0;
			}
			else cnt += 1;
		}
		
		if(cnt > 0) {
			if(cnt * D > D + M) res += D + M;
			else res += cnt * D;
		}
		
		if(res == 0) System.out.println("Nalmeok");
		else System.out.println(res);
		System.out.println(max == 0 ? "I love HanYang University" : max);
	}
}