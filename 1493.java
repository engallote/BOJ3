import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static long res;
	static boolean flag;
	static int[] cube;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long l = Long.parseLong(st.nextToken());
		long w = Long.parseLong(st.nextToken());
		long h = Long.parseLong(st.nextToken());
		N = Integer.parseInt(br.readLine());
		cube = new int[21];
		flag = false;
		res = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			cube[a] = b;
		}
		
		res = solve(l, w, h);
		
		if(!flag) res = -1;
		bw.write(res+"");
		bw.flush();
	}
	private static long solve(long l, long w, long h) {
		if(l == 0 || w == 0 || h == 0) return 0l;
		
		flag = false;
		long len = 0;
		
		for(int i = 19; i >= 0; i--) {
			if(cube[i] == 0) continue;
			
			len = (long)Math.pow(2, i);
			if(l < len || w < len || h < len) continue;
			cube[i] -= 1;
			flag = true;
			return solve(l - len, w, len) + solve(len, w - len, len) + solve(l, w, h - len) + 1; 
		}
		
		return -1;
	}
}