package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _7562 {
    static int I;
    static int X;
    static int Y;
    static int[] dx = {1, 2, -1, -2, 1, 2, -1, -2};
    static int[] dy = {2, 1, 2, 1, -2, -1, -2, -1};
    static int[][] visit;
    static Queue<chess> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            I = Integer.parseInt(br.readLine());
            visit = new int[I][I];
            String[] str = br.readLine().split(" ");
            X = Integer.parseInt(str[0]);
            Y = Integer.parseInt(str[1]);
            q.offer(new chess(X, Y, 0));
            str = br.readLine().split(" ");
            X = Integer.parseInt(str[0]);
            Y = Integer.parseInt(str[1]);
            bfs();
            q.clear();
        }
    }

    static void bfs(){
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            int cnt = q.peek().cnt;
            if(x == X && y == Y) {
                System.out.println(q.peek().cnt);
                break;
            }
            q.poll();
            for(int i = 0; i < 8; i++){
                int sx = x + dx[i];
                int sy = y + dy[i];
                if(sx >= 0 && sx < I && sy >= 0 && sy < I){
                    if(visit[sy][sx] == 0) {
                        q.offer(new chess(sx, sy, cnt + 1));
                        visit[sy][sx] = 1;
                    }
                }
            }
        }
    }

    static class chess{
        int x;
        int y;
        int cnt;
        public chess(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
