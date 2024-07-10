class Solution {
    public long[] solution(long n) {
    
        String str = Long.toString(n);
        
        long[] answer = new long[str.length()];
        
        int i = 0;
        
        while(n != 0){
            long temp = n % 10;
            answer[i] = temp;
            i++;
            
            n = n / 10;
        }
        
        return answer;
        
    }
}