import java.io.*;
import java.util.*;

public class Main {

    static int L, C;
    static char[] alphabet;
    static char[] code;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new char[C];
        code = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }

        // 알파벳 순서 정렬
        Arrays.sort(alphabet);

        DFS(0,0);

        bw.flush();
        bw.close();


    }

    public static void DFS(int start, int depth) throws IOException {
        // 최소 조건 만족하는 지를 확인한다
        if (depth == L) {
            if (isValid()) {
                bw.write(String.valueOf(code) + "\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            code[depth] = alphabet[i];
            DFS(i + 1, depth + 1);
        }

    }

    private static boolean isValid() {
        int mo = 0;
        int ja = 0;
        for (char c : code) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                mo++;
            }
            else {
                ja++;
            }
        }

        return mo >= 1 && ja >= 2;
    }
}
