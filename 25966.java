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
		int Q = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		while(--Q >= 0) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			
			if(order == 0) {
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				arr[i][j] = k;
				
			}
			else {
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				int[] tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				bw.write(arr[i][j] + " ");
			bw.newLine();
		}
		bw.flush();
	}
}