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
		int N = Integer.parseInt(br.readLine());
		long[] arr1 = new long[N], arr2 = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr1[i] = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr2[i] = Long.parseLong(st.nextToken());
		
		int L = 0, R = 0;
		long res = Long.MIN_VALUE, sum;
		for(int l = 0; l < N; l++)
			for(int r = 0; r < N; r++) {
				if(l + r >= N) break;
				sum = 0;
				
				for(int i = l, j = N - r - 1; i < N - r; i++, j--)
					sum += arr1[i] * arr2[j];
				
				if(res < sum) {
					res = sum;
					L = l;
					R = r;
				}
			}
		
		bw.write(L + " " + R + "\n");
		bw.write(res + "");
		bw.flush();
	}
}