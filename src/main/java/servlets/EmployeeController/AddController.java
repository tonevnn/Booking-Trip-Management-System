package servlets.EmployeeController;

import daos.EmployeeDAO.EmployeeDAOImpl;
import daos.EmployeeDAO.iEmployeeDAO;
import entities.Employee;
import utils.DBUtils;
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

@WebServlet("/add-emp")
public class AddController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    iEmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/EmployeeJSP/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            if (employeeDAO.isExisted(employee.getAccount())) {
                req.setAttribute("ERROR", "This account is already existed.");
            } else if(!employeeDAO.search(phone,"phone").isEmpty()) {
                req.setAttribute("ERROR", "This phone is already existed.");
            } else if(!employeeDAO.search(email,"email").isEmpty() && !email.equals("")) {
                req.setAttribute("ERROR", "This email is already existed.");
            } else {
                boolean check = employeeDAO.add(employee);
                if (check) {
                    req.setAttribute("NOTI", "Add successfully");
                } else {
                    req.setAttribute("ERROR", "ERROR! Add failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("views/EmployeeJSP/add.jsp").forward(req, resp);
    }
}
