import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	
    	for(int i = 0; i < N; i++) {
    		int num = Integer.parseInt(br.readLine());
    		pq.offer(num);
    	}
    	
    	int[] arr = new int[4];
    	Arrays.fill(arr, 99999999);
    	
    	for(int i = 0; i < 4 && !pq.isEmpty(); i++) arr[i] = pq.poll();
    	
    	PriorityQueue<Long> ans = new PriorityQueue<>();
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < 4; i++) {
    		for(int j = 0; j < 4; j++)
    			if(i != j) {
    				sb = new StringBuilder();
    				sb.append(arr[i]);
    				sb.append(arr[j]);
    				ans.offer(Long.parseLong(sb.toString()));
    			}
    	}
    	
    	ans.poll();
    	ans.poll();
    	System.out.println(ans.peek());
	}
}