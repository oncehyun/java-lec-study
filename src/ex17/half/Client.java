package ex17.half;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        // 커넥트 되면 바로 연결 됨
        try {
            Socket socket = new Socket("localhost", 20000);

            PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);

            pw.println("3"); // requestMsg 요청 메세지




            // 버퍼 만들기
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            String responseMag = br.readLine();  //
            System.out.println("서버로부터 받은 메세지: " + responseMag);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
