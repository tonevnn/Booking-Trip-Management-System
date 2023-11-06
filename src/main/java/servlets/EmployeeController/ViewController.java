package servlets.EmployeeController;

import daos.EmployeeDAO.EmployeeDAOImpl;
import daos.EmployeeDAO.iEmployeeDAO;
import entities.Employee;
import utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

@WebServlet("/view-emp")
public class ViewController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    iEmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Employee employee = employeeDAO.select(id);
            req.setAttribute("employee", employee);
            req.setAttribute("bday", DateUtils.convertJavaDateToSqlDate(employee.getEmployeeBirthdate()));
            req.getRequestDispatcher("views/EmployeeJSP/view.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String fullName = req.getParameter("name");
        String phone = req.getParameter("phone");
        Date bDay = null;
        try {
            bDay = DateUtils.convertStringToDate2(req.getParameter("bday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String sex = req.getParameter("sex");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String dept = req.getParameter("dept");
        Employee employee = Employee.builder()
                .employeeId(id)
                .employeeName(fullName)
                .employeePhone(phone)
                .employeeBirthdate(bDay)
                .sex(sex)
                .employeeAddress(address)
                .employeeEmail(email)
                .account(account)
                .password(password)
                .department(dept)
                .build();
        try {
            req.setAttribute("employee", employee);
            req.setAttribute("bday", DateUtils.convertJavaDateToSqlDate(employee.getEmployeeBirthdate()));
            if (!employeeDAO.search(phone, "phone").isEmpty() && !phone.equals(employeeDAO.select(id).getEmployeePhone())) {
                req.setAttribute("ERROR", "This phone is already existed.");
            } else if (!employeeDAO.search(email, "email").isEmpty() && !email.equals(employeeDAO.select(id).getEmployeeEmail())) {
                req.setAttribute("ERROR", "This email is already existed.");
            } else {
                boolean check = employeeDAO.update(employee);
                if (check) {
                    req.setAttribute("bday", DateUtils.convertJavaDateToSqlDate(employee.getEmployeeBirthdate()));
                    req.setAttribute("NOTI", "Update successfully");
                    req.setAttribute("employee", employee);
                } else {
                    req.setAttribute("ERROR", "ERROR! Update failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("views/EmployeeJSP/view.jsp").forward(req, resp);
    }
}
