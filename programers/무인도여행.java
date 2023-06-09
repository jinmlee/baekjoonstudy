package programers;

import java.util.*;


public class 무인도여행 {
    static int[][] board;
    static int[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int X, Y;
    static Queue<island> q = new LinkedList<>();
    static PriorityQueue<Integer> food = new PriorityQueue<>(Comparator.comparing(o -> o));
    public static void main(String[] args) {
        String[] map = {"X591X","X1X5X","X231X", "1XXX1"};
        int[] answer;



        X = map[0].length();
        Y = map.length;

        board = new int[Y][X];
        visit = new int[Y][X];

        for(int y = 0; y < Y; y++){
            String[] str = map[y].split("");
            for(int x = 0; x < X; x++){
                if(str[x].contains("X"))
                    board[y][x] = 0;
                else
                    board[y][x] = Integer.parseInt(str[x]);
            }
        }

        for(int y = 0; y < Y; y++){
            for(int x = 0; x < X; x++){
                if(visit[y][x] == 0 && board[y][x] > 0){
                    q.add(new island(x, y));
                    visit[y][x] = 1;
                    food.add(bfs());
                }
            }
        }

        if(food.isEmpty()){
            answer = new int[1];
            answer[0] = -1;
        }
        else {
            answer = new int[food.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = food.poll();
                System.out.println(answer[i]);
            }
        }
    }

    static int bfs(){
        int food = 0;
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;

            q.poll();
            food += board[y][x];

            for(int i = 0; i < 4; i++){
                int ix = x + dx[i];
                int iy = y + dy[i];

                if(ix >= 0 && ix < X && iy >= 0 && iy < Y && visit[iy][ix] == 0 && board[iy][ix] > 0){
                    q.add(new island(ix, iy));
                    visit[iy][ix] = 1;
                }
            }
        }
        return food;
    }

    static class island{
        int x, y;
        public island(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
