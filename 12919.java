import java.util.*;

public class Main {
	static char[] a, b;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.next().toCharArray();
		b = sc.next().toCharArray();
		
		int res = solve(new String(b));
		System.out.println(res);
	}
	private static int solve(String str) {
		if(str.length() == a.length) {
			if(str.equals(new String(a))) return 1;
			else return 0;
		}
		if(str.length() < a.length) return 0;
		int ret = 0;
		
		char s = str.charAt(0), e = str.charAt(str.length() - 1);
		if(s == 'B') {
			if(e == 'A') ret = Math.max(ret, solve(str.substring(0, str.length() - 1)));
			StringBuilder sb = new StringBuilder();
			sb.append(str);
			sb.reverse();
			String tmp = sb.toString().substring(0, sb.length() - 1);
			
			ret = Math.max(ret, solve(tmp));
		}
		else {
			if(e == 'A') ret = Math.max(ret, solve(str.substring(0, str.length() - 1)));
			else return 0;
		}
		
		return ret;
	}
}