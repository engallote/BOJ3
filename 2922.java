import java.util.*;

public class Main {
	static long res = 0;
	static char[] ch;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ch = sc.next().toCharArray();
		
		solve(0, 0, 0, 0, 1l);
		
		System.out.println(res);
	}
	private static void solve(int idx, int mo, int za, int l, long sum) {
		if(mo == 3 || za == 3) return;
		if(idx == ch.length) {
			if(l > 0) res += sum;
			return;
		}
		
		if(ch[idx] == '_') {
			if(mo < 2) {
				solve(idx + 1, mo + 1, 0, l, sum * 5l);
			}
			if(za < 2) {
				//L인 경우
				solve(idx + 1, 0, za + 1, 1, sum);
				//L이 아닌 경우
				solve(idx + 1, 0, za + 1, l, sum * 20l);
			}
		}
		else if(ch[idx] == 'A' || ch[idx] == 'E' || ch[idx] == 'I' || ch[idx] == 'O' || ch[idx] == 'U') {
			solve(idx + 1, mo + 1, 0, l, sum);
		}
		else {
			if(ch[idx] == 'L') solve(idx + 1, 0, za + 1, 1, sum);
			else solve(idx + 1, 0, za + 1, l, sum);
		}
	}
}