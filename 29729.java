import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int size = S, idx = 0;
		for(int i = 0; i < N + M; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 1) {
				if(idx == size) size *= 2;
				idx += 1;
			}
			else {
				idx -= 1;
			}
		}
		
		bw.write(size+"");
		bw.flush();
	}
}