package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = ""; // ipv6를 입력받는다.
        input = br.readLine();
        int point = 0;
        boolean isShorted = false;

        String[] IpV6 = new String[8]; // 실제 변환된 Ipv6이 저장되는곳.

        String[] inputs = input.split(":"); // : 단위로 분할하여 inputs 배열에 저장시킨다.

        for(int i=0; i< inputs.length;i++){
            for(int j = i+1; j< inputs.length;j++){
                if(inputs[i].equals("") && inputs[j].equals("")){
                    point = i; // ::이 발생하는 지점 check
                    isShorted = true;
                    // System.out.println("activated.");
                    System.out.println(point);
                }
            }
        }
        if(!isShorted){
            for(int i=0;i< IpV6.length;i++){
                IpV6[i] = inputs[i];
            }
        }

        if(isShorted){
            for(int i=0; i< IpV6.length; i++){
                if(i < point){
                    IpV6[i] = inputs[i];
                }
                while (point <= i && i < IpV6.length - inputs.length - 2){
                    IpV6[i] = "0000";
                    i++;
                }
                point += 2;
                while(point -1 == inputs.length-1){
                    IpV6[i] = inputs[point++];
                }
            }
        }
        for(String i : IpV6){ // 출력만 하는 logic
            if(i.length() == 4){
                System.out.println(i);
            }
            else if(i.length() == 3){
                System.out.println("0" + i);
            }
            else if(i.length() == 2){
                System.out.println("00" + i);
            }
            else if(i.length() == 1){
                System.out.println("000" + i);
            }
            else{
                System.out.println("0000");
            }
        }

    }
}
