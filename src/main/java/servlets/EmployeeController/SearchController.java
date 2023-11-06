package servlets.EmployeeController;

import daos.EmployeeDAO.EmployeeDAOImpl;
import daos.EmployeeDAO.iEmployeeDAO;
import entities.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/search-emp")
public class SearchController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    iEmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        String criteria = req.getParameter("criteria");
        req.setAttribute("search", search);
        req.setAttribute("criteria", criteria);
        if (search == "") resp.sendRedirect(req.getContextPath() + "/list-emp");
        else {
            try {
                List<Employee> list = employeeDAO.search(search, criteria);
                if (list.isEmpty()) {
                    req.setAttribute("ERROR", "No search result");
                } else {
                    req.setAttribute("ERROR", "");
                    req.setAttribute("listOfEmployee", list);
                }
                req.getRequestDispatcher("views/EmployeeJSP/list.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
