import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufReader scan = new BufReader();

    static int N, S;
    static int[] a;
    static int ans = 0; //정답


    //입력받는 함수
    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();

        a = new int[N];
        for(int i=0; i<N; i++) {
            a[i] = scan.nextInt();
        }
    }


    static void func(int k, int sum) {
        if(k == N) { //부분 수열이 완성되었을 경우
            if(sum == S) { //정답과 같은지 확인
                ans++;
            }
        }
        else {
            //k번째를 포함하는 경우
            func(k+1, sum+a[k]);

            //k번째를 포함하지 않는 경우
            func(k+1, sum);
        }
    }
    
    


    public static void main(String[] args) {
        input();

        func(0, 0);

        //0인 경우에는 빼야함
        if(S == 0) {
            ans--;
        }

        System.out.println(ans);
    }



    //buffered reader 이용
    static class BufReader {
        BufferedReader br;
        StringTokenizer st;

        public BufReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

    }

}