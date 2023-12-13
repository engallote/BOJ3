import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N + 1][2];
		
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			char b = sc.next().charAt(0);
			int c = sc.nextInt();
			
			if(c == 1) {
				if(b == 'P') arr[a][0] = 1;
				else arr[a][1] = 1;
			}
			else {
				if(b == 'P') arr[a][0] = -1;
				else arr[a][1] = -1;
			}
		}
		
		int min = 0, max = 0;
		for(int i = 1; i <= N; i++) {
			if(arr[i][0] == -1) continue;
			if(arr[i][0] == 1 && arr[i][1] == -1) {
				min += 1;
				max += 1;
			}
			else if(arr[i][0] <= 1 && arr[i][1] <= 0) max += 1;
		}
		
		System.out.println(min + " " + max);
	}
}