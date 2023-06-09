package programers;


import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 주차요금계산 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] answer;

        int[][] park = new int[10000][2];
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i = 0; i < records.length; i++){
            String[] str = records[i].split(" ");
            int number = Integer.parseInt(str[1]);
            String[] min = str[0].split(":");
            String check = str[2];
            int minute = Integer.parseInt(min[0]) * 60 + Integer.parseInt(min[1]);
            if(check.equals("IN")){
                q.add(number);
                park[number][0] = minute;
            }else{
                int add = minute - park[number][0];
                park[number][1] += add;
                park[number][0] = 0;
            }
        }
        Queue<Integer> q2 = new LinkedList<>();
        int num1 = q.poll();
        q2.add(num1);
        while(!q.isEmpty()){
            if(q.peek() != num1){
                num1 = q.poll();
                q2.add(num1);
            }else
                q.poll();
        }

        answer = new int[q2.size()];
        int idx = 0;
        while(!q2.isEmpty()){
            int num = q2.poll();
            int cash;
            if(park[num][0] == 0 && park[num][1] == 0){
                cash = (23 * 60 + 59) - fees[0];
            }
            else if(park[num][0] == 0){
                cash = park[num][1] - fees[0];
            }else{
                cash = park[num][1] + (23 * 60 + 59) - park[num][0] - fees[0];
            }

            if(cash <= 0){
                answer[idx] = fees[1];
                idx++;
            }
            else{
                cash = (int)Math.ceil(cash/(double)fees[2]);
                answer[idx] = cash*fees[3] + fees[1];
                idx++;
            }
        }

        for(int i = 0; i < answer.length; i++){
            System.out.print(answer[i] + " ");
        }
    }
}
