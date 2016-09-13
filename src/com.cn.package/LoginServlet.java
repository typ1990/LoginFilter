import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by typ on 2016/9/13.
 */
@WebServlet(name ="LoginServlet",urlPatterns = "/servlet/Loginservlet")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username=req.getParameter("username");
        String password=req.getParameter("password");
        System.out.println("name:"+username);
        if("admin".equals(username)&&"admin".equals(password)){
           HttpSession httpSession= req.getSession();
           httpSession.setAttribute("username", username);
            resp.sendRedirect(req.getContextPath()+"/success.jsp");
//            req.getRequestDispatcher("/success.jsp").forward(req, resp);
        }else{
            resp.sendRedirect(req.getContextPath()+"/fail.jsp");
        }

    }
}
