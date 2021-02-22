package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;


public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }
    private void run() throws IOException {
        int test_case = 0;
        int input_data = 99;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder()); // PriortyQueue로 heap 구현
        //최대 heap의 경우 Collections.reverseOrder() 사용

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        test_case = Integer.parseInt(br.readLine()); // 1) testcase의 값 입력

        for(int i = 0 ; i < test_case; i++){
            input_data = Integer.parseInt(br.readLine());
            if(input_data == 0){
                if(heap.isEmpty()) // heap이 비어있을때 0 출력
                    System.out.println("0");
                else{
                    System.out.println(heap.poll()); // heap이 비어있지 않다면 값을 출력
                }
            }
            else {
                heap.add(input_data); // heap에 값 입력받음
            }
        }

    }
}
