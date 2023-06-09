package programers;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {
    public static void main(String[] args) {
        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};
            int answer = 0;

            long total1 = 0;
            long total2 = 0;
            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();
            for(int i = 0; i < queue1.length; i++){
                total1 += queue1[i];
                total2 += queue2[i];
                q1.add(queue1[i]);
                q2.add(queue2[i]);
            }

            while(true){
                if(total1 == total2)
                    break;
                if(answer > queue1.length * 2){
                    answer = -1;
                    break;
                }
                if(!q1.isEmpty() && total1 > total2){
                    int num = q1.peek();
                    total2 += num;
                    total1 -= num;
                    q1.poll();
                    q2.add(num);
                }else if(!q2.isEmpty() && total1 < total2){
                    int num = q2.peek();
                    total2 -= num;
                    total1 += num;
                    q2.poll();
                    q1.add(num);
                }
                answer++;
            }
        System.out.println(answer);
    }
}
