package programers;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int k = Integer.parseInt(br.readLine());
        int sequence[] = new int[str.length];
        for(int i = 0; i < str.length; i++){
            sequence[i] = Integer.parseInt(str[i]);
        }


        int[] answer = {};
        answer = new int[2];
        int x = sequence.length - 1;

        Queue<num> q = new LinkedList<>();
        Queue<num> back = new LinkedList<>();
        int add = 0;
        int idx = 0;
        int max = 10000000;
        while(idx < str.length){
            add += sequence[idx];
            q.add(new num(sequence[idx], idx));
            if(add > k){
                while(!q.isEmpty()) {
                    add -= q.poll().n;
                    if(add <= k)
                        break;
                }
            }
            if(add == k){
                if((idx - 1) - q.peek().idx < max) {
                    answer[0] = q.peek().idx;
                    answer[1] = idx;
                    max = (idx - 1) - q.peek().idx;
                }
            }
            idx++;

        }
        System.out.println(answer[0] +" " + answer[1]);
        //return answer;
    }

    static class num{
        int n;
        int idx;
        public num(int n, int idx){
            this.n = n;
            this.idx = idx;
        }
    }
}
