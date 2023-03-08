import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] chk = new boolean[1000001];
		chk[0] = chk[1] = true;
		
		for(int i = 2; i * i <= 1000000; i++) {
			if(chk[i]) continue;			
			for(int j = i * i; j <= 1000000; j+=i) chk[j] = true;
		}
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			int a = 0, b = 0;
			for(int i = 3; i <= N; i+=2) {
				if(!chk[i] && !chk[N - i]) {
					a = i;
					b = N - i;
					break;
				}
			}
			
			if(a == 0) bw.write("Goldbach's conjecture is wrong.\n");
			else bw.write(N + " = " + Math.min(a, b) + " + " + Math.max(a, b) + "\n");
		}
		
		bw.flush();
	}
}