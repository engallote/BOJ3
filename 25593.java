import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	HashMap<String, Integer> hm = new HashMap<>();
    	String[] str;
    	
    	sc.nextLine();
    	for(int i = 0; i < N; i++) {
    		str = sc.nextLine().split(" ");//첫째 주
    		for(int j = 0; j < 7; j++) {
    			if(str[j].equals("-")) continue;
    			if(hm.containsKey(str[j])) hm.replace(str[j], hm.get(str[j]) + 4);
    			else hm.put(str[j], 4);
    		}
    		
    		str = sc.nextLine().split(" ");//둘째 주
    		for(int j = 0; j < 7; j++) {
    			if(str[j].equals("-")) continue;
    			if(hm.containsKey(str[j])) hm.replace(str[j], hm.get(str[j]) + 6);
    			else hm.put(str[j], 6);
    		}
    		
    		str = sc.nextLine().split(" ");//셋째 주
    		for(int j = 0; j < 7; j++) {
    			if(str[j].equals("-")) continue;
    			if(hm.containsKey(str[j])) hm.replace(str[j], hm.get(str[j]) + 4);
    			else hm.put(str[j], 4);
    		}
    		
    		str = sc.nextLine().split(" ");//넷째 주
    		for(int j = 0; j < 7; j++) {
    			if(str[j].equals("-")) continue;
    			if(hm.containsKey(str[j])) hm.replace(str[j], hm.get(str[j]) + 10);
    			else hm.put(str[j], 10);
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