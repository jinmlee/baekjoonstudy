package bfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _5427 {
    static int X;
    static int Y;
    static int[][] map;
    static int[][] visit;
    static Queue<fire> q = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int px = 0;
        int py = 0;
        for(int t = 0; t < T; t++){
            String[] str = br.readLine().split(" ");
            X = Integer.parseInt(str[0]);
            Y = Integer.parseInt(str[1]);
            map = new int[Y][X];
            visit = new int[Y][X];
            for(int y = 0; y < Y; y++){
                str = br.readLine().split("");
                for(int x = 0; x < X; x++){
                    switch (str[x]){
                        case "*":
                            q.add(new fire(x, y, 1));
                            map[y][x] = 1;
                            visit[y][x] = 1;
                            break;
                        case "#":
                            map[y][x] = -1;
                            break;
                        case "@":
                            px = x;
                            py = y;
                            break;
                    }
                }
            }
            bfs();
            q.clear();
            visit = new int[Y][X];
            q.add(new fire(px, py, 1));
            visit[py][px] = 1;
            bfs2();
            q.clear();
        }
    }

    static void bfs2(){
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            int cnt = q.peek().cnt;
            q.poll();

           // System.out.println(cnt);
            for(int i = 0; i < 4; i++){
                int ix = x + dx[i];
                int iy = y + dy[i];
                if(ix >= 0 && ix < X && iy >= 0 && iy < Y) {
                    if(visit[iy][ix] == 0 && (map[iy][ix] > cnt + 1 || map[iy][ix] == 0) && map[iy][ix] != -1) {
                        visit[iy][ix] = 1;
                        q.add(new fire(ix, iy, cnt + 1));
                    }
                }
                else{
                    System.out.println(cnt);
                    return;
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    static void bfs(){
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            int cnt = q.peek().cnt;
            q.poll();

            for(int i = 0; i < 4; i++){
                int ix = x + dx[i];
                int iy = y + dy[i];
                if(ix >= 0 && ix < X && iy >= 0 && iy < Y) {
                    if(visit[iy][ix] == 0 && map[iy][ix] != -1) {
                        visit[iy][ix] = 1;
                        map[iy][ix] = cnt + 1;
                        q.add(new fire(ix, iy, cnt + 1));
                    }
                }
            }
        }
    }

    static class fire{
        int x;
        int y;
        int cnt;
        public fire(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}