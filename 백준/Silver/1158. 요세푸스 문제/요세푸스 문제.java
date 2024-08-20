import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 인원 수
        int K = Integer.parseInt(st.nextToken());   // 제거되는 순서

        Queue<Integer> q = new LinkedList<>();  // int형 queue 선언
        for (int i = 1; i <= N; i++) {
            q.offer(i);

        }

        int count = 0;

        bw.write("<");

        while (!q.isEmpty()) {
            count++;
            // K번째 순서가 되면 출력
            if (count % K == 0) {
                bw.write(q.poll().toString());
                // 큐에 요소가 남아있으면 콤마 추가
                if (!q.isEmpty()) {
                    bw.write(", ");
                }
            }
            // K번째 순서가 아니면 삭제 후 바로 추가
            else {
                int k = q.poll();
                q.offer(k);
            }
        }

        bw.write(">");

        bw.flush();
        bw.close();

    }
}
