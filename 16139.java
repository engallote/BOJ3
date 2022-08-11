import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] ch = br.readLine().trim().toCharArray();
		
		int[][] sum = new int[ch.length][26];
		
		for(int i = 0; i < ch.length; i++) {
			if(i > 0) for(int j = 0; j < 26; j++) sum[i][j] = sum[i - 1][j];
			sum[i][ch[i] - 'a'] += 1;
		}
		
		int Q = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(--Q >= 0) {
			st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			int res = sum[r][c-'a'];
			if(l != 0) res -= sum[l - 1][c - 'a'];
			bw.write(res + "\n");
		}
		bw.flush();
	}
}