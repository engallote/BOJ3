import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hm1 = new HashMap<>(), hm2 = new HashMap<>();
		int res = 0;
		for(int i = 0; i < N; i++) {
			String str = br.readLine().trim();
			if(hm1.containsKey(str)) hm1.replace(str, hm1.get(str) + 1);
			else hm1.put(str, 1);
		}
		for(int i = 0; i < N; i++) {
			String str = br.readLine().trim();
			if(hm2.containsKey(str)) hm2.replace(str, hm2.get(str) + 1);
			else hm2.put(str, 1);
		}
		
		Iterator<String> it = hm1.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			int v = hm1.get(key);
			if(hm2.containsKey(key)) res += Math.min(v, hm2.get(key));
		}
		
		
		System.out.println(res);
	}
}