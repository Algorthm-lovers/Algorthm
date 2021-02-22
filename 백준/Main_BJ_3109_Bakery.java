package BJ_3109_Bakery;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_3109_Bakery {
	static int R, C;
	static boolean[][] visited;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[R][C];
		
		map = new char[R][C];
		for(int i = 0; i < R; i++) {	// 지도 그리기
			map[i] = br.readLine().toCharArray();
		}
		
		pipe();
		System.out.println(count);
	}
	
	static void pipe() {
		for(int i = 0; i < R; i++) {	// 위에서부터 아래로, dfs도 위에서부터 아래로 진행하여 중복이 없도록 한다
			if(dfs(i, 0)) count++;	// dfs에서 true가 return되면 count++
		}
	}
	
	static int[] dr = {-1, 0, 1};
	static int count;
	static boolean dfs(int r, int c) {
		if(c == C-1) {
			visited[r][c] = true;
			return true;	// 파이프 연결에 성공하면 true 반환
		}
		for(int i = 0; i < 3; i++) {
			int nr = r + dr[i];
			int nc = c + 1;
			
			if(nr < 0 || nr > R-1 || map[nr][nc]=='x' || visited[nr][nc]) continue;	// 진행 불가능한 조건들
			
			visited[nr][nc] = true;
			if(dfs(nr, nc)) return true;	// 파이프 연결 결과 return : 파이프가 끝까지 도달하여 연결 성공시 더이상 진행하지 않고 true 반환
		}
		return false;	// 오른쪽 세 칸 모두 불가능 -> 파이프 연결 실패: return false
	}
}
