import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int answer = 0;
    static boolean[] visited;

    static class Point {
        int v, cnt;

        public Point(int v, int cnt) {
            this.v = v;
            this.cnt = cnt;
        }
    }

    static boolean check(int x) {
        if (x < 0 || x > 100000 || visited[x]) return false;
        return true;
    }

    static void bfs(int v) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(v, 0));
        visited[v] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.v;
            int cnt = p.cnt;

            if (x == k) {
                answer = cnt;
                break;
            }

            if (check(x-1)) {
                queue.add(new Point(x - 1, cnt + 1));
                visited[x - 1] = true;
            }
            if (check(x+1)) {
                queue.add(new Point(x + 1, cnt + 1));
                visited[x + 1] = true;
            }
            if (check(x*2)) {
                queue.add(new Point(x * 2, cnt + 1));
                visited[x * 2] = true;
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 수빈이
        k = Integer.parseInt(st.nextToken()); // 동생

        // 걸으면 1초후에 x-1 또는 x+1로 이동
        // 순간이동시에는 1초 후에 2*X의 위치로 이동
        visited = new boolean[100001];
        bfs(n);

        System.out.println(answer);
    }
}