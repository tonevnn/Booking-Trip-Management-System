package daos.CarDAO;

import entities.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarDAO {
    List<Car> getAll() throws SQLException;

    boolean add(Car licensePlate) throws SQLException;

    boolean update(Car licensePlate) throws SQLException;

    boolean delete(String licensePlate) throws SQLException;

    Car getCarByLicensePlate(String licensePlate) throws SQLException;

    List<Car> search(String search, String criteria) throws SQLException;

    List<String> getAllParkId() throws SQLException;

    List<String> getAllCompany() throws SQLException;

    int getNumberOfCars() throws SQLException;

    List<Car> pagingCar(int index) throws SQLException;

    List<String> getAllLicensePlate() throws SQLException;
}