import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        // 입력 받을 숫자 갯수
        int n = sc.nextInt();

        // 입력 받은 숫자를 배열에 저장
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = x;
        }

        int count = 0;

        // 소수 확인
        for (int i = 0 ; i < n; i++) {
            int prime = 0;
            // 1부터 본인 자신 숫자까지 확인
            for (int k = 1 ; k <= arr[i] ; k++){
                if (arr[i] % k == 0){
                    prime++;
                }
            }
            if (prime == 2)
                count++;
        }

        System.out.println(count);


    }
}