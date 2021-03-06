package BOJ_1946_신입사원;
// 리스트에서의 삭제연산이 시간복잡도를 크게 한다고 판단하여 삭제연산 대신 count 적용했지만 시간초과
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BOJ_1946_신입사원3 {
	static class order implements Comparable<order>{
		int order1, order2;
		
		public order(int order1, int order2) {
			super();
			this.order1 = order1;
			this.order2 = order2;
		}

		@Override
		public int compareTo(order o) {
			return (this.order1 - o.order1) * (-1);	// 내림차순 정렬
		}
		
	}
	static int T, N;
	static int order[];
	static StringTokenizer st;
	static LinkedList<order> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		list = new LinkedList<>();
		for(int tc = 1; tc <= T; tc++) {
			list.clear();
			
			N = Integer.parseInt(br.readLine());
			for(int i = 0; i < N; i++) {	// 리스트에 석차 정보 담아줌
				st = new StringTokenizer(br.readLine());
				list.add(new order(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			Collections.sort(list); // 1차 서류심사(석차1)에 대한 내림차순으로 정렬
			
			int min = list.get(list.size()-1).order2;
			int cnt = 1;	// 최초 1명은 비교없이 시작(석차1에대해 1등이기때문)
			for(int i = list.size()-1; i >= 0; i--) {
				if(min > list.get(i).order2) {
					cnt++;
					min = list.get(i).order2;
				}
			}
			
			System.out.println(cnt);
			
		}
	}
}
