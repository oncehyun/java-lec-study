package ch03;
//팩토리얼 계산하기
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        long fact=1;
        int n;

        System.out.print("정수를 입력하시오.");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        for(int i=1;i<=n;i++){
            fact=fact*i;

        }
        System.out.printf("%d!은 %d입니다.\n",n,fact);
    }
}
