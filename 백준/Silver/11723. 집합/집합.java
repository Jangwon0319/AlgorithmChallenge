import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 연산할 횟수
        int n = Integer.parseInt(br.readLine());

        // 집합 배열 및 초기화
        int[] arr = new int[20];
        Arrays.fill(arr, 0);    // 0이면 값 X, 1이면 값 존재

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if (st.countTokens() == 2) {
                String s = st.nextToken();
                int k = Integer.parseInt(st.nextToken());

                switch (s) {
                    case "add":
                        arr[k - 1] = 1;
                        break;
                    case "remove":
                        arr[k - 1] = 0;
                        break;
                    case "check":
                        bw.write(arr[k - 1] + "\n");
                        break;
                    case "toggle":
                        arr[k - 1] = arr[k - 1] == 1 ? 0 : 1;
                        break;
                }
            } else {
                String s = st.nextToken();

                switch (s) {
                    case "all":
                        Arrays.fill(arr, 1);
                        break;
                    case "empty":
                        Arrays.fill(arr, 0);
                        break;
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
