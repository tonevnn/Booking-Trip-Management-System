package daos.BookingOfficeDAO;


import entities.BookingOffice;
import entities.ParkingLot;
import entities.Trip;
import utils.BookingSQL;
import utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAOimp implements BookingDAO {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    @Override
    public List<BookingOffice> getAllBooking() throws SQLException {
        List<BookingOffice> list = new ArrayList<>();
        try {
            conn = DBUtils.getInstance().getConnection();
            ps = conn.prepareStatement(BookingSQL.getAllBooking);
            rs = ps.executeQuery();
            while (rs.next()) {
                BookingOffice b = BookingOffice.builder()
                        .officeId(rs.getInt(1))
                        .endContractDeadline(rs.getDate(2))
                        .officeName(rs.getString(3))
                        .officePhone(rs.getString(4))
                        .officePlace(rs.getString(5))
                        .officePrice(rs.getDouble(6))
                        .startContractDeadline(rs.getDate(7))
                        .tripId(rs.getInt(8)).build();
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean addBooking(Date end, String name, String phone, String place, Double price, Date start, int tripId) {

        try {
            conn = DBUtils.getInstance().getConnection();
            ps = conn.prepareStatement(BookingSQL.addBooking);
            ps.setDate(1, end);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, place);
            ps.setDouble(5, price);
            ps.setDate(6, start);
            ps.setInt(7, tripId);
            int n = ps.executeUpdate();
            if (n > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<BookingOffice> getAllPlace() throws SQLException {
        List<BookingOffice> list = new ArrayList<>();
        try {
            conn = DBUtils.getInstance().getConnection();
            ps = conn.prepareStatement(BookingSQL.listPlace);
            rs = ps.executeQuery();
            while (rs.next()) {
                BookingOffice b = BookingOffice.builder()
                        .officePlace(rs.getString(1)).build();
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Trip> getAllDestination() throws SQLException {
        List<Trip> list = new ArrayList<>();
        try {
            conn = DBUtils.getInstance().getConnection();
            ps = conn.prepareStatement(BookingSQL.listTrip);
            rs = ps.executeQuery();
            while (rs.next()) {
                Trip t = Trip.builder()
                        .tripId(rs.getInt(1))
                        .destination(rs.getString(2))
                        .build();
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public BookingOffice getBookingbyId(int id) throws SQLException {
        BookingOffice b = null;
        try {
            conn = DBUtils.getInstance().getConnection();
            ps = conn.prepareStatement(BookingSQL.viewBooking);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = BookingOffice.builder()
                        .officeId(rs.getInt(1))
                        .endContractDeadline(rs.getDate(2))
                        .officeName(rs.getString(3))
                        .officePhone(rs.getString(4))
                        .officePlace(rs.getString(5))
                        .officePrice(rs.getDouble(6))
                        .startContractDeadline(rs.getDate(7))
                        .tripId(rs.getInt(8)).build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public void updateBooking(Date end, String name, String phone, String place, Double price, Date start, int tripId, int id) throws SQLException {
        try {
            conn = DBUtils.getInstance().getConnection();
            ps = conn.prepareStatement(BookingSQL.updateBooking);
            ps.setDate(1, end);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, place);
            ps.setDouble(5, price);
            ps.setDate(6, start);
            ps.setInt(7, tripId);
            ps.setInt(8, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBooking(int id) throws SQLException {
        try {
            conn = DBUtils.getInstance().getConnection();
            ps = conn.prepareStatement(BookingSQL.deleteBooking);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BookingOffice> searchBooking(String keyword, String criteria) throws SQLException {
        List<BookingOffice> Booking = new ArrayList<>();

        try (Connection connection = DBUtils.getInstance().getConnection()) {
            PreparedStatement preparedStatement = null;

            switch (criteria) {
                case "id":
                    preparedStatement = connection.prepareStatement(BookingSQL.searchBookingId);
                    break;
                case "name":
                    preparedStatement = connection.prepareStatement(BookingSQL.searchBookingName);
                    break;
            }

            preparedStatement.setString(1, keyword);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                BookingOffice b = BookingOffice.builder()
                        .officeId(rs.getInt(1))
                        .endContractDeadline(rs.getDate(2))
                        .officeName(rs.getString(3))
                        .officePhone(rs.getString(4))
                        .officePlace(rs.getString(5))
                        .officePrice(rs.getDouble(6))
                        .startContractDeadline(rs.getDate(7))
                        .tripId(rs.getInt(8)).build();
                Booking.add(b);
            }
            return Booking;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    public static void main(String[] args) throws SQLException {
        BookingDAOimp b = new BookingDAOimp();
        System.out.println(b.searchBooking("h", "name"));

    }
}
