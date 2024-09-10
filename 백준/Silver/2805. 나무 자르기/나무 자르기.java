import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 나무의 수
        int M = Integer.parseInt(st.nextToken());   // 필요한 나무 길이

        int left = 0;
        int right = -1;

        // 나무 길이 배열 입력 및 저장
        int[] trees = new int[N];
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(str1.nextToken());
            right = Math.max(right, trees[i]);
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            long tree = 0;

            // mid 높이로 잘랐을 때 얻을 수 있는 나무 길이 계산
            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) {
                    tree += (trees[i] - mid);  // 잘라낸 나무의 길이를 누적
                }
            }

            if (tree >= M) {  // 필요한 나무 길이 이상일 때
                left = mid + 1;
            } else {  // 필요한 나무 길이 미만일 때
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
