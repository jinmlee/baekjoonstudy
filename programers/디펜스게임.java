package programers;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디펜스게임 {
    static int[] wjr;
    static int answer1 = 0;
    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        while(n >= 0 && answer < enemy.length){
            q.add(enemy[answer]);
            while(n - enemy[answer] < 0 && k > 0){
                n += q.poll();
                k--;
            }
            n -= enemy[answer];
            if(n < 0)
                break;
            answer++;
        }
        System.out.println(answer);
    }
}
