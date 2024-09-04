import java.io.*;
import java.util.*;

public class Main {
    static int[][] result = new int[6][3];  // 각 팀의 [승, 무, 패] 결과 저장
    static int[][] tempResult = new int[6][3];  // DFS 중간 상태에서 사용할 임시 배열
    static boolean possible;                // 결과가 가능한지 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            possible = false;
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 3; k++) {
                    result[j][k] = Integer.parseInt(st.nextToken());
                    tempResult[j][k] = result[j][k];  // tempResult에 결과 복사
                }
            }

            DFS(0, 1);  // 첫 번째 팀 0과 두 번째 팀 1부터 탐색 시작
            System.out.print(possible ? "1 " : "0 ");
        }
    }

    // DFS로 모든 경우의 수를 탐색
    public static void DFS(int teamA, int teamB) {
        if (teamA == 5) {  // 마지막 팀까지 경기를 마친 경우
            if (isPossible()) {
                possible = true;
            }
            return;
        }

        if (teamB == 6) {  // teamB가 6이 되면 다음 팀으로 넘어감
            DFS(teamA + 1, teamA + 2);
            return;
        }

        // 팀 A가 승리, 팀 B가 패배하는 경우
        if (tempResult[teamA][0] > 0 && tempResult[teamB][2] > 0) {
            tempResult[teamA][0]--;
            tempResult[teamB][2]--;
            DFS(teamA, teamB + 1);
            tempResult[teamA][0]++;
            tempResult[teamB][2]++;
        }

        // 팀 A와 팀 B가 무승부인 경우
        if (tempResult[teamA][1] > 0 && tempResult[teamB][1] > 0) {
            tempResult[teamA][1]--;
            tempResult[teamB][1]--;
            DFS(teamA, teamB + 1);
            tempResult[teamA][1]++;
            tempResult[teamB][1]++;
        }

        // 팀 A가 패배, 팀 B가 승리하는 경우
        if (tempResult[teamA][2] > 0 && tempResult[teamB][0] > 0) {
            tempResult[teamA][2]--;
            tempResult[teamB][0]--;
            DFS(teamA, teamB + 1);
            tempResult[teamA][2]++;
            tempResult[teamB][0]++;
        }
    }

    // 가능한 결과인지 확인
    public static boolean isPossible() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (tempResult[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
