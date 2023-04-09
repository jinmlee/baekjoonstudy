package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _10026 {
    static int[][] visit;
    static int[][] visit2;
    static String color[][];
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        color = new String[N][];
        int count = 0;
        int count2 = 0;
        //visit = new int[N][];

        for(int i = 0; i < N; i++){
            color[i] = br.readLine().split("");
            visit = new int[N][color[i].length];
            visit2 = new int[N][color[i].length];
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < color[i].length; j++){
                if(visit[i][j] == 0){
                    count++;
                    bfs(i, j, visit);
                }
                if(color[i][j].contains("G"))
                    color[i][j] = "R";
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < color[i].length; j++){
                if(visit2[i][j] == 0){
                    count2++;
                    bfs(i, j, visit2);
                }
            }
        }
        System.out.println(count + " " + count2);
    }

    static void bfs(int n, int m, int[][] visit){
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{n, m});

        while(!queue.isEmpty()){
            n = queue.peek()[0];
            m = queue.peek()[1];
            queue.poll();
            for(int i = 0; i < 4; i++){
                int y = n + dy[i];
                int x = m + dx[i];
                if(y >= 0 && x >= 0 && y < N && x < visit[y].length){
                    if(visit[y][x] == 0 && color[n][m].contains(color[y][x])){
                        visit[y][x] = 1;
                        queue.add(new Integer[]{y, x});
                    }
                }
            }
        }
    }
}
