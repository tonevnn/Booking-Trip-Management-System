package daos.ParkingLotDAO;

import entities.ParkingLot;

import java.sql.SQLException;
import java.util.List;

public interface iParkingLotDAO {
    List<ParkingLot> getAllParkingLot() throws SQLException;

    List<ParkingLot> getAllParkingLotByStatus(String status) throws SQLException;

    List<String> getAllParkingPlace() throws SQLException;

    ParkingLot getParkingLotById(int id) throws SQLException;

    boolean deleteParkingLot(int id) throws SQLException;

    boolean addParkingLot(ParkingLot parkingLot) throws SQLException;

    boolean updateParkingLot(ParkingLot parkingLot) throws SQLException;

    List<ParkingLot> search(String search, String criteria) throws SQLException;
}
