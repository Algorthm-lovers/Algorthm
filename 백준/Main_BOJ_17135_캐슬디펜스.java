package BJ_17135_캐슬디펜스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17135_캐슬디펜스 {
	
	static int bfs() {	// 주어진 조건에서 제거한 적의 수를 반환하는 함수
		int count = 0;	// count -> 제거한 적의 수
		String[][] fieldCopy = new String[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				fieldCopy[i][j] = field[i][j]; // 맵을 바꿀것이기 때문에 배열을 복사해서 사용 -> 복사할 때 fieldCopy = field 로 써서는 안된다! (주소참조가 되어버림)
			}
		}
		boolean[][] attacked = new boolean[N][M];
		boolean attCheck = false;	// 궁수가 공격을 했는지 체크
		Queue<int[]> queue = new LinkedList<>();
		
		
		for(int i = N; i > 0; i--) {	// 성(궁수)의 행 위치 - 턴이 지날때마다 1행씩 위로 올라간다
			for(int j = 0; j < 3; j++) {	// 궁수의 공격 : 왼쪽부터 순서대로 3명 (조합을 통해 뽑힌 3명) 
											// archers[j] -> 궁수가 위치하고 있는 행의 index
				
				attCheck = false;	// 다음 궁수로 넘어가기 전에 공격체크 false로 초기화
				
				for(int d = 1; d <= D; d++) {	// d : 공격범위 ( 1부터 D까지 차례대로 _ 공격 성공시 표시 후 break;)
					for(int k = 1; k <= d; k++) {	// 궁수의 좌측부터 중앙까지 (왼쪽부터, 거리 1부터 공격가능한 적 있는지 탐색)
						int x = i-k, y = archers[j]-(d-k);
						if(x < 0 || y < 0 ) continue;	// 범위를 벗어난 경우 continue 처리
						if(fieldCopy[x][y].equals("1")) {
							if(!attacked[x][y]) queue.offer(new int[] {x, y});	// 중복되지 않게 queue에 담는다
							attacked[x][y] = true;
							attCheck = true;
							break;
						}
					}
					if(attCheck) break;	// 공격을 수행했다면 더이상 탐색하지 않고 break;
					for(int k = d-1; k >= 1; k--) {	//궁수의 중앙부터 우측까지 체크
						int x = i-k, y = archers[j]+(d-k);
						if(x < 0 || y >= M ) continue;
						if(fieldCopy[x][y].equals("1")) {
							if(!attacked[x][y]) queue.offer(new int[] {x, y});
							attacked[x][y] = true;
							attCheck = true;
							break;
						}
					}
					if(attCheck) break;
					
				}
			}
			
			// 해당 턴의 모든 궁수의 공격이 끝나고, 공격당한 적은 필드에서 배제 (원칙상 동시공격이기 때문에 공격한 즉시 필드에서 배제시키지 않음)
			count += queue.size();
			while(!queue.isEmpty())	fieldCopy[queue.peek()[0]][queue.poll()[1]] = "0";
		}
		
		return count;
	}
	
	
	
	static int[] archers;
	static void comb(int cnt, int start) {	// 궁수의 위치 - M개(0 ~ M-1)중에 3개를 뽑는 조합
		if(cnt == 3) {	// 궁수의 위치가 정해졌을 때
			ans = Math.max(ans, bfs());	// 제거할 수 있는 적의 수가 최대가 되는 값을 구한다
			return;
		}
		for(int i = start; i < M; i++) {
			archers[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	
	static int N, M, D, ans;
	static String[][] field;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		field = new String[N][];
		
		for(int i = 0; i < N; i++) {
			field[i] = br.readLine().split(" ");
		}
		
		archers = new int[3];
		comb(0, 0);
		System.out.println(ans);
	}
}
