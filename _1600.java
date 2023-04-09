package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _1600 {
    static  int T;
    static  int X;
    static  int Y;
    static int[][] map;
    static int[][][] visit;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int hdx[] = {1, 2, 1, 2, -1, -2, -1, -2};
    static int hdy[] = {2, 1, -2, -1, -2, -1, 2, 1};
    static Queue<monkey> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        X = Integer.parseInt(str[0]);
        Y = Integer.parseInt(str[1]);

        map = new int[Y][X];
        visit = new int[Y][X][T + 1];
        for(int y = 0; y < Y; y++){
            str = br.readLine().split(" ");
            for(int x = 0; x < X; x++){
                map[y][x] = Integer.parseInt(str[x]);
            }
        }
        bfs();

    }

    static void bfs(){
        q.add(new monkey(0, 0, 0, 0));
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            int cnt  = q.peek().cnt;
            int check = q.peek().check;
            q.poll();
            if(x == X - 1 && y == Y - 1) {
                System.out.println(cnt);
                return ;
            }

            if(check < T){
                for(int i = 0; i < 8; i++){
                    int ix = x + hdx[i];
                    int iy = y + hdy[i];
                    if(ix >= 0 && iy >= 0 && ix < X && iy < Y){
                        if(visit[iy][ix][check + 1] == 0 && map[iy][ix] != 1){
                            visit[iy][ix][check + 1] = 1;
                            q.add(new monkey(ix, iy, cnt + 1, check + 1));
                        }
                    }
                }
            }
            for(int i = 0; i < 4; i++){
                int ix = x + dx[i];
                int iy = y + dy[i];
                if(ix >= 0 && ix < X && iy >= 0 && iy < Y){
                    if(visit[iy][ix][check] == 0 && map[iy][ix] != 1) {
                        visit[iy][ix][check] = 1;
                        q.add(new monkey(ix, iy, cnt + 1, check));
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static class monkey{
        int x;
        int y;
        int cnt;
        int check;
        public monkey(int x, int y, int cnt, int check){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.check = check;
        }
    }
}
