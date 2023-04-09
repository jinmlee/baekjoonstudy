package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class _7569 {
    static int M,N,H;
    static int tomato[][][];
    static int visit[][][];
    static int check[][][];
    static int[] dh = {1, -1, 0, 0, 0, 0};
    static int[] dx = {0, 0, 1, -1 ,0, 0};
    static int[] dy = {0, 0, 0, 0, 1, -1};
    public static void main(String[] argv) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        M = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);
        H = Integer.parseInt(str[2]);
        int min = 0;

        tomato = new int[H][N][M];
        visit = new int[H][N][M];
        check = new int[H][N][M];
        for(int h = 0; h < H; h++){ //토마토 값 할당 받기
            for(int n = 0; n < N; n++){
                String[] s = br.readLine().split(" ");
                for(int m = 0; m < M; m++){
                    tomato[h][n][m] = Integer.parseInt(s[m]);
                }
            }
        }
        for(int h = 0; h < H; h++){
            for(int n = 0; n < N; n++){
                for(int m = 0; m < M; m++){
                    if(visit[h][n][m] == 0 && tomato[h][n][m] == 1){ //방문하지 않았고 익은 토마토 있으면 bfs탐색
                        bfs(h, n, m);
                    }
                }
            }
        }
        for(int h = 0; h < H; h++){ //익은 토마토 확인 안익은 곳이 있으면 -1 리턴
            for(int n = 0; n < N; n++){
                for(int m = 0; m < M; m++){
                   if(tomato[h][n][m] == 0){ // 아직 0이 있다는 것은 익지 않은게 있다는 뜻
                       System.out.println(-1);
                       return;
                   }
                   if(check[h][n][m] > min)
                       min = check[h][n][m];
                }
            }
        }
        System.out.println(min);
    }

    static void bfs(int h, int n, int m){
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{h, n, m, 0});

        while(!queue.isEmpty()){
            h = queue.peek()[0];
            n = queue.peek()[1];
            m = queue.peek()[2];
            int day = queue.peek()[3];
            queue.poll();

            for(int i = 0; i < 6; i++){ // 2차원 좌 우 위 아래 탐색
                int sn = n + dy[i];
                int sm = m + dx[i];
                int sh = h + dh[i];
                if(sh >= 0 && sh < H && sn >= 0 && sm >= 0 && sn < N && sm < M) {
                    if (visit[sh][sn][sm] == 0) {
                        if (tomato[sh][sn][sm] == 0) {
                            visit[sh][sn][sm] = 1;
                            tomato[sh][sn][sm] = 1; // 토마토 익었으니 1
                            check[sh][sn][sm] = day + 1; // 토마토 익었으니 1
                            queue.add(new Integer[]{sh, sn, sm, day + 1});
                        }
                    }
                    if(check[sh][sn][sm] > day + 1){
                        check[sh][sn][sm] = day + 1; //더 가까운 곳에 익은 토마토가 있다면 그 토마토 기준으로 다시 날짜 초기화
                        queue.add(new Integer[]{sh, sn, sm, day + 1});
                    }
                }
            }
        }
    }
}
