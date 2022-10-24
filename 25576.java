import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int[][] arr = new int[N][M];
    	int res = 0, sum = 0;
    	
    	st = new StringTokenizer(br.readLine());
		for(int j = 0; j < M; j++) arr[0][j] = Integer.parseInt(st.nextToken());
    	
    	for(int i = 1; i < N; i++) {
    		sum = 0;
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < M; j++) sum += Math.abs(arr[0][j] - Integer.parseInt(st.nextToken()));
    		
    		if(sum > 2000) ++res;
    	}
    	
    	
    	System.out.println(res >= N / 2 ? "YES" : "NO");
	}
}