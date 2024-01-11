package ex17.multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        // 커넥트 되면 바로 연결 됨
        try {
            // 1. 소켓과 버퍼 만들기
            Socket socket = new Socket("localhost", 20000);
            Scanner sc = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader br = new BufferedReader( // 버퍼달기
                    new InputStreamReader(socket.getInputStream())
            );


            // 2. 메세지 전송 스레드
            new Thread(() -> {
                while (true){
                    String keyboardMsg = sc.nextLine();
                    pw.println(keyboardMsg);
                }
            }).start();

//            BufferedReader br = new BufferedReader(
//                    new InputStreamReader(socket.getInputStream())
//            );

            // 3. 메세지 읽기 스레드
            new Thread(() -> { // 런 메서드의 스택이 달라서 다른 스택임
                while (true) {
                    try {
                        String requestMsg = br.readLine();
                        System.out.println("서버부터 받은 메세지: " + requestMsg);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
