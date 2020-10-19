package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 553582
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String logout = request.getParameter("logout");
        if (logout != null) {
            session.invalidate();
            request.setAttribute("message", "You have succesffully logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

        if (session.getAttribute("username") != null) {
            response.sendRedirect("home");
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AccountService accountService = new AccountService();
        User user = accountService.login(username, password);
        
        HttpSession session = request.getSession();

        if (user != null) {
            session.setAttribute("username", username);
            response.sendRedirect("home");
        } else {
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            request.setAttribute("message", "Invalid username or password");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
