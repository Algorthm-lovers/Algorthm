package BOJ_1747_소수_팰린드롬;

import java.util.Scanner;

public class Main_BOJ_1747_소수_팰린드롬 {
	static int N;
	static boolean[] numbers;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		/** 
		 * 에라토스테네스의체 사용하여 소수인지 체크
		 * (100만 다음의 팰린드롬 소수인 1003001 까지 표시할 수 있는 boolean형 배열 선언 ->제한없이 프로그램 수행 뒤 찾았음 )
		 * */
		numbers = new boolean[1003002];	
		for(int i = 2; i <= 1003001; i++) {
			int curr = i*2;
			for(int j = 3;  curr <= 1003001; j++) {
				numbers[curr] = true;
				curr = i*j;
			}
		}
		int num = N==1 ? 2 : N;	// 1은 소수가 아니므로 N==1이면 num에 2를 넣어준다
		while(num<=1003001) {
			if(!numbers[num] && pdr(num)) break;
			num++;
		}
		System.out.println(num);
	}
	/** 팰린드롬인지 체크 */
	private static boolean pdr(int n) {
		String word = Integer.toString(n);
		int len = word.length();
		int pos1 = 0, pos2 = len-1;
		while(true) {
			if(pos1 >= pos2) {
				return true;
			}
			if(word.charAt(pos1++) != word.charAt(pos2--)) break; 
		}
		return false;
	}
}
