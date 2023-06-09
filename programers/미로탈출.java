package programers;

import java.util.*;

public class 미로탈출 {
    static String[][] board;
    static int[][][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int X,Y;
    static Queue<man> q = new LinkedList<>();
    public static void main(String[] args) {
        String[] map = {"SOEOL","XXXXO","OOOOO","OXXXX","OOOOO"};
        int answer = 0;

        X = map[0].length();
        Y = map.length;

        board = new String[Y][X];
        visit = new int[Y][X][2];
        for(int y = 0; y < Y; y++){
            String[] str = map[y].split("");
            for(int x = 0; x < X; x++){
                board[y][x] = str[x];
                if(board[y][x].contains("S"))
                    q.add(new man(x, y, 0,0));
            }
        }

        answer = bfs();
        System.out.println(answer);
    }

    static int bfs(){
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            int cnt = q.peek().cnt;
            int check = q.peek().check;

            if(board[y][x].contains("E") && check == 1)
                return cnt;

            q.poll();

            for(int i = 0; i < 4; i++){
                int ix = x + dx[i];
                int iy = y + dy[i];
                if(ix >= 0 && ix < X && iy >= 0 && iy < Y && visit[iy][ix][check] == 0 && !(board[iy][ix].contains("X"))){
                    if(board[iy][ix].contains("L")) {
                        q.add(new man(ix, iy, cnt + 1, 1));
                        visit[iy][ix][1] = 1;
                    }
                    else {
                        q.add(new man(ix, iy, cnt + 1, check));
                        visit[iy][ix][check] = 1;
                    }
                }
            }
        }
        return -1;
    }

    static class man{
        int x,y,cnt,check;
        public man(int x, int y, int cnt, int check){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.check = check;
        }
    }
}
