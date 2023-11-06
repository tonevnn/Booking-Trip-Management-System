package daos.CarDAO;

import entities.Car;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAOimp implements CarDAO {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    @Override
    public List<Car> getAll() throws SQLException {
        List<Car> list = new ArrayList<>();
        try {
            conn = DBUtils.getInstance().getConnection();
            ps = conn.prepareStatement(CarDAOConstants.CAR_GET_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Car c = Car.builder()
                        .licensePlate(rs.getString(1))
                        .carColor(rs.getString(2))
                        .carType(rs.getString(3))
                        .company(rs.getInt(4))
                        .parkId(rs.getInt(5)).build();
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    @Override
    public boolean add(Car c) throws SQLException {
        try {
            conn = DBUtils.getInstance().getConnection();
            ps = conn.prepareStatement(CarDAOConstants.CAR_ADD);
            ps.setString(1, c.getLicensePlate());
            ps.setString(2, c.getCarColor());
            ps.setString(3, c.getCarType());
            ps.setInt(4, c.getCompany());
            ps.setInt(5, c.getParkId());
            int result = ps.executeUpdate();
            if (result > 0) return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public boolean update(Car car) throws SQLException {
        try {
            conn = DBUtils.getInstance().getConnection();
            ps = conn.prepareStatement(CarDAOConstants.CAR_UPDATE);
            ps.setString(1, car.getCarColor());
            ps.setString(2, car.getCarType());
            ps.setInt(3, car.getCompany());
            ps.setInt(4, car.getParkId());
            ps.setString(5, car.getLicensePlate());
            int result = ps.executeUpdate();
            if (result > 0) return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public boolean delete(String licensePlate) throws SQLException {
        try {
            conn = DBUtils.getInstance().getConnection();
            ps = conn.prepareStatement(CarDAOConstants.CAR_DELETE);
            ps.setString(1, licensePlate);
            int result = ps.executeUpdate();
            if (result > 0) return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public Car getCarByLicensePlate(String licensePlate) throws SQLException {
        try {
            conn = DBUtils.getInstance().getConnection();
            ps = conn.prepareStatement(CarDAOConstants.CAR_SELECT_BY_LICENSE_PLATE);
            ps.setString(1, licensePlate);
            rs = ps.executeQuery();
            while (rs.next()) return Car.builder()
                    .licensePlate(rs.getString("licensePlate"))
                    .carColor(rs.getString("carColor"))
                    .carType(rs.getString("carType"))
                    .company(rs.getInt("company"))
                    .parkId(rs.getInt("parkId"))
                    .build();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public List<Car> search(String search, String criteria) throws SQLException {
        List<Car> list = new ArrayList<>();
        try {
            conn = DBUtils.getInstance().getConnection();
            if (criteria.equals("licensePlate")) ps = conn.prepareStatement(CarDAOConstants.GET_BY_LICENSE_PLATE);
            if (criteria.equals("carColor")) ps = conn.prepareStatement(CarDAOConstants.GET_BY_CAR_COLOR);
            if (criteria.equals("carType")) ps = conn.prepareStatement(CarDAOConstants.GET_BY_CAR_TYPE);
            ps.setString(1, search);
            rs = ps.executeQuery();
            while (rs.next()) {
                Car car = Car.builder()
                        .licensePlate(rs.getString(1))
                        .carColor(rs.getString(2))
                        .carType(rs.getString(3))
                        .company(rs.getInt(4))
                        .parkId(rs.getInt(5))
                        .build();
                list.add(car);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public List<String> getAllParkId() throws SQLException {
        try {
            conn = DBUtils.getInstance().getConnection();
            ps = conn.prepareStatement(CarDAOConstants.GET_ALL_PARK_ID);
            rs = ps.executeQuery();
            List<String> list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getString("parkId"));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public List<String> getAllCompany() throws SQLException {
        try {
            List<String> list = new ArrayList<>();
            list.add("1");
            list.add("2");
            list.add("3");
            list.add("4");

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public int getNumberOfCars() throws SQLException {
        int count = 0;
        try {
            conn = DBUtils.getInstance().getConnection();
            ps = conn.prepareStatement(CarDAOConstants.GET_NUMBER_OF_CARS);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public List<Car> pagingCar(int index) throws SQLException {
        List<Car> list = new ArrayList<>();
        try {
            conn = DBUtils.getInstance().getConnection();
            ps = conn.prepareStatement(CarDAOConstants.PAGING_CAR);
            ps.setInt(1, (index - 1) * CarDAOConstants.PAGE_SIZE_CAR);
            rs = ps.executeQuery();
            while (rs.next()) {
                Car c = Car.builder()
                        .licensePlate(rs.getString(1))
                        .carColor(rs.getString(2))
                        .carType(rs.getString(3))
                        .company(rs.getInt(4))
                        .parkId(rs.getInt(5)).build();
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<String> getAllLicensePlate() throws SQLException {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement pstm = connection.prepareStatement(CarDAOConstants.CAR_QUERY_GET_ALL_LICENSEPLATE)) {
            ResultSet rs = pstm.executeQuery();
            List<String> licensePlateList = new ArrayList<>();
            while (rs.next()) {
                licensePlateList.add(rs.getString("licensePlate"));
            }
            return licensePlateList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }


//    public static void main(String[] args) {
//        CarDAOimp c = new CarDAOimp();
//        try {
//            System.out.println(c.getAll().toString());
//            System.out.println(c.getNumberOfCars());
//            List<Car> list = c.pagingCar(5);
//            for(Car car : list){
//                System.out.println(car.toString());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
