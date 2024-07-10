import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        int temp = 0;
        
        while (n != 0){
            // 나머지를 담을 공간
            temp = n % 10;
            
            // 몫 -> 다음 피연산자
            n = n / 10;
            
            answer += temp;
        }
        return answer;
    }
}