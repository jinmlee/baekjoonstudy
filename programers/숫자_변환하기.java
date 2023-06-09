package programers;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숫자_변환하기 {
    static Queue<nbr> q = new LinkedList<>();
    static  int[] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();

        visit = new int[y + 1];

        answer = op(x, y, n);
        System.out.println(answer);
    }

    static int op(int x, int y, int n){
        q.add(new nbr(x, 0));
        while(!q.isEmpty()){
            int xn = q.peek().number + n;
            int x2 = q.peek().number * 2;
            int x3 = q.peek().number * 3;
            int cnt = q.peek().cnt;

            if(q.peek().number == y)
                return cnt;
            q.poll();

            if(xn <= y){
                if(visit[xn] == 0) {
                    q.add(new nbr(xn, cnt + 1));
                    visit[xn] = 1;
                }
            }
            if(x2 <= y){
                if(visit[x2] == 0){
                    q.add(new nbr(x2, cnt + 1));
                    visit[x2] = 1;
                }
            }
            if(x3 <= y){
                if(visit[x3] == 0) {
                    q.add(new nbr(x3, cnt + 1));
                    visit[x3] = 1;
                }
            }

        }
        return -1;
    }

    static class nbr{
        int number;
        int cnt;
        public nbr(int number, int cnt){
            this.number = number;
            this.cnt = cnt;
        }
    }
}
