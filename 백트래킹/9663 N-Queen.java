import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] col;
    static int cnt = 0;

    static boolean check(int y) {
        for (int i = 0; i < y; i++) { // y행 이전의 행들 비교
            if (col[y] == col[i] || Math.abs(y - i)==Math.abs(col[y] - col[i])) // 같은 열에 퀸이 있거나 대각선에 있으면
                return false;
        }
        return true;
    }

    static void dfs(int y) {
        if (y == n) { // n번째 행까지 퀸 n개를 다 놓았다면
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            col[y] = i; // y번째 행의 i번째 열에 퀸을 배치
            if (check(y)) dfs(y + 1); // 다음 행에 놓을 수 있다면 퀸 배치
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        // nxn 체스판에 퀸 n개를 공격 못하게 놓기 

        col = new int[n]; // col[index] = i --> index번째 행의 i번째 열에 퀸이 있음

        dfs(0); // 0번째 행부터 탐색
        System.out.println(cnt);
    }
}