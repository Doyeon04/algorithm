import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static int answer = 0;
    static boolean[] visited;
    static class Point implements Comparable<Point>{
        int v, cnt;

        public Point(int v, int cnt) {
            this.v = v;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            return cnt - o.cnt;
        }
    }

    static boolean check(int x) {
        if (x < 0 || x > 100000 || visited[x]) return false;
        return true;
    }

    static void bfs(int v) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.offer(new Point(v, 0));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.v;
            int cnt = p.cnt;

            visited[x] = true;

            if (x == k) {
                answer = cnt;
                break;
            }

            if (check(x-1)) {
                queue.add(new Point(x - 1, cnt + 1));
            }
            if (check(x+1)) {
                queue.add(new Point(x + 1, cnt + 1));
            }
            if (check(x*2)) {
                queue.add(new Point(x * 2, cnt));
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        bfs(n);
        System.out.println(answer);

     /*   테스트케이스
        1 2
        답 0
        1 17
        답 1
        4 6
        답 1*/
    }
}