import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static ArrayList<Long> aly = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		
		for(long i = 0;; i++) {
			if(i * i > 999999999l) break;
			aly.add(i * i);
		}
		
		for(int i = 0; i < N; i++) map[i] = sc.next().toCharArray();
		
		long res = -1;
		for(int k = 0; k < Math.max(N, M); k++)
			for(int l = 0; l < Math.max(N, M); l++) {
				for(int i = 0; i < N; i++)
					for(int j = 0; j < M; j++)
						res = Math.max(res, findNum(i, j, k, l));
			}
		
		System.out.println(res);
	}
	private static long findNum(int x, int y, int r, int c) {
		long ret = -1;
		StringBuilder sb = new StringBuilder();
		long num = 0;
		
		if(r == 0 && c == 0) {
			num = (long)(map[x][y] - '0');
			if(aly.contains(num)) ret = Math.max(ret, num);
			
			return ret;
		}
		
		for(int i = x, j = y; i < N && j < M; i+=r, j+=c) {
			sb.append(map[i][j]);
			num = Long.parseLong(sb.toString());
			
			if(aly.contains(num)) ret = Math.max(ret, num);
			sb.reverse();
			num = Long.parseLong(sb.toString());
			
			if(aly.contains(num)) ret = Math.max(ret, num);
			sb.reverse();
		}
		
		sb = new StringBuilder();
		for(int i = x, j = y; i >= 0 && j >= 0; i-=r, j-=c) {
			sb.append(map[i][j]);
			num = Long.parseLong(sb.toString());
			
			if(aly.contains(num)) ret = Math.max(ret, num);
			sb.reverse();
			num = Long.parseLong(sb.toString());
			
			if(aly.contains(num)) ret = Math.max(ret, num);
			sb.reverse();
		}
		
		sb = new StringBuilder();
		for(int i = x, j = y; i < N && j >= 0; i+=r, j-=c) {
			sb.append(map[i][j]);
			num = Long.parseLong(sb.toString());
			
			if(aly.contains(num)) ret = Math.max(ret, num);
			sb.reverse();
			num = Long.parseLong(sb.toString());
			
			if(aly.contains(num)) ret = Math.max(ret, num);
			sb.reverse();
		}
		
		sb = new StringBuilder();
		for(int i = x, j = y; i >= 0 && j < M; i-=r, j+=c) {
			sb.append(map[i][j]);
			num = Long.parseLong(sb.toString());
			
			if(aly.contains(num)) ret = Math.max(ret, num);
			sb.reverse();
			num = Long.parseLong(sb.toString());
			
			if(aly.contains(num)) ret = Math.max(ret, num);
			sb.reverse();
		}
		
		return ret;
	}
}