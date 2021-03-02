package BJ_2527_직사각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2527_직사각형 {
	static square1 first;
	static square2 second;
	static String answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			first = new square1(Integer.parseInt(st.nextToken()), // 첫 번째 사각형
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			second = new square2(Integer.parseInt(st.nextToken()), // 두 번째 사각형
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			
			
			if ((first.p==second.x && first.q==second.y) || (first.p==second.x && first.y==second.q) || (first.x==second.p && first.y==second.q) || (first.x == second.p && first.q == second.y )) { 
				answer = "c";	// 점
			} else if (first.x == second.p || first.p == second.x || first.y == second.q || first.q == second.y) {
				answer = "b";	// 선분
			} else if (first.p < second.x || first.q < second.y || first.x > second.p || first.y > second.q) {
				answer = "d";	// 공통부분없음
			} else {
				answer = "a";	// 직사각형
			}

			System.out.println(answer);

		}
	}

	static class square1 { // 사각형 클래스1
		static int x, y, p, q; // x, y, p, q 각 좌표 받은 그대로 저장

		public square1(int x, int y, int p, int q) {
			this.x = x;
			this.y = y;
			this.p = p;
			this.q = q;
		}

	}

	static class square2 { // 사각형 클래스2
		static int x, y, p, q; // x, y, p, q 각 좌표 받은 그대로 저장

		public square2(int x, int y, int p, int q) {
			this.x = x;
			this.y = y;
			this.p = p;
			this.q = q;
		}

	}

}
