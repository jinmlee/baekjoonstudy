package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _13549 {
    static int me;
    static int bro;
    static int[] visit;
    static Queue<run> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        me = Integer.parseInt(str[0]);
        bro = Integer.parseInt(str[1]);

        q.add(new run(me, 0));
        visit = new int[100001];

        System.out.println(bfs());
    }

    static int bfs(){
        while(!q.isEmpty()){
            int x = q.peek().x;
            int cnt = q.peek().cnt;
            q.poll();

            if(x == bro)
                return cnt;

            int t1 = x * 2;
            int t2 = x - 1;
            int t3 = x + 1;
            if(t1 >= 0 && t1 < 100001 && visit[t1] == 0){
                visit[t1] = 1;
                q.add(new run(t1, cnt));
            }
            if(t2 >= 0 && t2 < 100001 && visit[t2] == 0){
                visit[t2] = 1;
                q.add(new run(t2, cnt + 1));
            }
            if(t3 >= 0 && t3 < 100001 && visit[t3] == 0){
                visit[t3] = 1;
                q.add(new run(t3, cnt + 1));
            }
        }
        return 0;
    }

    static class run{
        int x;
        int cnt;
        public run(int x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }
    }
}
