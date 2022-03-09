import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class pracAlgo {
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] selected;


    //입력받는 함수
    static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        StringTokenizer st;

        //BufferedReader를 사용하기 위한 예외처리
        try {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            selected = new int[M+1]; //selected 배열의 크기 정하기
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    //재귀 함수
    static void rec_func(int k) {
        if(k == M+1) { //한 줄 다 끝나면 StringBuilder에 결과가 저장됨
            for(int i=1; i<=M; i++) {
                sb.append(selected[i]);
                sb.append(' ');
            }
            sb.append('\n');
        }
        else {
            for(int i=1; i<=N; i++) {
                selected[k] = i;
                rec_func(k+1);
            }
        }

    }



    public static void main(String args[]) {
        input();

        rec_func(1);

        System.out.println(sb.toString());
    }
}