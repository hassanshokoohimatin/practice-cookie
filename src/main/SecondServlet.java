import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "second", urlPatterns = "/second")
public class SecondServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        for (Cookie cookie : req.getCookies()){
            if (cookie.getName().equals("test_cookie")){
                String name = cookie.getValue();
                PrintWriter out = resp.getWriter();
                out.write("<html>");
                out.write("<body>");
                out.write("<h3>" + name + "</h3>");
                out.write("</body>");
                out.write("</html>");
            }
        }
    }
}

