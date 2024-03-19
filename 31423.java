import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static String[] arr;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new String[N + 1];
		int[] next = new int[N + 1], next2 = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			arr[i] = br.readLine().trim();
			next2[i] = i;
			next[i] = i;
		}
		
		StringTokenizer st;
		int idx = 0;
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			next[next2[a]] = b;
			next2[a] = next2[b];
			idx = a;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(arr[idx]);
			idx = next[idx];
		}
		
		System.out.println(sb.toString());
	}
}
class Pair {
	int a, b;
	Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
}