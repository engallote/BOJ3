import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int N = Integer.parseInt(br.readLine());
    	int[] arr = new int[N];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
    	
    	int num = 1;
    	Deque<Integer> dq = new LinkedList<>();
    	
    	for(int i = N - 1; i >= 0; i--) {
    		if(arr[i] == 1) {
    			dq.offerFirst(num);
    		}
    		else if(arr[i] == 2) {
    			int tmp = dq.pollFirst();
    			dq.offerFirst(num);
    			dq.offerFirst(tmp);
    		}
    		else {
    			dq.offer(num);
    		}
    		
    		num += 1;
    	}
    	
    	while(!dq.isEmpty()) bw.write((dq.poll() + " "));
    	bw.flush();
	}
}