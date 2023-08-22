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
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int od = Integer.parseInt(st.nextToken());
			
			if(od == 1) {
				int x = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				hm.put(w, x);
			}
			else {
				int w = Integer.parseInt(st.nextToken());
				bw.write(hm.get(w) + "\n");
			}
		}
		
		bw.flush();
	}
}