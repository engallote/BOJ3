import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][5];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}

		int day1 = 0, day2 = 0, max = -1;
		for(int i = 0; i < 5; i++)
			for(int j = i + 1; j < 5; j++) {
				
				int sum = 0;
				for(int k = 0; k < N; k++)
					if(arr[k][i] == 1 && arr[k][j] == 1) ++sum;
				
				if(max < sum) {
					max = sum;
					day1 = i;
					day2 = j;
				}
			}
		
		System.out.println(max);
		for(int i = 0; i < 5; i++) {
			if(i == day1 || i == day2) System.out.print("1 ");
			else System.out.print("0 ");
		}
	}
}