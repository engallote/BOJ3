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
		StringBuilder sb = new StringBuilder();
		int res = 0;
		if(N % 3 <= 1) {
			sb.append("1 3 2 4 ");
			
			res = 3;
			int num = 4, cnt = 1;
			while(true) {
				if(cnt < 2) {
					if(num + 2 > N) num = 1;
					else num += 2;
					cnt += 1;
				}
				else {
					cnt = 0;
					num -= 1;
				}
				++res;
				sb.append(num + " ");
				if(num == 1) break;
			}
		}
		else {
			sb.append("1 2 4 3 ");
			
			res = 3;
			int num = 3, cnt = 0;
			while(true) {
				if(cnt < 2) {
					if(num + 2 > N) num = 1;
					else num += 2;
					cnt += 1;
				}
				else {
					cnt = 0;
					num -= 1;
				}
				++res;
				sb.append(num + " ");
				if(num == 1) break;
			}
		}
		
		
		
		bw.write(res+"\n");
		bw.write(sb.toString());
		bw.flush();
	}
}