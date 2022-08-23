import java.util.*;

public class Main {
	static boolean flag;
	static char[] ch;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ch = sc.next().toCharArray();
		chk = new boolean[100];
		
		if(ch.length < 10) {
			for(char c : ch) System.out.print(c + " ");
			return;
		}
		
		ArrayList<Integer> path = new ArrayList<>();
		flag = false;
		
		for(int i = 10; i <= 50; i++) {
			solve(i, 0, 0, path);
			if(flag) return;
		}
	}
	private static void solve(int N, int idx, int l, ArrayList<Integer> path) {
		if(flag) return;
		if(idx == ch.length) {
			if(l != N) return;
			for(int i : path) System.out.print(i + " ");
			flag = true;
			return;
		}
		
		if(!chk[ch[idx] - '0']) {
			chk[ch[idx] - '0'] = true;
			path.add(ch[idx] - '0');
			solve(N, idx + 1, l + 1, path);
			path.remove(path.size() - 1);
			chk[ch[idx] - '0'] = false;
		}
		if(idx + 1 < ch.length) {
			int tmp = Integer.parseInt(ch[idx] + "" + ch[idx + 1]);
			if(tmp <= N && !chk[tmp]) {
				chk[tmp] = true;
				path.add(tmp);
				solve(N, idx + 2, l + 1, path);
				path.remove(path.size() - 1);
				chk[tmp] = false;
			}
		}
	}
}