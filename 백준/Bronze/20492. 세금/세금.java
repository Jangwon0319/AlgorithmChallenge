import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // 상금의 금액
        int N = sc.nextInt();

        // 예외 처리
        if (N > 10000000 || N < 1000){
            throw new Exception("상금의 범위에 어긋납니다.");
        }

        if (N % 1000 != 0){
            throw new Exception("N은 1000의 배수입니다.");
        }

        int a = (int) (N - (N * 0.22));
        int b = (int) (N - ((N * 0.2) * 0.22));


        System.out.printf("%d %d", a, b);
    }
}
