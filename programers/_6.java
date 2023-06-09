package programers;

import java.util.*;

public class _6 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<target> q = new LinkedList<>();
    static String[][] map;
    static int[][] visit;
    static int X;
    static int Y;
    public static void main(String[] args) {
        String[] bord = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};

        map = new String[bord.length][bord[0].length()];
        visit = new int[bord.length][bord[0].length()];


        for(int i = 0; i < bord.length; i++){
            String[] str = bord[i].split("");
            for(int j = 0; j < str.length; j++){
                map[i][j] = str[j];
                if(map[i][j].contains("R")) {
                    q.add(new target(j, i, 0));
                }
            }
        }
        Y = map.length;
        X = map[0].length;

        int answer = bfs();
        System.out.println(answer);
    }

    static int bfs(){
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            int cnt = q.peek().cnt;

            if(map[y][x].contains("G"))
                return cnt;

            q.poll();

            for(int i = 0; i < 4; i++){
                int ix = x;
                int iy = y;
                while(true){
                    if(ix + dx[i] < 0 || iy + dy[i] < 0 || ix + dx[i] > X - 1 || iy + dy[i] > Y - 1 || map[iy + dy[i]][ix + dx[i]].contains("D")) {
                        if (visit[iy][ix] == 0) {
                            q.add(new target(ix, iy, cnt + 1));
                            visit[iy][ix] = 1;
                        }
                        break;
                    }
                    ix += dx[i];
                    iy += dy[i];
                }
            }
        }
        return -1;
    }

    static class target{
        int x;
        int y;
        int cnt;
        public target(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
