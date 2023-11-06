package servlets.TicketController;

import daos.TicketDAO.TicketDAOImpl;
import daos.TicketDAO.iTicketDAO;
import daos.TripDAO.TripDAOImpl;
import daos.TripDAO.iTripDAO;
import entities.Ticket;
import entities.Trip;
import utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "TicketSearchController", urlPatterns = "/ticket-search")
public class TicketSearchController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String txtSearch = req.getParameter("txtSearch");
        String searchFilter = req.getParameter("searchFilter");
        String day = req.getParameter("day");
        String month = req.getParameter("month");
        String year = req.getParameter("year");
        iTicketDAO ticketDAO = new TicketDAOImpl();
        iTripDAO tripDAO = new TripDAOImpl();
        List<Ticket> ticketList = null;
        List<Trip> tripList = null;
        try {
            if (DateUtils.isDateValid(day + "/" + month + "/" + year)) {
                //if user not input text search => list all
                if (txtSearch == null || txtSearch.trim().length() == 0) {
                    ticketList = ticketDAO.getAllTicket();
                    tripList = tripDAO.getAllTrip();
                } else if (txtSearch != null && txtSearch.trim().length() > 0) {
                    if (searchFilter.equalsIgnoreCase("trip")) {
                        List<Trip> tripListSearch = tripDAO.getTripsByDestination(txtSearch);
                        ticketList = ticketDAO.getAllTicket();
                        List<Ticket> ticketList2 = new ArrayList<>();
                        for (Trip trip : tripListSearch) {
                            for (Ticket ticket : ticketList) {
                                if (ticket.getTripId() == trip.getTripId()) {
                                    ticketList2.add(ticket);
                                }
                            }
                        }
                        ticketList = ticketList2;
                        tripList = tripDAO.getAllTrip();
                    } else if (searchFilter.equalsIgnoreCase("licensePlate")) {
                        ticketList = ticketDAO.getTicketsByLicensePlate(txtSearch);
                        tripList = tripDAO.getAllTrip();
                    } else if (searchFilter.equalsIgnoreCase("customer")) {
                        ticketList = ticketDAO.getTicketsByCustomerName(txtSearch);
                        tripList = tripDAO.getAllTrip();
                    } else if (searchFilter.equalsIgnoreCase("bookingTime")) {
                        Pattern pattern = Pattern.compile("^([0-1][0-9]|[2][0-3]):([0-5][0-9])$");
                        Matcher matcher = pattern.matcher(txtSearch);
                        if (matcher.find()) {
                            ticketList = ticketDAO.getTicketsByBookingTime(txtSearch);
                            tripList = tripDAO.getAllTrip();
                        } else {
                            req.setAttribute("message", "Input for Booking Time must follow: HH:MM!");
                        }
                    }
                }
            } else {
                req.setAttribute("message", "Date invalid!");
                ticketList = ticketDAO.getAllTicket();
                tripList = tripDAO.getAllTrip();
            }
            int[] years = tripDAO.getMinAndMaxYearFromTrip();
            req.setAttribute("txtSearch", txtSearch);
            req.setAttribute("searchFilter", searchFilter);
            req.setAttribute("years", years);
            req.setAttribute("ticketList", ticketList);
            req.setAttribute("tripList", tripList);
            req.getRequestDispatcher("views/TicketJSP/TicketListJSP.jsp").forward(req, resp);
        } catch (SQLException e) {
            //ERROR
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
