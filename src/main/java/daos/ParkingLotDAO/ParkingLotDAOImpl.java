package daos.ParkingLotDAO;

import entities.ParkingLot;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkingLotDAOImpl implements iParkingLotDAO {
    @Override
    public List<ParkingLot> getAllParkingLot() throws SQLException {

        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ParkingLotDAOCons.PARKING_LOT_QUERY_GET_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();
            List<ParkingLot> parkingLotList = new ArrayList<>();
            while (rs.next()) {
                ParkingLot lot = ParkingLot.builder()
                        .parkId(rs.getInt("parkId"))
                        .parkName(rs.getString("parkName"))
                        .parkPlace(rs.getString("parkPlace"))
                        .parkArea(rs.getDouble("parkArea"))
                        .parkPrice(rs.getDouble("parkPrice"))
                        .parkStatus(rs.getString("parkStatus"))
                        .build();
                parkingLotList.add(lot);
            }
            return parkingLotList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public List<ParkingLot> getAllParkingLotByStatus(String status) throws SQLException {

        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ParkingLotDAOCons.PARKING_LOT_QUERY_BY_PARKING_STATUS)) {
            preparedStatement.setString(1, status);
            ResultSet rs = preparedStatement.executeQuery();
            List<ParkingLot> parkingLotList = new ArrayList<>();
            while (rs.next()) {
                ParkingLot lot = ParkingLot.builder()
                        .parkId(rs.getInt("parkId"))
                        .parkName(rs.getString("parkName"))
                        .parkPlace(rs.getString("parkPlace"))
                        .parkArea(rs.getDouble("parkArea"))
                        .parkPrice(rs.getDouble("parkPrice"))
                        .parkStatus(rs.getString("parkStatus"))
                        .build();
                parkingLotList.add(lot);
            }
            return parkingLotList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public List<String> getAllParkingPlace() throws SQLException {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ParkingLotDAOCons.PARKING_LOT_QUERY_PLACE)) {
            ResultSet rs = preparedStatement.executeQuery();
            List<String> list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getString("parkPlace"));

            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }


    @Override
    public ParkingLot getParkingLotById(int id) throws SQLException {
        try {
            Connection connection = DBUtils.getInstance().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(ParkingLotDAOCons.PARKING_LOT_QUERY_GET_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) return ParkingLot.builder()
                    .parkId(resultSet.getInt("parkId"))
                    .parkName(resultSet.getString("parkName"))
                    .parkPlace(resultSet.getString("parkPlace"))
                    .parkArea(resultSet.getDouble("parkArea"))
                    .parkPrice(resultSet.getDouble("parkPrice"))
                    .parkStatus(resultSet.getString("parkStatus"))
                    .build();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }


    @Override
    public boolean deleteParkingLot(int id) throws SQLException {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(ParkingLotDAOCons.PARKING_LOT_QUERY_DELETE_BY_ID)) {
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (
                Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public boolean addParkingLot(ParkingLot parkingLot) throws SQLException {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(ParkingLotDAOCons.PARKING_LOT_QUERY_ADD)) {
            preparedStatement.setDouble(1, parkingLot.getParkArea());
            preparedStatement.setString(2, parkingLot.getParkName());
            preparedStatement.setString(3, parkingLot.getParkPlace());
            preparedStatement.setDouble(4, parkingLot.getParkPrice());
            int result = preparedStatement.executeUpdate();
            return result > 0;

        } catch (
                Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public boolean updateParkingLot(ParkingLot parkingLot) throws SQLException {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(ParkingLotDAOCons.PARKING_LOT_QUERY_EDIT_BY_ID)) {
            preparedStatement.setDouble(1, parkingLot.getParkArea());
            preparedStatement.setString(2, parkingLot.getParkName());
            preparedStatement.setString(3, parkingLot.getParkPlace());
            preparedStatement.setDouble(4, parkingLot.getParkPrice());
            preparedStatement.setString(5, parkingLot.getParkStatus());
            preparedStatement.setInt(6, parkingLot.getParkId());
            int result = preparedStatement.executeUpdate();
            return result > 0;

        } catch (
                Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public List<ParkingLot> search(String keyword, String criteria) throws SQLException {
        List<ParkingLot> parkingLotList = new ArrayList<>();

        try (Connection connection = DBUtils.getInstance().getConnection()) {
            PreparedStatement preparedStatement = null;

            switch (criteria) {
                case "id":
                    preparedStatement = connection.prepareStatement(ParkingLotDAOCons.PARKING_LOT_QUERY_EDIT_BY_ID_CONTAINS);
                    break;
                case "name":
                    preparedStatement = connection.prepareStatement(ParkingLotDAOCons.PARKING_LOT_QUERY_BY_PARKING_NAME);
                    break;
                case "place":
                    preparedStatement = connection.prepareStatement(ParkingLotDAOCons.PARKING_LOT_QUERY_BY_PARKING_PLACE);
                    break;
                case "area":
                    preparedStatement = connection.prepareStatement(ParkingLotDAOCons.PARKING_LOT_QUERY_BY_PARKING_AREA);
                    break;
                case "price":
                    preparedStatement = connection.prepareStatement(ParkingLotDAOCons.PARKING_LOT_QUERY_BY_PARKING_PRICE);
                    break;
            }

            preparedStatement.setString(1, keyword);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ParkingLot lot = ParkingLot.builder()
                        .parkId(rs.getInt("parkId"))
                        .parkName(rs.getString("parkName"))
                        .parkPlace(rs.getString("parkPlace"))
                        .parkArea(rs.getDouble("parkArea"))
                        .parkPrice(rs.getDouble("parkPrice"))
                        .parkStatus(rs.getString("parkStatus"))
                        .build();
                parkingLotList.add(lot);
            }
            return parkingLotList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }
}
