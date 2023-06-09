package programers;

public class 삼각달팽이 {
    static int[][] map;
    static int num = 1;
    static int size;
    public static void main(String[] args) {
        int n = 4;
        int[] answer = {};

        int answersize = 0;
        for(int i = 1; i <= n; i++){
            answersize += i;
        }
        answer = new int[answersize];
        size = n;
        map = new int[n][n];

        run(0, 0, n);

        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] > 0){
                    answer[idx] = map[i][j];
                    System.out.print(answer[idx] + " ");
                    idx++;
                }else
                    System.out.print("  ");
            }
            System.out.println();
        }
        for(int i = 0; i < answersize; i++){
            System.out.println(answer[i]);
        }
    }

    static void run(int x, int y, int n){
        int i = x;
        int j;
        for(j = y; j < n; j++){
            map[j][x] = num;
            num++;
        }
        j--;
        i++;
        while(i + 1 < n && map[j][i + 1] == 0){
            map[j][i] = num;
            num++;
            i++;
        }
        while(j > y){
            map[j][i] = num;
            num++;
            j--;
            i--;
        }
        i++;
        j+=2;
        if(i < size && j < size && map[i][j] == 0)
            run(x + 1, y + 2, n - 1);

    }
}