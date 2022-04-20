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
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> mq = new PriorityQueue<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num >= 0) pq.offer(num);
			else mq.offer(num);
		}
		
		Deque<Integer> dq1 = new LinkedList<>(), dq2 = new LinkedList<>();
		boolean left = true;
		while(!pq.isEmpty()) {
			int num = pq.poll();
			
			if(left) dq1.offerFirst(num);
			else dq1.offerLast(num);
			left = !left;
		}
		
		while(!mq.isEmpty()) {
			int num = mq.poll();
			
			if(left) dq2.offerFirst(num);
			else dq2.offerLast(num);
			left = !left;
		}
		
		if(!dq1.isEmpty() && dq1.peekFirst() < dq1.peekLast()) {//순서 반대로
			Queue<Integer> tmp = new LinkedList<>();
			while(!dq1.isEmpty()) tmp.offer(dq1.poll());
			while(!tmp.isEmpty()) dq1.offerFirst(tmp.poll());
		}
		if(!dq2.isEmpty() && dq2.peekFirst() < dq2.peekLast()) {//순서 반대로
			Queue<Integer> tmp = new LinkedList<>();
			while(!dq2.isEmpty()) tmp.offer(dq2.poll());
			while(!tmp.isEmpty()) dq2.offerFirst(tmp.poll());
		}
		
		while(!dq1.isEmpty()) bw.write(dq1.pollFirst() + " ");
		while(!dq2.isEmpty()) bw.write(dq2.pollFirst() + " ");
		bw.flush();
	}
}