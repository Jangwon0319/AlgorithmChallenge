import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 줄 서는 사람의 수
        int n = Integer.parseInt(br.readLine());
        // 줄 서는 사람이 각자 걸리는 시간을 담을 배열
        int[] time = new int[n];
        
        // 각자 걸리는 시간 담기
        // ex. 1번째 사람 : time[0] = 3, 2번째 사람 : time[1] = 1 ,,,,
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        // 사람 배치를 구하는 것이 아니라 시간만 구하면 된다.
        // 따라 배열을 정렬하고 오름차순이 제일 최소 시간이다.
        Arrays.sort(time);

        // temp : 각자 걸리는 시간
        // total : 총 걸리는 시간
        int temp = 0;
        int total = 0;
        for (int i : time) {
            temp += i;
            total += temp;
        }

        System.out.println(total);
    }
}
