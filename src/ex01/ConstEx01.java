package ex01;

public class ConstEx01 {
    public static void main(String[] args) {
        int num=1; //변수
        final int sum=10; //상수 (변경 불가능)
        num=2;
        //sum=20; 변경 불가능
    }
}