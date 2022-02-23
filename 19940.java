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
		int T = Integer.parseInt(br.readLine());
		
		while(--T >= 0) {
			int N = Integer.parseInt(br.readLine());
			int ah = 0, at = 0, mt = 0, ao = 0, mo = 0;
			
			ah = N / 60;
			N %= 60;
			
			if(N > 35) {
				ah += 1;
				N = 60 - N;
				mt = N / 10;
				N %= 10;
				
				if(N > 5) {
					mt += 1;
					ao += 10 - N % 10;
				}
				else mo = N;
			}
			else {
				at = N / 10;
				N %= 10;
				if(N > 5) {
					at += 1;
					N = 10 - N % 10;
					mo = N;
				}
				else ao = N % 10;
			}
			
			bw.write(ah + " " + at + " " + mt + " " + ao + " " + mo + "\n");
		}
		bw.flush();
	}
}