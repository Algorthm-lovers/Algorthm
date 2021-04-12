package BOJ_1786_찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// KMP 알고리즘
public class Main_BOJ_1786_찾기 {
	static int n, m;
	static char[] T, P;
	static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine().toCharArray();
		P = br.readLine().toCharArray();
		
		n = T.length; m = P.length;
		
		int[] fail = new int[m]; // 실패함수
		for (int i = 1, j = 0; i < m; i++) {
			while(j > 0 && P[i]!=P[j]) {
				j = fail[j-1];
			}
			if(P[i]==P[j])
				fail[i] = ++j;
		}
	
		StringBuilder sb = new StringBuilder();
		for(int i = 0, j = 0; i < n; i++) {	// i: 텍스트 포인터, j : 패턴 포인터
			while(j > 0 && T[i]!=P[j]) {
				j = fail[j-1];
			}
			
			if(P[j] == T[i]) {
				if(j == m-1) {	// j가 끝까지 가면 문자 하나 찾은 것
					count++;
					sb.append((i+1)-m+1).append(" "); // index가 아니라 몇번째 문자인지를 찾는 것이기 때문에 +1 해주어야함
					j = fail[j];
				} else {
					j++;
				}
			} 
		}
		
		System.out.println(count);
		if(count > 0) {
			sb.setLength(sb.length()-1);
			System.out.println(sb);
		}
	}
}
