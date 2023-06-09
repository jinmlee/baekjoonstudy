package simulation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15686 {
    static int N;
    static int M;
    static int[][] home;
    static int[][] chicken = new int[13][2];
    static int[][] choice;
    static int[][] map;
    static int[] visit = new int[13];
    static int homeIdx = 0;
    static int chickenIdx = 0;
    static int count = 1000000;
    static int lastidx = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        map = new int[N][N];
        home = new int[2*N][2];
        choice = new int[M][2];
        for(int y = 0; y < N; y++){
            str = br.readLine().split(" ");
            for(int x = 0; x < N; x++){
                map[y][x] = Integer.parseInt(str[x]);
                if(map[y][x] == 1){
                    home[homeIdx][0] = y;
                    home[homeIdx][1] = x;
                    homeIdx++;
                }
                if(map[y][x] == 2){
                    chicken[chickenIdx][0] = y;
                    chicken[chickenIdx][1] = x;
                    chickenIdx++;
                }
            }
        }
        mainFun(M);
        System.out.println(count);
    }

    static void mainFun(int cnt){

        if(cnt == 0){
            int distanceCnt = distance();
            if(count > distanceCnt)
                count = distanceCnt;
            return;
        }
        lastidx++;
        //System.out.println(lastidx);
        for(int i = lastidx; i < chickenIdx + 1 - cnt; i++){
            ///////////////////
            for(int p = 0; p < chickenIdx; p++){
                System.out.print(visit[p] + " ");
            }
            System.out.println();
            System.out.println("i : " + i);
            System.out.println("lastidx : " + lastidx);
            System.out.println();
            /////////////////////
            if(visit[i] == 1)
                continue;
            if(visit[i] == 0) {
                visit[i] = 1;
                choice[M - cnt][0] = chicken[i][0];
                choice[M - cnt][1] = chicken[i][1];
            }
            mainFun(cnt - 1);
            visit[i] = 0;
        }
        lastidx--;
    }

    static int distance(){
        int distanceCnt = 0;
        for(int i = 0; i < homeIdx; i++){
            int min = 1000000;
            for(int j = 0; j < M; j++){
                int cnt = op(i, j);
                if(min > cnt)
                    min = cnt;
            }
            distanceCnt += min;
        }
        return distanceCnt;
    }

    static int op(int i, int j){
        int cnt = 0;
        int y = choice[j][0] - home[i][0];
        int x = choice[j][1] - home[i][1];

        if(y < 0)
            y *= -1;
        if(x < 0)
            x *= -1;
        cnt = y + x;
        return cnt;
    }
}
