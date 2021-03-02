package BOJ_2477_참외밭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2477_참외밭 {
	static int K, r, c, area, answer;
	static int[] dr = { 0, 0, 0, -1, 1 }; // 동:1, 서:2, 남:3, 북:4
	static int[] dc = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			r += (dr[dir] * dist);	// r값은 계속해서 누적
			area += r * (dc[dir] * dist);	// c값이 움직일 때 마다 (누적  r값 * 현재 c값)을 면적에 더해줌.(c에 따라서 -값을 더할수도 있다)
		}
		area = Math.abs(area);	// 면적이 -값이 구해졌으면 절댓값으로 바꾸어줌
		answer = area * K;	// 면적당 참외 개수를 곱해줌
		System.out.println(answer);
	}

}
