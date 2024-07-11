import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N > 500 || N < 0)
            throw new IOException("숫자 범위에 어긋납니다");

        BigInteger result = factorial(N);

        // 숫자 -> 문자열 -> char 배열
        String str = result.toString();
        char[] arr = str.toCharArray();

        int count = 0;

        // 0의 갯수 파악(뒤에서 부터 파악한다!)
        // 마지막 자리가 0이여야 시작
        if (arr[arr.length-1] == '0') {
            for (int i = arr.length - 1; i > 0; i--) {
                if (arr[i] == '0')
                    count++;
                else
                    break;
            }
        }
        // 아니면 그냥 0
        else
            count = 0;

        System.out.println(count);

    }

    // factorial 함수
    public static BigInteger factorial(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        return fact;
    }
}
