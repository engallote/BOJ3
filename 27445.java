import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	arr = new int[N + M - 1];
    	
    	for(int i = 0; i < N + M - 1; i++) arr[i] = sc.nextInt();
    	
    	int x = 0, y = 0, idx = 0;
    	int num = arr[0];
    	boolean flag = false;
		
		for(int i = 0; i < N; i++) {
			int nx = i;
			int ny = num - x;
			
			flag = true;
			x = 0;
			y = 0;
			idx = 0;
			while(idx < N + M - 1) {
				int dist = Math.abs(x - nx) + Math.abs(y - ny);
				if(dist != arr[idx]) {
					flag = false;
					break;
				}
				if(x + 1 < N) x += 1;
				else y += 1;
				++idx;
			}
			
			if(flag) {
				System.out.println((nx + 1) + " " + (ny + 1));
				break;
			}
		}
	}
}