import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		if(N == 1) {
			if(arr[0] == 0) System.out.println(1);
			else System.out.println(arr[0]);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			if(arr[i] == 0) {
				if(i == 0) {
					if(arr[i + 1] != 0) {
						if(arr[i + 1] != 1) arr[i] = 1;
						else if(arr[i + 1] != 2) arr[i] = 2;
						else if(arr[i + 1] != 3) arr[i] = 3;
					}
					else arr[i] = 1;
				}
				else if(0 < i && i + 1 < N) {
					if(arr[i + 1] != 0) {
						if(arr[i - 1] != 1 && arr[i + 1] != 1) arr[i] = 1;
						else if(arr[i - 1] != 2 && arr[i + 1] != 2) arr[i] = 2;
						else if(arr[i - 1] != 3 && arr[i + 1] != 3) arr[i] = 3;
					}
					else {
						if(arr[i - 1] != 1) arr[i] = 1;
						else if(arr[i - 1] != 2) arr[i] = 2;
						else if(arr[i - 1] != 3) arr[i] = 3;
					}
				}
				else if(i == N - 1) {
					if(arr[i - 1] != 1) arr[i] = 1;
					else if(arr[i - 1] != 2) arr[i] = 2;
					else if(arr[i - 1] != 3) arr[i] = 3;
				}
			}
			else {
				if(i - 1 >= 0 && arr[i - 1] == arr[i]) {
					System.out.println(-1);
					return;
				}
				if(i + 1 < N && arr[i + 1] == arr[i]) {
					System.out.println(-1);
					return;
				}
			}
			sb.append(arr[i] + " ");
		}
		
		System.out.println(sb.toString());
	}
}