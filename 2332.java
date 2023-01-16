import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static BufferedWriter bw;
	static boolean[][] chk;
	static String[] str;
	static char[] number, num;
	static ArrayList<Integer>[] aly;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	number = br.readLine().trim().toCharArray();
    	N = Integer.parseInt(br.readLine());
    	chk = new boolean[101][N];
    	aly = new ArrayList[10];
    	str = new String[N];
    	num = new char['z' + 1];
    	
    	for(int i = 0; i < 10; i++) aly[i] = new ArrayList<>();
    	for(int i = 0; i < N; i++) {
    		str[i] = br.readLine().trim();
    		char c = str[i].charAt(0);
    		int idx = 0;
    		if(c == 'o' || c == 'q' || c == 'z') idx = 0;
    		else if(c == 'i' || c == 'j') idx = 1;
    		else if(c == 'a' || c == 'b' || c == 'c') idx = 2;
    		else if(c == 'd' || c == 'e' || c == 'f') idx = 3;
    		else if(c == 'g' || c == 'h') idx = 4;
    		else if(c == 'k' || c == 'l') idx = 5;
    		else if(c == 'm' || c == 'n') idx = 6;
    		else if(c == 'p' || c == 'r' || c == 's') idx = 7;
    		else if(c == 't' || c == 'u' || c == 'v') idx = 8;
    		else idx = 9;
    		aly[idx].add(i);
    	}
    	
    	num['o'] = 0;
    	num['q'] = 0;
    	num['z'] = 0;
    	
    	num['i'] = 1;
    	num['j'] = 1;
    	
    	num['a'] = 2;
    	num['b'] = 2;
    	num['c'] = 2;
    	
    	num['d'] = 3;
    	num['e'] = 3;
    	num['f'] = 3;
    	
    	num['g'] = 4;
    	num['h'] = 4;
    	
    	num['k'] = 5;
    	num['l'] = 5;
    	
    	num['m'] = 6;
    	num['n'] = 6;
    	
    	num['p'] = 7;
    	num['r'] = 7;
    	num['s'] = 7;
    	
    	num['t'] = 8;
    	num['u'] = 8;
    	num['v'] = 8;
    	
    	num['x'] = 9;
    	num['y'] = 9;
    	num['w'] = 9;
    	
    	solve();
    	
    	bw.flush();
	}
	private static void solve() throws IOException {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(0, ""));
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(p.idx >= number.length) {
					//정답 출력
					String[] arr = p.path.split(",");
					
					bw.write((arr.length - 1) + "\n");
					
					for(int i = 1; i < arr.length; i++)
						bw.write(str[Integer.parseInt(arr[i])] + "\n");
					
					return;
				}
				
				if(aly[number[p.idx] - '0'].isEmpty()) continue;
				
				for(int next : aly[number[p.idx] - '0']) {
					if(str[next].length() + p.idx > number.length || chk[p.idx][next]) continue;
					String s = str[next];
					int l = 0, r = s.length() - 1;
					while(l <= r) {
						if(num[s.charAt(l)] != number[p.idx + l] - '0') break;
						if(num[s.charAt(r)] != number[p.idx + r] - '0') break;
						l += 1;
						r -= 1;
					}
					
					if(l > r) {
						chk[p.idx][next] = true;
						q.offer(new Pair(p.idx + s.length(), p.path + "," + next));
					}
				}
			}
		}
		
		bw.write("0\nNo solution.");
	}
}
class Pair {
	int idx;
	String path;
	Pair(int idx, String path) {
		this.idx = idx;
		this.path = path;
	}
}