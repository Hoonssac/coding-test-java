import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2852 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int team1 = 0;
        int team2 = 0;
        int team1G = 0;
        int team2G = 0;
        int lastTime = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            String[] str = st.nextToken().split(":");
            int nowTime = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);

            if (team1G > team2G) {
                team1 += nowTime - lastTime;
            } else if (team1G < team2G) {
                team2 += nowTime - lastTime;
            }

            if (team == 1) {
                team1G++;
            }
            else {
                team2G++;
            }

            lastTime = nowTime;

        }
        if (lastTime < 2880) {
            if (team1G > team2G) {
                team1 += (2880 - lastTime);
            }
            else if (team1G < team2G) {
                team2 += (2880 - lastTime);
            }
        }


        System.out.println(String.format("%02d:%02d", team1/60, team1%60));
        System.out.println(String.format("%02d:%02d", team2/60, team2%60));

    }
}
