package devkook.study.socket.server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by diginori on 2014. 5. 4..
 */
public class Work implements Runnable{
    Socket socket;

    public Work(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            InputStreamReader in = new InputStreamReader(socket.getInputStream());

            char[] rBuf = new char[1000];
            int readMsg = in.read(rBuf);

            String msg = String.valueOf(rBuf).trim();

            System.out.println("read : [" + msg + "]");

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            out.println("무슨 뜻이지 ? 쉽게 다시 알려 주세요 : D => " + readMsg);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("Oh, dear me! " + e);
        }
    }
}
