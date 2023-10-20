package network;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author 刘浩彬
 * @date 2023/10/20
 */
// 基于 echoserver 的一个翻译服务器

public class UdpDictServer extends UdpEchoServer{
    private Map<String, String> dict = new HashMap<>();

    public UdpDictServer(int port) throws SocketException {
        super(port);

        // 此处我们就可以在这个表里面插入几千几万的英文单词
        dict.put("dog", "小狗");
        dict.put("cat", "小猫");
        dict.put("pig", "小猪");
    }

    // 重写 process 方法， 在重写的方法中完成翻译的过程
    // 翻译本质上就是查表
    @Override
    public String process(String request) {
        return dict.getOrDefault(request,"该词在词典中不存在");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer server = new UdpDictServer(9090);
        server.start();//这个不就是多态吗？
    }
}
