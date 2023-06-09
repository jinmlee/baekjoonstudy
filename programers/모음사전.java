package programers;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 모음사전 {
    public static void main(String[] args) {
        String word = "AAAAE";
        int answer = 0;

        String[] str = word.split("");
        int[] wordNum = new int[str.length];
        int size = 5;
        int cnt = 0;
        int idx = 0;
        for (int i = 0; i < word.length(); i++) {
            int num = 0;
            switch (str[i]) {
                case "A":
                    num = 1;
                    break;
                case "E":
                    num = 2;
                    break;
                case "I":
                    num = 3;
                    break;
                case "O":
                    num = 4;
                    break;
                case "U":
                    num = 5;
                    break;
            }
            wordNum[i] = num;
        }

        Deque<Integer> q = new LinkedList<>();
        q.add(1);
        while (idx < str.length) {
            if (!q.isEmpty() && q.peekFirst() == wordNum[idx]) {
                q.removeFirst();
                size--;
                idx++;
            }
            if (q.size() < size) {
                q.addLast(1);
            } else if(!q.isEmpty()){
                while (true) {
                    int num = q.removeLast();
                    num++;
                    if (num < 6) {
                        q.addLast(num);
                        break;
                    }
                }
            }
            cnt++;
        }
        answer = cnt;

        System.out.println(cnt);
    }
}
