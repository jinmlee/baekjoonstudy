package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _2146 {
    static  int[][] map;
    static int[][] map2;
    static int[][] visit;
    static int[][] visit2;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static Queue<allBlue> q = new LinkedList<>();
    static Queue<allLast> q2 = new LinkedList<>();
    static int min = 2147483647;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new int[N][N];
        map2 = new int[N][N];



        for(int y = 0; y < N; y++){
            String[] str = br.readLine().split(" ");
            for(int x = 0; x < N; x++){
                map[y][x] = Integer.parseInt(str[x]);
            }
        }

        int check = 2;
        for(int y = 0; y < N; y++){
            for(int x = 0; x < N; x++){
                if(visit[y][x] == 0 && map[y][x] == 1) {
                    visit = new int[N][N];
                    visit2= new int[N][N];
                    q.add(new allBlue(x, y));
                    q2.add(new allLast(x, y, 0));
                    visit[y][x] = 1;
                    visit2[y][x] = 1;
                    map2[y][x] = check;
                    bfs(check);
                    bfs2(check);
                    q.clear();
                    q2.clear();
                    check++;
                }
            }
        }
        System.out.println(min);
    }
    static void bfs2(int check){
        while(!q2.isEmpty()){
            int x = q2.peek().x;
            int y = q2.peek().y;
            int cnt = q2.peek().cnt;

            q2.poll();
            for(int i = 0; i < 4; i++){
                int ix = x + dx[i];
                int iy = y + dy[i];
                if(ix >= 0 && ix < N && iy >= 0 && iy < N){
                    if(visit2[iy][ix] == 0 && map2[iy][ix] == 0){
                        visit2[iy][ix] = 1;
                        q2.add(new allLast(ix, iy, cnt + 1));
                    }
                    else if(visit2[iy][ix] == 0 && map2[iy][ix] != 0 && map2[iy][ix] != check){
                        if(min > cnt)
                            min = cnt;
                        return;
                    }
                }
            }
        }
    }

    static void bfs(int cnt){
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();
            for(int i = 0; i < 4; i++){
                int ix = x + dx[i];
                int iy = y + dy[i];
                if(ix >= 0 && ix < N && iy >= 0 && iy < N){
                    if(visit[iy][ix] == 0 && map[iy][ix] != 0){
                        map2[iy][ix] = cnt;
                        visit[iy][ix] = 1;
                        q2.add(new allLast(ix, iy, 0));
                        q.add(new allBlue(ix, iy));
                    }
                }
            }
        }
    }

    static  class allLast{
        int x;
        int y;
        int cnt;
        public allLast(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static class allBlue{
        int x;
        int y;
        public allBlue(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
