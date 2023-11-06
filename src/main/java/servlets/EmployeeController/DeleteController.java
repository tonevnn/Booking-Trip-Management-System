package servlets.EmployeeController;

import daos.EmployeeDAO.EmployeeDAOImpl;
import daos.EmployeeDAO.iEmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete-emp")
public class DeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    iEmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            employeeDAO.delete(id);
            resp.sendRedirect(req.getContextPath() + "/list-emp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
