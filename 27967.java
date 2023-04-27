import java.util.*;

public class Main {
	static int N;
	static char[] ch;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ch = sc.next().toCharArray();
		flag = false;
		
		int g = 0;
		for(int i = 0; i < N; i++)
			if(ch[i] == 'G') g += 1;
		
		ArrayList<Character> path = new ArrayList<>();
		find(0, g, path);
	}
	private static void find(int cnt, int g, ArrayList<Character> path) {
		if(flag) return;
		if(cnt == g) {
			int idx = 0;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < N; i++) {
				if(ch[i] == 'G') {
					sb.append(path.get(idx));
					idx += 1;
				}
				else sb.append(ch[i]);
			}
			
			if(check(sb)) {
				flag = true;
				System.out.println(sb);
			}
			return;
		}
		
		path.add('(');
		find(cnt + 1, g, path);
		path.remove(path.size() - 1);
		path.add(')');
		find(cnt + 1, g, path);
		path.remove(path.size() - 1);
	}
	private static boolean check(StringBuilder sb) {
		char[] c = sb.toString().toCharArray();
		int left = 0;
		
		for(int i = 0; i < N; i++) {
			if(c[i] == '(') left += 1;
			else {
				if(left == 0) return false;
				left -= 1;
			}
		}
		
		if(left > 0) return false;		
		return true;
	}
}