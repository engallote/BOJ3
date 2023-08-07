import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();
		int F = sc.nextInt();
		int C = sc.nextInt();
		int[] point = new int[F];
		
		for(int i = 0; i < F; i++) point[i] = sc.nextInt();
		
		Arrays.sort(point);
		int[][] path = new int[P + 1][P + 1];
		
		for(int i = 1; i <= P; i++) {
			Arrays.fill(path[i], 1000000000);
			path[i][i] = 0;
		}
		
		for(int i = 0; i < C; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int t = sc.nextInt();
			path[a][b] = t;
			path[b][a] = t;
		}
		
		for(int k = 1; k <= P; k++)
			for(int i = 1; i <= P; i++)
				for(int j = 1; j <= P; j++)
					if(path[i][k] + path[k][j] < path[i][j])
						path[i][j] = path[i][k] + path[k][j];
		
		int idx = 0;
		double avg = 0.0, res = Double.MAX_VALUE;
		for(int i = 1; i <= P; i++) {
			avg = 0.0;
			for(int j = 0; j < F; j++) avg += path[i][point[j]];
			
			avg /= (double)F;
			
			System.out.println(i + " >> " + avg);
			if(avg < res) {
				res = avg;
				idx = i;
			}
		}
		
		System.out.println(idx);
	}
}