import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열의 크기
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        // 수열에 포함되는 수
        StringTokenizer st = new StringTokenizer(br.readLine());   
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 덧셈 연산 이후 비교할 x
        int x = Integer.parseInt(br.readLine());

        // 수열을 정렬
        Arrays.sort(arr);

        int left = 0;          // 왼쪽 포인터
        int right = n - 1;     // 오른쪽 포인터
        int count = 0;         // 두 수의 합이 x가 되는 쌍의 개수

        // 투 포인터 알고리즘
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == x) {    // 두 수의 합이 x일 때
                count++;
                left++;        // 왼쪽 포인터 이동
                right--;       // 오른쪽 포인터 이동
            } else if (sum < x) {
                left++;        // 합이 x보다 작으면 왼쪽 포인터를 오른쪽으로 이동
            } else {
                right--;       // 합이 x보다 크면 오른쪽 포인터를 왼쪽으로 이동
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
