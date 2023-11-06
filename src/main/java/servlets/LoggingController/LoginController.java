package servlets.LoggingController;

import daos.EmployeeDAO.EmployeeDAOImpl;
import daos.EmployeeDAO.iEmployeeDAO;
import entities.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    iEmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/Login/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("psw");
        String remember = req.getParameter("remember");
        Employee employee = Employee.builder()
                .account(account)
                .password(password)
                .build();
        try {
            Employee loginEmp = employeeDAO.logIn(employee.getAccount(), employee.getPassword());
            if (loginEmp != null) {
                HttpSession session = req.getSession();
                session.setAttribute("loginEmp", loginEmp);
                if (Objects.equals(remember, "yes")) {
                    session.setAttribute("rememberAccount", account);
                    session.setAttribute("rmbCheck", "yes");
                } else {
                    session.removeAttribute("rememberAccount");
                    session.setAttribute("rmbCheck", "no");
                }
                if (loginEmp.getDepartment().equals("employee")) {
                    resp.sendRedirect(req.getContextPath() + "/employeehome");
                } else {
                    resp.sendRedirect(req.getContextPath() + "/parkinghome");
                }
            } else {
                req.setAttribute("registerEmp", employee);
                req.setAttribute("NOTI", "Incorrect username or password");
                req.getRequestDispatcher("views/Login/login.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
