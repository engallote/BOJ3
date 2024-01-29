import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dx = {2, 0, -2, 0}, dy = {0, 2, 0, -2};
		
		HashSet<String> hs = new HashSet<>(), chk = new HashSet<>();
		int res = 0;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			hs.add(x + " " + y);
		}
		
		Iterator<String> it = hs.iterator();
		while(it.hasNext()) {
			String[] key = it.next().split(" ");
			int x = Integer.parseInt(key[0]), y = Integer.parseInt(key[1]);
			
			for(int j = 0; j < 4; j++) {
				int nx = x + dx[j], ny = y + dy[j];
				if(nx < 1 || ny < 1 || nx > N || ny > N) continue;
				
				if(hs.contains(nx + " " + ny) || chk.contains(nx + " " + ny)) continue;
				chk.add(nx + " " + ny);
				res += 1;
			}
		}
		
		bw.write(res + "");
		bw.flush();
	}
}