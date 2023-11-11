import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 刘浩彬
 * @date 2023/11/11
 */

@WebServlet("/hello") // 配置路由
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 这个打印是显示在 Tomcat 的控制台上 （服务器）
        System.out.println("Hello World");
        // 把内容显示在页面上，把 “Hello World” 字符串作为 http 的响应的 body 部分
        // 这个部分就会被浏览器显示在页面上
        resp.getWriter().write("Hello World");
    }
}
