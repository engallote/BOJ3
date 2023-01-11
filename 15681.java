import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, R;
	static int[] dep;
	static ArrayList<Integer>[] aly;
	static boolean[] chk;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	R = Integer.parseInt(st.nextToken());
    	int Q = Integer.parseInt(st.nextToken());
    	aly = new ArrayList[N + 1];
    	dep = new int[N + 1];
    	chk = new boolean[N + 1];
    	
    	for(int i = 1; i <= N; i++) aly[i] = new ArrayList<>();
    	
    	for(int i = 0; i < N - 1; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		aly[a].add(b);
    		aly[b].add(a);
    	}
    	
    	dfs(R);
    	
    	while(--Q >= 0) {
    		int U = Integer.parseInt(br.readLine());
    		
    		bw.write(dep[U] + "\n");
    	}
    	
    	bw.flush();
	}
	private static int dfs(int x) {
		if(chk[x]) return 0;
		chk[x] = true;
		dep[x] += 1;
		
		for(int next : aly[x])
			if(!chk[next]) dep[x] += dfs(next);
		
		return dep[x];
	}
}