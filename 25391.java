import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	Pair[] arr = new Pair[N];
    	boolean[] chk = new boolean[N];
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		arr[i] = new Pair(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    	}
    	
    	Arrays.sort(arr, new sortB());
    	
    	long res = 0;
    	for(int i = 0; i < K; i++) {
    		chk[arr[i].idx] = true;
    		res += (long)arr[i].a;
    	}
    	
    	Arrays.sort(arr, new sortA());
    	
    	int cnt = 0;
    	for(int i = 0; i < N && cnt < M; i++) {
    		if(chk[arr[i].idx]) continue;
    		res += (long)arr[i].a;
    		++cnt;
    	}
    	
    	bw.write(res+"");
    	bw.flush();
	}
}
class Pair{
	int idx, a, b;
	Pair(int idx, int a, int b) {
		this.idx = idx;
		this.a = a;
		this.b = b;
	}
}
class sortB implements Comparator<Pair> {

	@Override
	public int compare(Pair o1, Pair o2) {
		if(o1.b < o2.b) return 1;
		else return -1;
	}
}
class sortA implements Comparator<Pair> {

	@Override
	public int compare(Pair o1, Pair o2) {
		if(o1.a < o2.a) return 1;
		else return -1;
	}
}