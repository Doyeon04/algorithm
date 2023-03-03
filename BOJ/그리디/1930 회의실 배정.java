import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Time implements Comparable<Time>{

    public int start, end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Time o) {
        if(this.end == o.end) return this.start - o.start;
        return this.end - o.end;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Time> list = new ArrayList<>();

        StringTokenizer st;
        while(n-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Time(start, end));
        }
        Collections.sort(list);

        int meetingEnd = 0;
        int cnt = 0;

        for(Time t : list){
            if(t.start >= meetingEnd){
                cnt++;
                meetingEnd = t.end;
            }
        }
        System.out.println(cnt);
    }
}