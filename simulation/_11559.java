package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _11559 {
    static String[][] map;
    static int[][] visit;
    static int[][] removeVisit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int X,Y;
    static Queue<cd> q = new LinkedList();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = 6;
        Y = 12;
        map = new String[Y][X];
        visit = new int[Y][X];

        for(int i = 0; i < 12; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < 6; j++){
                map[i][j] = str[j];
            }
        }

        int check = 0;
        int answer = 0;
        while(true) {
            int i;
            check = 0;
            visit = new int[Y][X];
            for (i = Y - 1; i >= 0; i--) {
                for (int j = 0; j < X; j++) {
                    if (visit[i][j] == 0 && map[i][j] != ".") {
                        removeVisit = new int[12][6];
                        visit[i][j] = 1;
                        removeVisit[i][j] = 1;
                        q.add(new cd(j, i));
                        check += bfs();
                    }
                }
                q.clear();
            }
            if (check > 0)
                answer++;
            else
                break;
            down();
        }
        System.out.println(answer);

    }
    static int bfs(){
        int cnt = 0;
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            cnt++;
            q.poll();

            for(int i = 0; i < 4; i++){
                int ix = x + dx[i];
                int iy = y + dy[i];
                if(ix >= 0 && ix < X && iy >= 0 && iy < Y && visit[iy][ix] == 0 && map[iy][ix].equals(map[y][x]) && !map[iy][ix].equals(".")){
                    q.add(new cd(ix, iy));
                    visit[iy][ix] = 1;
                    removeVisit[iy][ix] = 1;
                }
            }
        }
        if(cnt >= 4) {
            remove();
            return 1;
        }
        return 0;
    }

    static void remove(){
        for(int i = 0; i < Y; i++){
            for(int j = 0; j < X; j++){
                if(removeVisit[i][j] == 1)
                    map[i][j] = ".";
            }
        }
    }
    static void down(){
        int check = 0;
        int start = 0;
        for(int i = 0; i < X; i++){
            start = -1;
            check = 0;
            for(int j = Y - 1; j >= 0; j--){
                if(check == 0 && map[j][i].equals(".")) {
                    check = 1;
                    start = j;
                }
                else if(start >= 0 && map[j][i] != "."){
                    map[start][i] = map[j][i];
                    map[j][i] = ".";
                    start--;
                }
            }
        }
    }

    static class cd{
        int x, y;
        public cd(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
