package BOJ_1759_암호만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1759_암호만들기3 {
	static int L, C, j, m;
	static List<String> ja, mo;
	static boolean moChk;
	static String[] ans;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());	// 암호길이
		C = Integer.parseInt(st.nextToken());	// 문자개수
		
		ja = new ArrayList<>();
		mo = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {	// 모음 자음 따로 담기
			String temp = st.nextToken();
			if(temp.equals("a") ||
				temp.equals("e") ||
				temp.equals("i") ||
				temp.equals("o") ||
				temp.equals("u")) {
				mo.add(temp);
			} else {
				ja.add(temp);
			}
		}
		
		m = mo.size();
		j = C-m;
		
		MoNumbers = new int[m];
		JaNumbers = new int[j];
		q = new LinkedList<>();
		
		combJa(0, 3);
		combMo(0, 2);
		
//		for(int i = 0; i < L-3; i++) {
//			int k = j-2-i;
//			if(k < 0 || i > m-1) break;
//			
//		}
		
	}
	static int[] JaNumbers;
	static int[] MoNumbers;
	static Queue<int[]> q;
	private static void combJa(int start, int cnt) {
		if(cnt==L) {
			q.offer(JaNumbers);
			return;
		}
		
		for(int i = start; i < j; i++) {
			JaNumbers[cnt] = i;
			combJa(i+1, cnt+1);
		}
	}
	private static void combMo(int start, int cnt) {
		if(cnt==L) {
			for(int i = 0; i < q.size(); i++) {
				int[] temp = q.poll();
				q.offer(temp);
				Arrays.toString(temp);
			}
			return;
		}
		
		
		for(int i = start; i < m; i++) {
			MoNumbers[cnt] = i;
			combMo(i+1, cnt+1);
		}
	}
	
}
