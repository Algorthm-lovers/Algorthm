package BOJ_14002_가장긴증가하는부분수열4;
// 12952KB, 108ms
// DP, LIS
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_14002_가장긴증가하는부분수열4_v2 {
	static class Node{
		int num;
		
		Node next;
		
		
		public Node(int num) {
			super();
			this.num = num;
			this.next = null;
		}

		public Node(int num, Node next) {
			super();
			this.num = num;
			this.next = next;
		}
		
		@Override
		public String toString() {
			return "Node [num=" + num + ", next=" + next + "]";
		}
		
	}
	
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] D = new int[N];
		int max = 0, maxIdx = -1;
		Node[] list = new Node[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < N; i++) {
			if(i==0) D[i] = 1;
			list[i] = new Node(arr[i]);
			int temp = -1;
			for(int j = 0; j < i; j++) {
				if(arr[i]>arr[j]) {
					if(D[i] < D[j] +1) {
						temp = j;
					}
					D[i] = Math.max(D[i], D[j]+1);
				}
			}
			if(D[i]==0) D[i] = 1;
			if(D[i] > max) {
				max = D[i];
				maxIdx = i;
			}
			if(!(temp==-1)) {
				list[i] = new Node(arr[i], list[temp]);
			}
		}
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		System.out.println(max);
		for(Node n = list[maxIdx];  n != null; n = n.next) {
			stack.push(n.num);
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
