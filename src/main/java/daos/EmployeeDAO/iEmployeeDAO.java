package daos.EmployeeDAO;

import entities.Employee;

import java.sql.SQLException;
import java.util.List;

public interface iEmployeeDAO {
    public List<Employee> getAll() throws SQLException;

    public Employee select(int id) throws SQLException;

    public boolean add(Employee employee) throws SQLException;

    public boolean update(Employee employee) throws SQLException;

    public boolean delete(int id) throws SQLException;

    public List<Employee> search(String search, String criteria) throws SQLException;

    public Employee logIn(String account, String password) throws SQLException;

    public boolean isExisted(String account) throws SQLException;
}
