import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double[][] arr = new double[N][2];
		
		for(int i = 0; i < N; i++) {
			arr[i][0] = sc.nextDouble();
			arr[i][1] = sc.nextDouble();
		}
		
		double a = 0, b = 0;
		for(int i = 1; i < N; i++) {
			a += arr[i - 1][0] * arr[i][1];
			b += arr[i - 1][1] * arr[i][0];
		}
		
		a += arr[N - 1][0] * arr[0][1];
		b += arr[N - 1][1] * arr[0][0];
		
		double res = (a - b) / 2.0;
		
		if(res < 0) res *= -1;
		System.out.printf("%.1f", res);
	}
}