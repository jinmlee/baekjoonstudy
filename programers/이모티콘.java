package programers;

import java.util.LinkedList;
import java.util.Queue;

public class 이모티콘 {
    static int userSize;
    static int emoSize;
    static int[][] emo;
    static int[] answer1 = new int[2];
    static int[][] user;
    public static void main(String[] args) {
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};
        userSize = users.length;
        emoSize = emoticons.length;
        emo = new int[emoSize][2];
        user = users;
        for(int i = 0; i < emoSize; i++){
            emo[i][1] = emoticons[i];
        }
        arr(0);



        System.out.println(answer1[0] + " " + answer1[1]);
    }

    static void arr(int idx){
        if(idx == emoSize){
            mainFun();
            return;
        }
        for(int j = 10; j < 50; j += 10){
            emo[idx][0] = j;
            arr(idx + 1);
        }
    }

    static void mainFun(){
        int service = 0;
        int fMoney = 0;
        for(int i = 0; i < userSize; i++){
            int money = 0;
            for(int j = 0; j < emoSize; j++){
                if(user[i][0] <= emo[j][0]){
                    money += (emo[j][1] - (int)(emo[j][1] * (emo[j][0] / 100.0)));
                }
                if(money >= user[i][1]){
                    service++;
                    money = 0;
                    break;
                }
            }
            fMoney += money;
        }
        if(answer1[0] < service) {
            answer1[0] = service;
            answer1[1] = fMoney;
        }else if(answer1[0] == service && answer1[1] < fMoney){
            answer1[1] = fMoney;
        }
    }
}
