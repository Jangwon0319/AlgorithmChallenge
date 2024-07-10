class Solution {
    boolean solution(String s) {
        
        // 문자열을 char[] 배열로 변환
        char[] str = s.toCharArray();
        
        // p,P 와 y,Y가 나온 횟수를 저장
        int[] arr = {0,0};
        
        for(int i = 0 ; i < str.length; i++){
            if(str[i] == 'p' || str[i] == 'P')
                arr[0]++;
            else if(str[i] == 'y' || str[i] == 'Y')
                arr[1]++;
        }
        
        
        
        boolean answer = true;
        
        if(arr[0] == arr[1])
            answer = true;
        else
            answer = false;
       
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(answer);

        return answer;
    }
}