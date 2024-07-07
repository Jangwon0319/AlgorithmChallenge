import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 한 달 데이터 용량
        final int x = sc.nextInt();

        // 사용한 개월 수
        int m = sc.nextInt();

        int total = 0;
        int temp = 0;

        for (int i = 0; i < m; i++) {

            // 남은 용량
            total = temp + x;

            // 사용한 데이터 용량
            int p = sc.nextInt();

            // 남은 용량 - 사용 용량(이월 과정)
            temp = total - p;


        }

        System.out.println(temp + x);

        sc.close();

    }
}