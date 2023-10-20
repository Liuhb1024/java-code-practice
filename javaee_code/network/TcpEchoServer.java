package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 刘浩彬
 * @date 2023/10/20
 */
public class TcpEchoServer {
    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动！");
        while (true){
            // 通过 accept 方法，把内核中已经建立好的连接拿到应用程序中
            // 建立连接的细节流程都是内核自动完成的，应用程序只需要 ”捡现成的“
            Socket clientSocket = serverSocket.accept();

        }
    }
}
