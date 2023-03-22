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
		int N = Integer.parseInt(br.readLine());
		
		if(N == 1) {
			int num = Integer.parseInt(br.readLine());
			if(num % 7 == 0) bw.write(1);
			else bw.write(0);
			bw.flush();
		}
		
		int[] chk = new int[7];
		Arrays.fill(chk, -1);
		
		int sum = 0, res = 0;
		for(int i = 0; i < N; i++) {
			sum += Integer.parseInt(br.readLine());
			sum %= 7;
			if(chk[sum] == -1) chk[sum] = i;
			else {
//				System.out.println(chk[sum] + " ~ " + i);
				res = Math.max(res, i - chk[sum]);
			}
		}
		
		if(sum == 0) res = N;
		bw.write(res+"");
		bw.flush();
	}
}