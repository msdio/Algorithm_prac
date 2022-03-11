import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, ans = 0;
    static int[] col;


    //입력받는 함수
    static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //BufferedReader를 사용하기 위한 예외처리
        try {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            col = new int[N+1];

        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    //재귀 함수
    static void rec_func(int row) {
        if(row ==N+1) {
            ans++;
        }
        else {
            for(int i=1; i<=N; i++) {
                boolean val = true;
                for(int j=1; j<row; j++) {
                    if(i == col[j]
                        || row+i == j+col[j]
                        || row-i == j-col[j])
                    {
                        val = false;
                    }
                }
                
                if(val) {
                    col[row] = i;
                    rec_func(row+1);
                    
                    col[row] = 0; //사용 후 초기화
                }

            }
        }


    }


    public static void main(String[] args) {
        input();

        rec_func(1);

        System.out.println(ans);
    }

}