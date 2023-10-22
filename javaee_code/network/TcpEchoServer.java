package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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
            processConnection(clientSocket);

        }
    }

    // 通过这个方法 处理当前的连接
    public void processConnection(Socket clientSocket){
        // 进入方法 先打印一个日志，表示当前的客户端连上了
        //System.out.println(String.format("[%s:%d] 客户端上线!\n", clientSocket.getInetAddress(), clientSocket.getPort()));
        System.out.printf("[%s:%d] 客户端上线!\n",clientSocket.getInetAddress(),clientSocket.getPort());
        //接下来进行数据的交互
        try(InputStream inputStream =  clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream()){
            // 使用 try ( ) 的方式，避免后续用完了流对象，忘记关闭
            // 由于客户端发来的数据，可能是 “多条数据” ，针对多条数据，就按循环来处理
            while(true){
                Scanner scanner = new Scanner(inputStream);
                if (!scanner.hasNext()){
                    // 如果连接断开了，此时循环就应该结束
                    System.out.printf("[%s:%d] 客户端下线\n", clientSocket.getInetAddress(),clientSocket.getPort());
                    break;
                }
                // 1. 读取请求并解析， 此处就以 next 来作为读取请求的方式。 next 的规则是， 读到 “空白符” 就返回
                String request = scanner.next();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
