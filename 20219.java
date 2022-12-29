import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] hate;
	static boolean[] chk;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	hate = new ArrayList[N + 1];
    	chk = new boolean[N + 1];
    	
    	for(int i = 1; i <= N; i++) hate[i] = new ArrayList<>();
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		hate[a].add(b);
    		hate[b].add(a);
    	}
    	
    	int res = 0;
    	for(int i = 1; i <= N; i++) {
    		if(chk[i]) continue;
    		for(int j = i + 1; j <= N; j++) {
    			if(hate[i].contains(j) || chk[j]) continue;
    			chk[i] = chk[j] = true;
    			++res;
    			break;
    		}
    	}
    	
    	bw.write(res+"");
    	bw.flush();
	}
}