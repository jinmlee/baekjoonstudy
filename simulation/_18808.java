package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _18808 {
    static int X;
    static int Y;
    static int N;
    static int[][] noteBook;
    static int[][] sticker;
    static int[][] sticker2;
    static int roCnt = 0;
    static int cnt = 0;
    static Queue<node> q = new LinkedList<>();
    static Queue<node> q2 = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        Y = Integer.parseInt(str[0]);
        X = Integer.parseInt(str[1]);
        N = Integer.parseInt(str[2]);
        int xx = 0;

        noteBook = new int[Y][X];
        for(int n = 0; n < N; n++){
//            System.out.println(n);
            str = br.readLine().split(" ");
            int x = Integer.parseInt(str[1]);
            int y = Integer.parseInt(str[0]);
//            System.out.println(x + " " + y);
            sticker = new int[y][x];
            for(int i = 0; i < y; i++){
                str = br.readLine().split(" ");
                for(int j = 0; j < x; j++){
                    sticker[i][j] = Integer.parseInt(str[j]);
                    if(sticker[i][j] == 1)
                        q.add(new node(j, i));
                }
            }
//            System.out.println(x + " " + y);
            setNoteBook(x, y);
//            System.out.println(xx++ + "z");
        }
        System.out.println(cnt);
    }

    static void setNoteBook(int dx, int dy){
//        System.out.println(dx + " " + dy);

//        for(int i = 0; i < Y; i++){
//            for(int j = 0; j < X; j++){
//                System.out.print(noteBook[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();


        roCnt++;
//        System.out.println(roCnt);
        if(roCnt > 4){
            roCnt = 0;
            q.clear();
            q2.clear();
            return;
        }
        for(int i = 0; i < Y - dy + 1; i++) {
            for (int j = 0; j < X - dx + 1; j++) {
                while (!q.isEmpty()) {
                    int x = q.peek().x;
                    int y = q.peek().y;


                    if (noteBook[y + i][x + j] != 0) {
                        while (!q2.isEmpty()) {
                            int qx = q2.peek().x;
                            int qy = q2.peek().y;
                            noteBook[qy + i][qx + j] = 0;
                            q.add(q2.poll());
                            cnt--;
                        }
                        break;
                    } else {
                        noteBook[y + i][x + j] = 1;
                        cnt++;
                        q2.add(new node(x, y));

                    }
                    q.poll();
                    if (q.isEmpty()) {
                        q2.clear();
                        roCnt = 0;
                        return ;
                    }

                }
            }
        }
        q.clear();
        rotation(dx, dy);
        setNoteBook(dy, dx);

    }

    static void rotation(int dx, int dy){
        sticker2 = new int[dx][dy];

        for(int y = 0; y < dy; y++){
            for(int x = 0; x < dx; x++){
                sticker2[x][dy - 1 - y] = sticker[y][x];
                if(sticker2[x][dy - 1 - y] == 1)
                    q.add(new node(dy - 1 - y, x));
            }
        }
        sticker = new int[dx][dy];
        sticker = sticker2.clone();

//        for(int i = 0; i < dx; i++){
//            for(int j = 0; j < dy; j++){
//                System.out.print(sticker[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();
    }

    static class node{
        int x;
        int y;
        public node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
