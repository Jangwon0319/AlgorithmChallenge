import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 참가자 수
        int N = Integer.parseInt(br.readLine());

        // 티셔츠 사이즈 배열 + 갯수
        int[] shirts = new int[6];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < shirts.length; i++) {
            shirts[i] = Integer.parseInt(st1.nextToken());
        }

        // 티셔츠와 펜의 묶음 수 T, P
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st2.nextToken());
        int P = Integer.parseInt(st2.nextToken());

        // 티셔츠 총 묶음의 갯수
        int t_total = 0;
        for (int shirt : shirts) {
            int n = (shirt / T) + 1;

            if (shirt % T == 0) {
                n = shirt / T;
            }

            t_total += n;
        }

        // 볼펜 충 묶음 갯수 + 자루 수
        int p_total = N / P;
        int p_individual = N % P;

        System.out.println(t_total);
        System.out.printf("%d %d\n", p_total, p_individual);
    }
}
