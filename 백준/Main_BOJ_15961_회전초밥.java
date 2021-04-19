package BOJ_15961_회전초밥;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_15961_회전초밥 {
	static int N, d, k, c, count, maxCount, sushi[], isSelected[];
	static final int INF = 5000000; // N이 300만이라 적당히 큰 값 주었음.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		sushi = new int[N];
		isSelected = new int[d+1];	// 초밥 번호: 1 ~ d
		isSelected[c] = INF;	// 쿠폰 초밥은 항상 카운트에 포함 (INF가 아니라 1을 주어도 상관없기는 함)
		count = 1;
		
		for(int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < k; i++) {
			int temp = sushi[i];
			if(isSelected[temp]==0) count++;
			isSelected[temp]++;
		}
		maxCount = count;
		
		for(int i = 0; i < N; i++) {
			int temp = sushi[i];	// 맨앞 삭제
			if(isSelected[temp]==1) count--;
			isSelected[temp]--;
			
			int rotateIdx = i + k;	// 맨뒤 추가
			if(rotateIdx >= N) rotateIdx -= N;	// 인덱스가 N-1을 넘으면 0부터
			temp = sushi[rotateIdx];
			if(isSelected[temp]==0) count++;
			isSelected[temp]++;
			
			maxCount = Math.max(maxCount, count);
		}
		
		System.out.println(maxCount);
		
	}
}
