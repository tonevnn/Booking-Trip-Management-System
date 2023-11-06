package daos.EmployeeDAO;

import entities.Employee;
import utils.DBUtils;
import utils.DateUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements iEmployeeDAO {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private CallableStatement callableStatement = null;
    private ResultSet resultSet = null;

    @Override
    public List<Employee> getAll() throws SQLException {
        List<Employee> list = new ArrayList<>();
        Employee employee = null;
        try {
            connection = DBUtils.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(Constants.EMPLOYEE_GET_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = Employee.builder()
                        .employeeId(resultSet.getInt(1))
                        .account(resultSet.getString(2))
                        .department(resultSet.getString(3))
                        .employeeAddress(resultSet.getString(4))
                        .employeeBirthdate(DateUtils.convertStringToDate2(resultSet.getString(5)))
                        .employeeEmail(resultSet.getString(6))
                        .employeeName(resultSet.getString(7))
                        .employeePhone(resultSet.getString(8))
                        .password(resultSet.getString(9))
                        .sex(resultSet.getString(10))
                        .build();
                list.add(employee);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public Employee select(int id) throws SQLException {
        Employee employee = null;
        try {
            connection = DBUtils.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(Constants.EMPLOYEE_GET_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = Employee.builder()
                        .employeeId(resultSet.getInt(1))
                        .account(resultSet.getString(2))
                        .department(resultSet.getString(3))
                        .employeeAddress(resultSet.getString(4))
                        .employeeBirthdate(DateUtils.convertStringToDate2(resultSet.getString(5)))
                        .employeeEmail(resultSet.getString(6))
                        .employeeName(resultSet.getString(7))
                        .employeePhone(resultSet.getString(8))
                        .password(resultSet.getString(9))
                        .sex(resultSet.getString(10))
                        .build();
                return employee;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
        return null;
    }

    @Override
    public boolean add(Employee employee) throws SQLException {
        try {
            connection = DBUtils.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(Constants.EMPLOYEE_ADD);
            preparedStatement.setString(1, employee.getAccount());
            preparedStatement.setString(2, employee.getDepartment());
            preparedStatement.setString(3, employee.getEmployeeAddress());
            preparedStatement.setDate(4, DateUtils.convertJavaDateToSqlDate(employee.getEmployeeBirthdate()));
            preparedStatement.setString(5, employee.getEmployeeEmail());
            preparedStatement.setString(6, employee.getEmployeeName());
            preparedStatement.setString(7, employee.getEmployeePhone());
            preparedStatement.setString(8, employee.getPassword());
            preparedStatement.setString(9, employee.getSex());
            int result = preparedStatement.executeUpdate();
            if (result > 0) return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public boolean update(Employee employee) throws SQLException {
        try {
            connection = DBUtils.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(Constants.EMPLOYEE_UPDATE);
            preparedStatement.setString(1, employee.getAccount());
            preparedStatement.setString(2, employee.getDepartment());
            preparedStatement.setString(3, employee.getEmployeeAddress());
            preparedStatement.setDate(4, DateUtils.convertJavaDateToSqlDate(employee.getEmployeeBirthdate()));
            preparedStatement.setString(5, employee.getEmployeeEmail());
            preparedStatement.setString(6, employee.getEmployeeName());
            preparedStatement.setString(7, employee.getEmployeePhone());
            preparedStatement.setString(8, employee.getPassword());
            preparedStatement.setString(9, employee.getSex());
            preparedStatement.setInt(10, employee.getEmployeeId());
            int result = preparedStatement.executeUpdate();
            if (result > 0) return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        try {
            connection = DBUtils.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(Constants.EMPLOYEE_DELETE);
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            if (result > 0) return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public List<Employee> search(String search, String criteria) throws SQLException {
        List<Employee> list = new ArrayList<>();
        Employee employee = null;
        try {
            connection = DBUtils.getInstance().getConnection();
            if (criteria.equals("name"))
                preparedStatement = connection.prepareStatement(Constants.EMPLOYEE_GET_BY_NAME);
            if (criteria.equals("address"))
                preparedStatement = connection.prepareStatement(Constants.EMPLOYEE_GET_BY_ADDRESS);
            if (criteria.equals("phone"))
                preparedStatement = connection.prepareStatement(Constants.EMPLOYEE_GET_BY_PHONE);
            if (criteria.equals("dept"))
                preparedStatement = connection.prepareStatement(Constants.EMPLOYEE_GET_BY_DEPARTMENT);
            if (criteria.equals("email"))
                preparedStatement = connection.prepareStatement(Constants.EMPLOYEE_FIND_BY_EMAIL);
            preparedStatement.setString(1, search);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = Employee.builder()
                        .employeeId(resultSet.getInt(1))
                        .account(resultSet.getString(2))
                        .department(resultSet.getString(3))
                        .employeeAddress(resultSet.getString(4))
                        .employeeBirthdate(DateUtils.convertStringToDate2(resultSet.getString(5)))
                        .employeeEmail(resultSet.getString(6))
                        .employeeName(resultSet.getString(7))
                        .employeePhone(resultSet.getString(8))
                        .password(resultSet.getString(9))
                        .sex(resultSet.getString(10))
                        .build();
                list.add(employee);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public Employee logIn(String account, String password) throws SQLException {
        Employee employee = null;
        try {
            connection = DBUtils.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(Constants.EMPLOYEE_LOGIN);
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = Employee.builder()
                        .employeeId(resultSet.getInt(1))
                        .account(resultSet.getString(2))
                        .department(resultSet.getString(3))
                        .employeeAddress(resultSet.getString(4))
                        .employeeBirthdate(DateUtils.convertStringToDate2(resultSet.getString(5)))
                        .employeeEmail(resultSet.getString(6))
                        .employeeName(resultSet.getString(7))
                        .employeePhone(resultSet.getString(8))
                        .password(resultSet.getString(9))
                        .sex(resultSet.getString(10))
                        .build();
                return employee;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public boolean isExisted(String account) throws SQLException {
        try {
            connection = DBUtils.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(Constants.EMPLOYEE_FIND_BY_ACCOUNT);
            preparedStatement.setString(1, account);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }
}
