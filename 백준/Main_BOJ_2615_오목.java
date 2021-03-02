package BOJ_2615_오목;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2615_오목 {
	static StringBuilder sb;
	static int[][] board;	// 오목판
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[19][19];
		for(int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sb = new StringBuilder();
		System.out.println(match() ? sb : "0");	// 오목 수행결과가 true 이면 sb를, false이면 0을 출력
		
	}
	static int[] dr = {-1, 0, 1, 1};
	static int[] dc = {1, 1, 1, 0};
	static boolean match() {

		for(int c = 0; c < 19; c++) {
			for(int r = 0; r < 19; r++) {
				
				if(board[r][c]!=0) { // 해당 자리에 바둑알이 존재할 때
					for(int k = 0 ; k < 4; k++) {	// 4가지 방향에 대해서 검사  (우상단, 우, 우하단, 하단) _ 좌상단부터 우하단 순서로 진행하기 때문에 반대방향을 중복으로 체크할 필요가 없음

						int nr = r - dr[k], nc = c - dc[k];
						if(nr >= 0 && nr < 19 && nc >= 0 && nc < 19 && (board[r][c] == board[nr][nc])) continue; // 반대 방향에 같은돌이 놓여있으면 이미 체크하였으므로 continue;
						
						nr = r; nc = c;
						int cnt = 0;
						while(nr >= 0 && nr < 19 && nc >= 0 && nc < 19 && board[r][c] == board[nr][nc]) {	// 같은 방향으로 진행하면서 다음 돌이 범위 내에 있고 전 돌과 같은 돌이면 cnt 증가
							cnt++;
							
							nr += dr[k];
							nc += dc[k];
							if(cnt > 5) break;	// cnt가 5를 넘어가면 break;
						}
						if(cnt==5) {	// 루프를 빠져나온 뒤 cnt가 5이면 오목 완성
							sb.append(board[r][c]).append("\n").append(r+1).append(" ").append(c+1);	// 오목이 완성되었으면 어느 돌이 어느 위치에서(첫째줄부터 시작하므로 index+1해준다) 이겼는지 기록하고 true를 return
							return true;
						}
					}
				}
				
			}
		}
		
		return false;	// 모든 연산을 수행하고도 오목이 완성되지 않았으면 false를 return
		
	}
	
}
