package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _2206 {
    static int X;
    static int Y;
    static int[][] map;
    static Queue<block> q = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        Y = Integer.parseInt(str[0]);
        X = Integer.parseInt(str[1]);

        map = new int[Y][X];
        visit = new int[Y][X][2];
        for(int y = 0; y < Y; y++){
            str = br.readLine().split("");
            for(int x= 0; x < X; x++){
                map[y][x] = Integer.parseInt(str[x]);
            }
        }
        q.add(new block(0, 0, 0, 1));
        int jinmo = bfs();

        System.out.println(jinmo);

    }

    static int bfs(){
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            int check = q.peek().check;
            int cnt = q.peek().cnt;
            q.poll();
            if(x == X - 1 && y == Y - 1) {
                return cnt;
            }
            for(int i = 0; i < 4; i++){
                int ix = x + dx[i];
                int iy = y + dy[i];
                if(ix >= 0 && ix < X && iy >= 0 && iy < Y) {
                    if (check == 0 && map[iy][ix] == 1) {
                        visit[iy][ix][1] = 1;
                        q.add(new block(ix, iy, 1, cnt + 1));
                    } else if (map[iy][ix] == 0) {
                        if (visit[iy][ix][check] == 0) {
                            visit[iy][ix][check] = 1;
                            q.add(new block(ix, iy, check, cnt + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }

    static class block{
        int x;
        int y;
        int check;
        int cnt;
        public block(int x, int y, int check, int cnt){
            this.x = x;
            this.y = y;
            this.check = check;
            this.cnt = cnt;
        }
    }
}
