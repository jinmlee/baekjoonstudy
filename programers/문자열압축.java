package programers;

public class 문자열압축 {
    public static void main(String[] args) {
      String s = "abcabcdede";
      int min = s.length();
      for(int i = 1; i < s.length() / 2 + 1; i++){

          int size = s.length();
          int cnt = 1;
          int start = 0;
          int back = start + i;
          while(back + i <= s.length()){
              int j;
              for(j = 0; j < i; j++){
                if(s.charAt(start + j) != s.charAt(back + j))
                    break;
              }
              if(j == i) {
//                  System.out.println(start + " " + back + " " + i);
//                  if(back + j == s.length())
//                      size++;
                  cnt++;
                  size -= i;
              }else{
                  if(cnt > 1) {
                      int CNT = 0;
                      while (cnt > 0) {
                          CNT++;
                          cnt /= 10;
                      }
                      size += CNT;
                  }
//                  System.out.println(cnt);
                  cnt = 1;
              }
                  start += i;
                  back += i;
          }
          if(cnt > 1){
              int CNT = 0;
              while (cnt > 0){
                  CNT++;
                  cnt /= 10;
              }
              size += CNT;
          }
          if(size < min)
              min = size;
      }
        System.out.println(min);
    }
}
