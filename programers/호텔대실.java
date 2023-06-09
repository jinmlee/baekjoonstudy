package programers;

import java.util.*;


public class 호텔대실 {
        static Queue<room> q1 = new LinkedList<>();
        static PriorityQueue<room> q2 = new PriorityQueue<>(Comparator.comparing(o -> o.end));
    public static void main(String[] args) {
        String[][] book_time = {{"15:00", "17:00"}, {"15:00", "17:00"}, {"15:00", "17:00"}, {"15:00", "17:00"}, {"15:00", "17:00"}};

        Arrays.sort(book_time, Comparator.comparing((String[] o) -> o[0]));

        for(int i = 0; i < book_time.length; i++){
            q1.add(new room(book_time[i][0], book_time[i][1]));
        }

        q2.add(q1.poll());

        System.out.println(fun());

    }

    static int fun(){
        int cnt = 1;
        int max = 1;
        while(!q1.isEmpty()){
            int start = q1.peek().start;
            int end = q1.peek().end;

            q1.poll();

            if(start >= q2.peek().end){
                q2.poll();
                q2.add(new room(start, end));
            }else {
                q2.add(new room(start, end));
                cnt++;
            }

            if(cnt > max)
                max = cnt;

        }
        return max;
    }

    static class room{
        int start;
        int end;
        public room(String start , String end){
            String[] str = start.split(":");
            this.start = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
            str = end.split(":");
            this.end = Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]) + 10;
        }
        public room(int a, int b){
            this.start = a;
            this.end = b;
        }
    }
}
