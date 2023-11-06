package daos.TicketDAO;

import entities.Ticket;
import utils.DBUtils;
import utils.DateUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAOImpl implements iTicketDAO {
    @Override
    public List<Ticket> getAllTicket() throws SQLException {
        List<Ticket> ticketList = new ArrayList<>();
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement pstm = connection.prepareStatement(TicketDAOCons.TICKET_QUERY_GET_ALL)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Ticket ticket = Ticket.builder()
                        .ticketId(rs.getInt("ticketId"))
                        .bookingTime(rs.getTime("bookingTime"))
                        .customerName(rs.getString("customerName"))
                        .licensePlate(rs.getString("licensePlate"))
                        .tripId(rs.getInt("tripId"))
                        .build();
                ticketList.add(ticket);
            }
            return ticketList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public boolean insertTicket(Ticket ticket) throws SQLException {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement pstm = connection.prepareStatement(TicketDAOCons.TICKET_QUERY_INSERT)) {
            pstm.setTime(1, DateUtils.convertJavaDateToSQLTime(ticket.getBookingTime()));
            pstm.setString(2, ticket.getCustomerName());
            pstm.setString(3, ticket.getLicensePlate());
            pstm.setInt(4, ticket.getTripId());
            int n = pstm.executeUpdate();
            return n > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public Ticket getTicketByTicketId(String ticketId) throws SQLException {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement pstm = connection.prepareStatement(TicketDAOCons.TICKET_QUERY_GET_BY_TICKETID)) {
            pstm.setString(1, ticketId);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return Ticket.builder()
                        .ticketId(rs.getInt("ticketId"))
                        .bookingTime(rs.getTime("bookingTime"))
                        .customerName(rs.getString("customerName"))
                        .licensePlate(rs.getString("licensePlate"))
                        .tripId(rs.getInt("tripId"))
                        .build();
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }
//
//    @Override
//    public boolean updateTicket(Ticket ticket) throws SQLException {
//        try(Connection connection = DBUtils.getInstance().getConnection();
//            PreparedStatement pstm = connection.prepareStatement(TicketDAOCons.TICKET_QUERY_UPDATE)){
//            pstm.setTime(1,DateUtils.convertJavaDateToSQLTime(ticket.getBookingTime()));
//            pstm.setString(2, ticket.getCustomerName());
//            pstm.setString(3,ticket.getLicensePlate());
//            pstm.setInt(4,ticket.getTripId());
//            pstm.setInt(5,ticket.getTicketId());
//            int n = pstm.executeUpdate();
//            return n > 0;
//        }catch (SQLException e){
//            e.printStackTrace();
//            throw new SQLException();
//        }
//    }

    @Override
    public boolean removeTicketByTicketId(String ticketId) throws SQLException {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement pstm = connection.prepareStatement(TicketDAOCons.TICKET_QUERY_REMOVE_BY_TICKETID)) {
            pstm.setString(1, ticketId);
            int n = pstm.executeUpdate();
            return n > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public String getTripIdByTicketId(String ticketId) throws SQLException {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement pstm = connection.prepareStatement(TicketDAOCons.TICKET_QUERY_GET_TRIPID_BY_TICKETID)) {
            pstm.setString(1, ticketId);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getString("tripId");
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public List<Ticket> getTicketsByCustomerName(String customerName) throws SQLException {
        List<Ticket> ticketList = new ArrayList<>();
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement pstm = connection.prepareStatement(TicketDAOCons.TICKET_QUERY_GET_TICKETS_BY_CUSTOMERNAME)) {
            pstm.setString(1, customerName);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Ticket ticket = Ticket.builder()
                        .ticketId(rs.getInt("ticketId"))
                        .bookingTime(rs.getTime("bookingTime"))
                        .customerName(rs.getString("customerName"))
                        .licensePlate(rs.getString("licensePlate"))
                        .tripId(rs.getInt("tripId"))
                        .build();
                ticketList.add(ticket);
            }
            return ticketList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public List<Ticket> getTicketsByLicensePlate(String licensePlate) throws SQLException {
        List<Ticket> ticketList = new ArrayList<>();
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement pstm = connection.prepareStatement(TicketDAOCons.TICKET_QUERY_GET_TICKETS_BY_LICENSEPLATE)) {
            pstm.setString(1, licensePlate);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Ticket ticket = Ticket.builder()
                        .ticketId(rs.getInt("ticketId"))
                        .bookingTime(rs.getTime("bookingTime"))
                        .customerName(rs.getString("customerName"))
                        .licensePlate(rs.getString("licensePlate"))
                        .tripId(rs.getInt("tripId"))
                        .build();
                ticketList.add(ticket);
            }
            return ticketList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public List<Ticket> getTicketsByBookingTime(String bookingTime) throws SQLException {
        List<Ticket> ticketList = new ArrayList<>();
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement pstm = connection.prepareStatement(TicketDAOCons.TICKET_QUERY_GET_TICKETS_BY_BOOKINGTIME)) {
            pstm.setString(1, bookingTime);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Ticket ticket = Ticket.builder()
                        .ticketId(rs.getInt("ticketId"))
                        .bookingTime(rs.getTime("bookingTime"))
                        .customerName(rs.getString("customerName"))
                        .licensePlate(rs.getString("licensePlate"))
                        .tripId(rs.getInt("tripId"))
                        .build();
                ticketList.add(ticket);
            }
            return ticketList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    public static void main(String[] args) {
        iTicketDAO ticketDAO = new TicketDAOImpl();
        try {
            String s = ticketDAO.getTripIdByTicketId("9");
            System.out.println(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
