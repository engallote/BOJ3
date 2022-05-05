import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int K;
	static TreeMap<Integer, Integer> tm;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		tm = new TreeMap<>();
		tm.put(-100, -1);
		tm.put(1000000100, -1);
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			tm.put(key, val);
		}
		
		while(--M >= 0) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			
			if(order == 1) {
				int key = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				tm.put(key, val);
			}
			else if(order == 2) {
				int k= Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				update(k, val);
			}
			else {
				int k = Integer.parseInt(st.nextToken());
				
				int res = find(k);
				if(res == -2) bw.write("?");
				else bw.write(res+"");
				bw.newLine();
			}
		}
		bw.flush();
	}
	private static int find(int key) {
		int l = tm.floorKey(key), r = tm.ceilingKey(key);
		
		if(tm.get(l) == tm.get(r)) return tm.get(key);
		else if(r - key < key - l && r - key <= K) return tm.get(r);
		else if(r - key > key - l && key - l <= K) return tm.get(l);
		else if(r - key == key - l && r - key <= K) return -2;
		else return -1;
	}
	private static void update(int key, int val) {
		int l = tm.floorKey(key), r = tm.ceilingKey(key);
		
		if(tm.get(l) == tm.get(r)) tm.put(key, val);
		else if(r - key < key - l && r - key <= K) tm.put(r, val);
		else if(r - key > key - l && key - l <= K) tm.put(l, val);
	}
}