package BOJ_1011_FlyMeToTheAlphaCentauri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_1011_FlyMeToTheAlphaCentauri {
	static int T, Lsize;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		// 0 ~ n 까지 더한 값을 최대로 DP (n <= 46342)
		List<Integer> list = new ArrayList<>();
		int temp = 0;
		for(int i = 0; ; i++) {
			temp = (i*(i+1))/2;
			if(temp < 0) break;
			list.add(temp);
		}
		Lsize = list.size();
		
		for(int tc = 0; tc < T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int count = 0;
			
			// 이동 거리, 이동거리의 절반
			int len = y - x;
			int halfLen = len / 2;
			
			
			int max = 0;
			// DP된 값 중, 전체 이동거리의 절반보다 처음으로 큰 값을 max라 하면, 
			// 전체 거리 len에서 2*(list.get(max-1))를 빼고, count에 2*(max-1) 값을 더해준다.
			for(int i = 0; i < Lsize; i++) {
				if(list.get(i) > halfLen || i==(Lsize-1)) {
					max = i;
					len -= (2 * list.get(max-1));
					count += (2*(max-1));
					break;
				}
			}
			
			
			// 남은 len 값이 max보다 작으면 한번에 갈 수 있고, max보다 크면, len에서 max만큼 빼주고, count값을 1 증가시킨다.
			if(max != 0) {
				count += (len/max);
				if(len%max != 0) {
					count++;
				}
			}
			
			System.out.println(count);
		}
	}
}
/*
1
0 2147483647
 */