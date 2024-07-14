import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 듣도 못한 사람
        int m = Integer.parseInt(st.nextToken());   // 보도 못한 사람

        // 듣도 못한 사람 집합 저장
        Set<String> listen = new HashSet<String>();

        for (int i = 0; i < n; i++) {
            listen.add(br.readLine());
        }

        // 보도 못한 사람 입력 및 중복 확인
        List<String> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String see = br.readLine();
            if (listen.contains(see)){
                result.add(see);
            }
        }

        // 정렬
        Collections.sort(result);

        // 출력
        bw.write(result.size() + "\n");
        for (String s : result) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();

    }
}
