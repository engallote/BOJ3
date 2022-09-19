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
    	StringTokenizer stn = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(stn.nextToken());
    	int W = Integer.parseInt(stn.nextToken());
    	ArrayList<Integer> t = new ArrayList<>(), f = new ArrayList<>();
    	
    	for(int i = 0; i < N; i++) {
    		stn = new StringTokenizer(br.readLine());
    		int w = Integer.parseInt(stn.nextToken());
    		int s = Integer.parseInt(stn.nextToken());
    		
    		if(w == 3) t.add(s);
    		else f.add(s);
    	}
    	
    	if(!t.isEmpty()) {
    		Collections.sort(t, new Comparator<Integer>() {
    			@Override
    			public int compare(Integer o1, Integer o2) {
    				return Integer.compare(o2, o1);
    			}
        	});
    	}
    	if(!f.isEmpty()) {
    		Collections.sort(f, new Comparator<Integer>() {
    			@Override
    			public int compare(Integer o1, Integer o2) {
    				return Integer.compare(o2, o1);
    			}
        	});
    	}
    	
    	long[] st = new long[t.size() + 1], sf = new long[f.size() + 1];
    	for(int i = 0; i < t.size(); i++) st[i + 1] = t.get(i) + st[i];
    	for(int i = 0; i < f.size(); i++) sf[i + 1] = f.get(i) + sf[i];
    	    	
    	int tIdx = W / 3 > t.size() ? t.size() : W / 3;
    	long res = 0;
    	while(tIdx >= 0) {
    		long sum = st[tIdx];
    		int tmp = W - tIdx * 3;
    		sum += sf[tmp / 5 > f.size() ? f.size() : tmp / 5];
    		res = Math.max(res, sum);
    		--tIdx;
    	}
    	
    	bw.write(res + "");
    	bw.flush();
	}
}