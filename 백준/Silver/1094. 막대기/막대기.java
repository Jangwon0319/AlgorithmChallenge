import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        // 나눌 수 있는 막대기 길이
        int[] arr = {64,32,16,8,4,2,1};
        int len = 0;

        // 막대기 갯수 및 합한 길이
        int count = 0;
        int total = 0;
        
        while (x != 0){
            
            // 먼저 가장 큰 막대기 길이 64부터 계산
            total = arr[len];
            
            // 만약 원하는 길이보다 크다? 막대기 길이 줄이기
            if (x < total){
                len++;
            }
            
            // 만약 원하는 길이보다 작다? 막대기 갯수 증가 및 x 길이 감소
            else {
                x = x - total;
                count++;
            }

        }
        System.out.println(count);
    }
}