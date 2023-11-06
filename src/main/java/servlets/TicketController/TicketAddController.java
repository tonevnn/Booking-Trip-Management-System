package servlets.TicketController;

import daos.CarDAO.CarDAO;
import daos.CarDAO.CarDAOimp;
import daos.TicketDAO.TicketDAOCons;
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
import java.util.List;

@WebServlet(name = "TicketAddController", urlPatterns = "/ticket-add")
public class TicketAddController extends HttpServlet {
    iTicketDAO ticketDAO = new TicketDAOImpl();
    iTripDAO tripDAO = new TripDAOImpl();
    CarDAO carDAO = new CarDAOimp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Trip> tripList = tripDAO.getAllValidTrip();
            req.setAttribute("tripList", tripList);
            List<String> licensePlateList = carDAO.getAllLicensePlate();
            req.setAttribute("licensePlateList", licensePlateList);
            req.getRequestDispatcher("views/TicketJSP/TicketAddJSP.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            //ERROR
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String txtCustomer = req.getParameter("txtCustomer");
        String txtBookingTime = req.getParameter("txtBookingTime");
        String txtTrip = req.getParameter("txtTrip");
        String txtLicensePlate = req.getParameter("txtLicensePlate");

        if (txtCustomer == null || txtBookingTime == null || txtTrip == null || txtLicensePlate == null ||
                txtCustomer.trim().length() == 0 || txtBookingTime.trim().length() == 0 || txtTrip.trim().length() == 0 || txtLicensePlate.trim().length() == 0
        ) {
            //ERROR
        } else {
            try {
                Ticket ticket = Ticket.builder()
                        .customerName(txtCustomer)
                        .bookingTime(DateUtils.convertStringToTime(txtBookingTime))
                        .tripId(Integer.parseInt(txtTrip))
                        .licensePlate(txtLicensePlate)
                        .build();
                if (ticketDAO.insertTicket(ticket)) {
                    if (tripDAO.updateBookedTicketByTripId(txtTrip, 1)) {
                        req.setAttribute("message", TicketDAOCons.SUCCESS);
                    } else {
                        req.setAttribute("message", TicketDAOCons.FAIL);
                    }
                } else {
                    req.setAttribute("message", TicketDAOCons.FAIL);
                }
                List<Trip> tripList = tripDAO.getAllTrip();
                req.setAttribute("tripList", tripList);
                List<String> licensePlateList = carDAO.getAllLicensePlate();
                req.setAttribute("licensePlateList", licensePlateList);
                req.getRequestDispatcher("views/TicketJSP/TicketAddJSP.jsp").forward(req, resp);
            } catch (ParseException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
