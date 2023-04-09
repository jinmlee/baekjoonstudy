package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _2573 {
    static int X;
    static int Y;
    static int[][] map;
    static int[][] visit;
    static Queue<ice> q = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        Y = Integer.parseInt(str[0]);
        X = Integer.parseInt(str[1]);
        int day = 0;

        map = new int[Y][X];
        for(int y = 0; y < Y; y++){
            str = br.readLine().split(" ");
            for(int x = 0; x < X; x++){
                map[y][x] = Integer.parseInt(str[x]);
            }
        }

        while(true) {
            int cnt = 0;
            visit = new int[Y][X];
            for (int y = 0; y < Y; y++) {
                for (int x = 0; x < X; x++) {
                    //               System.out.print(map[y][x] + " ");
                    if (map[y][x] < 0)
                        map[y][x] = 0;
                    if (map[y][x] > 0 && visit[y][x] == 0) {
                        visit[y][x] = 1;
                        bfs(x, y);
                        cnt++;
                    }
                }
                //             System.out.println();
            }
            /////////////////////////////////////////
//            for (int y = 0; y < Y; y++) {
//                for (int x = 0; x < X; x++) {
//                    System.out.print(map[y][x] + " ");
//
//                }
//
//                System.out.println();
//            }
//            System.out.println();
//            ///////////////////////////////////
 //           System.out.println(cnt);
            day++;
            q.clear();
            if(cnt >= 2){
                System.out.println(day - 1);
                return ;
            }
            if(cnt == 0){
                System.out.println(0);
                return;
            }
        }
    }

    static void bfs(int x, int y){
        q.add(new ice(x, y));
        while(!q.isEmpty()){
            x = q.peek().x;
            y = q.peek().y;
            q.poll();
            for(int i = 0; i < 4; i++){
                int ix = x + dx[i];
                int iy = y + dy[i];
                if(ix >= 0 && ix < X && iy >= 0 && iy < Y) {
                    if (map[iy][ix] == 0) {
                        map[y][x]--;
                        if(map[y][x] == 0)
                            map[y][x] = -1;
                    }
                    if (map[iy][ix] > 0 && visit[iy][ix] == 0) {
                        visit[iy][ix] = 1;
                        q.add(new ice(ix, iy));
                    }
                }
            }

        }
    }

    static class ice{
        int x;
        int y;
        public ice(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
