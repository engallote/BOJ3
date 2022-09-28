import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	HashMap<String, Integer> hm = new HashMap<>();
    	int[] time = {4, 6, 4, 10};
    	
    	StringTokenizer st;
    	for(int i = 0; i < N; i++) {
    		for(int k = 0; k < 4; k++) {//аж
    			st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < 7; j++) {
        			String s = st.nextToken();
        			if(s.equals("-")) continue;
        			if(hm.containsKey(s)) hm.replace(s, hm.get(s) + time[k]);
        			else hm.put(s, time[k]);
        		}
    		}
    	}
    	
    	int min = Integer.MAX_VALUE, max = 0;
    	for(String key : hm.keySet()) {
    		min = Math.min(min, hm.get(key));
    		max = Math.max(max, hm.get(key));
    	}
    	
    	if(max - min > 12) System.out.println("No");
    	else System.out.println("Yes");
	}
}