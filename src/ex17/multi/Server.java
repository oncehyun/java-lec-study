package ex17.multi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        // 1. 소켓과 버퍼 만들기
        try {
            ServerSocket serverSocket = new ServerSocket(20000);
            Socket socket = serverSocket.accept();
            Scanner sc = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            //2. 메세지 쓰기 스레드
            new Thread(() -> {
                while (true){
                    String keyboardMsg = sc.nextLine();
                    pw.println(keyboardMsg);
                }
            }).start();

//            BufferedReader br = new BufferedReader(
//                    new InputStreamReader(socket.getInputStream())
//            );


            // 2. 메세지 받기 스레드
            new Thread(() -> { // 런 메서드의 스택이 달라ㅛ서 다른 스택임
                while (true) {
                    try {
                        String requestMsg = br.readLine();
                        System.out.println("클라이언트로부터 받은 메세지: " + requestMsg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


//            // 3. 보내는 메세지
//            new Thread(() -> { // 런 메서드의 스택이 달라서 다른 스택임
//                while (true) {
//                    try {
//                        String requestMsg = br.readLine();
//                        System.out.println("클라이언트로부터 보내는 메세지: " + requestMsg);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
