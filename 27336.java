import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[][] arr = new int[4][N];
    	
    	StringTokenizer st;
    	for(int i = 0; i < 4; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
    		Arrays.sort(arr[i]);
    	}
    	
    	int l = 0, r = Integer.MAX_VALUE, mid, res = Integer.MAX_VALUE;
    	while(l <= r) {
    		mid = (l + r) / 2;
    		int ret = Integer.MAX_VALUE;
    		
    		int a = 0, b = 0, c = 0, d = 0;
    		while(a < N && b < N && c < N && d < N) {
    			int aa = arr[0][a], bb = arr[1][b], cc = arr[2][c], dd = arr[3][d];
    			int min = Math.min(aa, Math.min(bb, Math.min(cc, dd)));
    			int max = Math.max(aa, Math.max(bb, Math.max(cc, dd)));
    			PriorityQueue<Integer> pq = new PriorityQueue<>();
    			pq.offer(aa);
    			pq.offer(bb);
    			pq.offer(cc);
    			pq.offer(dd);
    			
    			if(max - min <= mid)  ret = Math.min(ret, max - min);
    			
    			if(a == N - 1 && b == N - 1 && c == N - 1 && d == N - 1) break;
    			
    			while(!pq.isEmpty()) {
					int x = pq.poll();
					
					if(x == aa && a + 1 < N) {
						++a;
						break;
					}
					if(x == bb && b + 1 < N) {
						++b;
						break;
					}
					if(x == cc && c + 1 < N) {
						++c;
						break;
					}
					if(x == dd && d + 1 < N) {
						++d;
						break;
					}
				}
    		}
    		
    		if(ret < res) {
    			res = ret;
    			r = mid - 1;
    		}
    		else break;
    	}
    	
    	System.out.println(res);
	}
}