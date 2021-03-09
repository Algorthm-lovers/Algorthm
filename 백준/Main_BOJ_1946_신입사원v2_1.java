package BOJ_1946_신입사원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1946_신입사원v2_1 {
	static int N, T;
	static int[] order;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			order = new int[N+1];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int DocScreenOrder = Integer.parseInt(st.nextToken());	// 서류심사 순위
				int interviewOrder = Integer.parseInt(st.nextToken());	// 면접심사 순위
				order[DocScreenOrder] = interviewOrder;	// 서류심사 순위대로 저장함으로써 불필요한 정렬과정을 거치지 않는다
			}
			int min = order[1], cnt = 0;
			for(int i = 1; i < N+1; i++) {
				if(min >= order[i]) {	// 첫번째는 비교대상이 같으므로 '='를 추가해주었다
					min = order[i];
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
