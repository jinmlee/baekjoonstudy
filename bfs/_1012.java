package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class _1012 {
    static int M, N, k;
    static int[][] visit;
    static int[][] kimchi;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int count = 0;
            String[] str = br.readLine().split(" ");
            M = Integer.parseInt(str[0]);
            N = Integer.parseInt(str[1]);
            k = Integer.parseInt(str[2]);
            kimchi = new int[N][M];
            visit = new int[N][M];
            for (int j = 0; j < k; j++) {
                str = br.readLine().split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);

                kimchi[y][x] = 1;
            }

            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (kimchi[n][m] == 1 && visit[n][m] == 0) {
                        count++;
                        bfs(n, m);
                    }
                }
            }

            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
    }


    static void bfs(int n, int m){
        Queue<Integer[]> queue = new LinkedList<>();

        queue.add(new Integer[]{m, n});
        while(!queue.isEmpty()){
            int kx = queue.peek()[0];
            int ky = queue.peek()[1];
            queue.poll();
            for(int i = 0; i < 4; i++){
                m = kx + dx[i];
                n = ky + dy[i];
                if(n < N && m < M && n >= 0 && m >= 0) {
                    if (visit[n][m] == 0 && kimchi[n][m] == 1) {
                        visit[n][m] = 1;
                        queue.add(new Integer[]{m, n});
                    }
                }
            }
        }
    }
}

