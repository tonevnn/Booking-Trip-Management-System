package daos.BookingOfficeDAO;


import entities.BookingOffice;
import entities.ParkingLot;
import entities.Trip;
import utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface BookingDAO {
    List<BookingOffice> getAllBooking() throws SQLException;

    boolean addBooking(Date end, String name, String phone, String place, Double price, Date start, int tripId);

    List<BookingOffice> getAllPlace() throws SQLException;

    List<Trip> getAllDestination() throws SQLException;

    BookingOffice getBookingbyId(int id) throws SQLException;

    void updateBooking(Date end, String name, String phone, String place, Double price, Date start, int tripId, int id) throws SQLException;

    void deleteBooking(int id) throws SQLException;

    List<BookingOffice> searchBooking(String keyword, String criteria) throws SQLException;


}
