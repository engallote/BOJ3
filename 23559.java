import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int N = sc.nextInt();
		int X = sc.nextInt();
		Pair[] arr = new Pair[N];
		int sum = 0, mon = 0;
		
		for(int i = 0; i < N; i++) {
			arr[i] = new Pair(sc.nextInt(), sc.nextInt());
			sum += arr[i].b;
			mon += 1000;
		}
		
		Arrays.sort(arr);
		
		if(X >= 5000 * N) {
			int res = 0;
			for(int i = 0; i < N; i++)
				res += Math.max(arr[i].a, arr[i].b);
			
			System.out.println(res);
		}
		else {
			for(int i = 0; i < N; i++) {
				if(arr[i].a > arr[i].b && mon + 4000 <= X) {
					mon += 4000;
					sum += arr[i].a - arr[i].b;
				}
			}
			
			System.out.println(sum);
		}
	}
}
class Pair implements Comparable<Pair> {
	int a, b;
	Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
	@Override
	public int compareTo(Pair o) {
		if(Math.abs(o.a - o.b) > Math.abs(this.a - this.b)) return 1;
		else if(Math.abs(o.a - o.b) == Math.abs(this.a - this.b)) return 0;
		else return -1;
	}
}