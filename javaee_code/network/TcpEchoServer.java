package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        ExecutorService service = Executors.newCachedThreadPool();
        while (true){
            // 通过 accept 方法，把内核中已经建立好的连接拿到应用程序中
            // 建立连接的细节流程都是内核自动完成的，应用程序只需要 ”捡现成的“
            Socket clientSocket = serverSocket.accept();
            /*
            // 此处不应该直接调用 processConnection， 会导致服务器不能处理多个客户端
            // 创建新的线程来调用
            Thread t = new Thread(()->{
                processConnection(clientSocket);
            });
            t.start();
             */
            // 更好的方法：使用线程池
            service.submit(new Runnable() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            });
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
                // 2. 根据请求， 计算响应
                String response = process(request);
                // 3. 把响应写回到客户端
                //    把 String 转成字节数组，写入到 OutputStream
                //    也可以把 PrintWriter 把 OutputStream 包裹一下， 来写入字符串
                PrintWriter printWriter = new PrintWriter(outputStream);
                // 此处的 println 不是打印到控制台了，而是写入到 outputStream 对应的流对象中，也就是写入到 clientSocket 里面
                // 自然这个数据也就通过网络发送出去 （发给当前这个连接的另外一端）
                // 此处使用 println 带有 \n 也是为了后续 客户端这边 可以使用 scanner.next 来读取数据
                printWriter.println(response);
                // 此处记得还有个操作 刷新缓冲区 如果没有刷新操作，可能数据仍然是在内存中的，没有写入网卡
                printWriter.flush();
                // 4. 打印一下这次请求交互过程的内容
                System.out.printf("[%s:%d] req=%s resp=%s\n", clientSocket.getInetAddress(),clientSocket.getPort(),request,response);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                // 在这地方，进行 clientSocket 的关闭
                // processConnection 就是在处理一个连接，这个方法执行完毕，这个连接也就处理完了
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String process(String request)  {
        // 此处也是回显服务器 响应和请求是一样的
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}










