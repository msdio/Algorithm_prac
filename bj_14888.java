import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int max, min;
    static int[] nums, operators;
    static int[] order; //연산자들의 배열


    //입력받는 함수
    static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        StringTokenizer st;

        //BufferedReader를 사용하기 위한 예외처리
        try {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            nums = new int[N+1]; //수열
            operators = new int[5]; //연산자
            order = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) { //수열 입력받기
                nums[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<5; i++) { //연산자들 입력받기
                operators[i] = Integer.parseInt(st.nextToken());
            }

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    //재귀 함수
    static void rec_func(int k) {
        if (k==N) { //모든 연산자들 나열 완료 -> 계산만 하면 됨
            int value = cal(); //계산 결과가 result에 저장됨
            max = Math.max(max, value);
            min = Math.min(min, value);
        }
        else { //k번째 연산자 선택
            for(int i=1; i<=4; i++) {
                if(operators[i] == 0) {
                    continue;
                }
                order[k] = i;
                operators[i]--;
                rec_func(k+1);
                
                //사용 후
                operators[i]++;
                order[k] = 0;
            }
            
        }
    }


    //계산 함수
    static int cal() {
        int result = nums[1];
        for(int i=1; i<N+1; i++) { //연산자 개수만큼 반복
            if(order[i] == 1) {
                result += nums[i+1];
            }
            if(order[i] == 2) {
                result -= nums[i+1];
            }
            if(order[i] == 3) {
                result *= nums[i+1];
            }
            if(order[i] == 4) {
                result /= nums[i+1];
            }
        }

        return result;
    }


    public static void main(String args[]) {
        input();

        rec_func(1);

        sb.append(max);
        sb.append('\n');
        sb.append(min);

        System.out.println(sb.toString());
    }
}