import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int s3 = sc.nextInt();



        // 합은 3 ~ s1 + s2 + s3까지 나온다
        // arr[0] = 3이라 취하면, 총 index 갯수는 각 최댓값의 합에서 -2
        int[] arr = new int[s1 + s2 + s3 - 2];

        // 카운트 증가 반복문
        for (int i = 1; i <= s1 ; i++){
            for (int j = 1; j <= s2 ; j++){
                for (int k = 1; k <= s3; k++){
                    // 계속 새로 초기화
                    int sum = i + j + k;
                    
                    // 합이 3이다? -> 그럼 arr[0]에 카운트 증가
                    arr[sum-3]++;
                }
            }
        }

        // 가장 높은 빈도 합 구하기

        int max = 0;
        int result = 0;
        
        for (int i = 0; i < arr.length; i++){
            // 몃 번 나왔는지 확인
            if (max < arr[i]){
                max = arr[i];
                result = i + 3;
            }
        }

        System.out.println(result);

        sc.close();

    }
}