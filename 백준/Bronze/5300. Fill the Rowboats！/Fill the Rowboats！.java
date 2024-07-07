import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받을 숫자
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.printf("%d ", i);

            // 6번째마다 or 마지막에 "Go!" 출력
            if ( i % 6 == 0 || i == n){
                System.out.print("Go! ");
            }
        }

        sc.close();

    }
}