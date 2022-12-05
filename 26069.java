import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	boolean[] chk = new boolean[2000];
    	HashMap<String, Integer> hm = new HashMap<>();
    	int idx = 0;
    	
    	while(--N >= 0) {
    		String name1 = sc.next();
    		String name2 = sc.next();
    		int aIdx = 0, bIdx = 0;
    		
    		if(!name1.equals("ChongChong")) {
    			if(hm.containsKey(name1)) aIdx = hm.get(name1);
        		else {
        			aIdx = idx;
        			hm.put(name1, idx);
        			idx += 1;
        		}
    		}
    		else aIdx = -1;
    		if(!name2.equals("ChongChong")) {
    			if(hm.containsKey(name2)) bIdx = hm.get(name2);
        		else {
        			bIdx = idx;
        			hm.put(name2, idx);
        			idx += 1;
        		}
    		}
    		else bIdx = -1;
    		
    		
    		if(aIdx == -1 || bIdx == -1) {
    			if(aIdx == -1) chk[bIdx] = true;
    			else chk[aIdx] = true;
    		}
    		else {
    			if(chk[aIdx] || chk[bIdx]) chk[aIdx] = chk[bIdx] = true;
    		}
    	}
    	
    	int res = 1;
    	for(int i = 0; i < idx; i++)
    		if(chk[i]) ++res;
    	
    	System.out.println(res);
	}
}