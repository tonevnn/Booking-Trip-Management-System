package daos.EmployeeDAO;

public class Constants {
    public static String EMPLOYEE_GET_ALL = "SELECT * FROM employee";
    public static String EMPLOYEE_GET_BY_ID = "SELECT * FROM employee WHERE employeeId = ?";
    public static String EMPLOYEE_GET_BY_NAME = "SELECT * FROM employee WHERE employeeName like '%'+?+'%'";
    public static String EMPLOYEE_GET_BY_ADDRESS = "SELECT * FROM employee WHERE employeeAddress like '%'+?+'%'";
    public static String EMPLOYEE_GET_BY_PHONE = "SELECT * FROM employee WHERE employeePhone like '%'+?+'%'";
    public static String EMPLOYEE_GET_BY_DEPARTMENT = "SELECT * FROM employee WHERE department like '%'+?+'%'";
    public static String EMPLOYEE_ADD = "INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?)";
    public static String EMPLOYEE_UPDATE = "UPDATE employee\n" +
            "SET account = ?,\n" +
            "department = ?,\n" +
            "employeeAddress = ?,\n" +
            "employeeBirthdate = ?,\n" +
            "employeeEmail = ?,\n" +
            "employeeName = ?,\n" +
            "employeePhone = ?,\n" +
            "password = ?,\n" +
            "sex = ? \n" +
            "WHERE employeeId = ?";
    public static String EMPLOYEE_DELETE = "DELETE FROM employee WHERE employeeId = ?";
    public static String EMPLOYEE_LOGIN = "SELECT * FROM employee WHERE account = ? and password = ?";
    public static String EMPLOYEE_FIND_BY_ACCOUNT = "SELECT * FROM employee WHERE account = ?";
    public static String EMPLOYEE_FIND_BY_EMAIL = "SELECT * FROM employee WHERE employeeEmail = ?";
}
