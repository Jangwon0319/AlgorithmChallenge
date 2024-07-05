import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 테스트 횟수 변수 선언 및 입력
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            
            // N,M 사이트 갯수 선언 및 입력
            int n = sc.nextInt();
            int m = sc.nextInt();

            System.out.printf("%d\n", combination(n,m));
        }

        sc.close();
    }

    // 조합 함수
    public static BigInteger combination(int a, int b){

        int n = Math.max(a,b);
        int r = Math.min(a,b);

        BigInteger result;

        result = factorial(n).divide(factorial(r).multiply(factorial(n-r)));

        return result;

    }


    // 팩토리얼을 위한 재귀함수 선언
    public static BigInteger factorial(int n){
        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
