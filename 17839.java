import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	HashMap<String, Integer> hm = new HashMap<>();
    	String[] name = new String[1000000];
    	ArrayList<Integer>[] aly = new ArrayList[200001];
    	
    	for(int i = 0; i <= 200000; i++) aly[i] = new ArrayList<>();
    	
    	int idx = 0;
    	for(int i = 0; i < N; i++) {
    		String a = sc.next();
    		String b = sc.next();
    		String c = sc.next();
    		
    		int aIdx = 0, cIdx = 0;
    		if(hm.containsKey(a)) aIdx = hm.get(a);
    		else {
    			hm.put(a, idx);
    			aIdx = idx;
    			idx += 1;
    		}
    		
    		if(hm.containsKey(c)) cIdx = hm.get(c);
    		else {
    			hm.put(c, idx);
    			cIdx = idx;
    			idx += 1;
    		}
    		
    		name[aIdx] = a;
    		name[cIdx] = c;
    		aly[aIdx].add(cIdx);
    	}
    	
    	if(!hm.containsKey("Baba")) return;
    	
    	idx = hm.get("Baba");
    	Queue<Integer> q = new LinkedList<>();
    	q.offer(idx);
    	
    	PriorityQueue<String> ans = new PriorityQueue<>();
    	HashSet<String> hs = new HashSet<>();
    	while(!q.isEmpty()) {
    		int size = q.size();
    		while(--size >= 0) {
    			int x = q.poll();
    			
    			if(!name[x].equals("Baba")) {
    				if(!hs.contains(name[x])) {
    					hs.add(name[x]);
    					ans.offer(name[x]);
    				}
    			}
    			
    			for(int next : aly[x]) {
    				if(hs.contains(name[next])) continue;
    				q.offer(next);
    			}
    		}
    	}
    	
    	while(!ans.isEmpty()) System.out.println(ans.poll());
	}
}