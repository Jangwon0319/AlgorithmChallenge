import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(Combination(N, K));
        
    }

    public static BigInteger Combination(int n, int k) {
        BigInteger res;
        res = factorial(n).divide(factorial(k).multiply(factorial(n - k)));

        return res;
    }

    public static BigInteger factorial(int n) {
        BigInteger value = new BigInteger("1");

        for (int i = 1; i <= n; i++) {
            value = value.multiply(BigInteger.valueOf(i));
        }
        return value;
    }
}
