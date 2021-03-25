package BOJ_2636_치즈;
// bfs
// 12256KB, 104ms
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2636_치즈 {
	static int[][] arr;
	static boolean[][] isVisited;
	static int R, C, num, last, cnt;
	static final int row = 0, col = 1;
	static Queue<int[]> q1, q2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		isVisited = new boolean[R][C];
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for( int j = 0 ; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) num++;
			}
		}
		q1.offer(new int[] {0, 0});	// (0, 0)좌표는 치즈 바깥쪽의 공기임이 보장되므로 시작 값으로 준다.
		while(!(num==0)) {	// 남은 치즈수가 0이 되기 전까지 루프
			last = bfs();	// 이번 bfs()에서 반환된 녹은 치즈 수를 last 변수에 저장
			cnt++;			// 루프를 몇 번 돌았는지 기록
		}
		System.out.println(cnt);
		System.out.println(last);
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int bfs() {
		while(!q2.isEmpty()) {
			q1.offer(q2.poll());	// q2에 저장되어 있는 좌표값을 이번 턴에 처리할 수 있도록 q1에 옮겨담는다.
		}
		isVisited[0][0] = true;
		int meltCount = 0;
		while(!q1.isEmpty()) {
			int r = q1.peek()[row];
			int c = q1.poll()[col];
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= R || nc >= C || isVisited[nr][nc] ) continue;
				isVisited[nr][nc] = true;
				if(arr[nr][nc] == 0) {
					q1.offer(new int[] {nr, nc});	// q1에는 이번 bfs에서 처리할 공기 값의 좌표 저장
				} else if(arr[nr][nc] == 1) {
					arr[nr][nc] = 0;				// 녹은 치즈는 0으로 초기화
					q2.offer(new int[] {nr, nc});	// q2에는 다음 bfs에서 처리할 공기 값의 좌표 저장(이번 bfs에서 녹은 치즈의 좌표)
					meltCount++; 	// 녹은 치즈의 수
					num--;
				}
			}
		}
		return meltCount;
	}
}
