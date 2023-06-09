package programers;

public class 피로도 {
    static int dunSize = 0;
    static int cnt = 0;
    static int[] visit;
    static int min = 1000;
    public static void main(String[] args) {
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        int k = 80;
        int answer = -1;

        dunSize = dungeons.length;
        visit = new int[dunSize];
        fun(k, 0, dungeons);
        for(int i = 0; i < dunSize; i++){
            if(min > dungeons[i][0]){
                min = dungeons[i][0];
            }
        }
        answer = cnt;
        System.out.println(cnt);
    }
    static void fun(int k, int clear, int[][] dungeons){
        if(cnt < clear)
            cnt = clear;
        if(k < min){
            return;
        }
        for(int i = 0; i < dunSize; i++){
            System.out.println(k + " " + dungeons[i][0]);
            if(visit[i] == 0 && dungeons[i][0] <= k){
                visit[i] = 1;
                fun(k - dungeons[i][1], clear + 1, dungeons);
                visit[i] = 0;
            }
        }
    }
}
