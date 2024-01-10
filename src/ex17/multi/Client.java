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
            Socket socket = new Socket("localhost", 30000);
            Scanner sc = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);

            // 2. 메세지 전송 스레드
            new Thread(() -> {
                while (true){
                    String keyboardMsg = sc.nextLine();
                    pw.println(keyboardMsg);
                }
            }).start();

            // 3. 메세지 읽기 스레드

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
