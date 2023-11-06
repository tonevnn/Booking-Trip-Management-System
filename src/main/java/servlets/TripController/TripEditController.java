package servlets.TripController;

import daos.TripDAO.TripDAOCons;
import daos.TripDAO.TripDAOImpl;
import daos.TripDAO.iTripDAO;
import entities.Trip;
import utils.DBUtils;
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

@WebServlet(name = "TripEditController", urlPatterns = "/trip-edit")
public class TripEditController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tripId = req.getParameter("tripId");
        if (tripId == null || tripId.trim().length() == 0) {
            req.setAttribute("message", "Delete" + TripDAOCons.FAIL + " cause there is no param!");
            req.getRequestDispatcher("/trip-list").include(req, resp);
        } else {
            iTripDAO tripDAO = new TripDAOImpl();
            try {
                Trip trip = tripDAO.getTripByTripId(tripId);
                if (trip == null) {
                    //ERROR NO PARAM!
                } else {
                    req.setAttribute("trip", trip);
                    req.getRequestDispatcher("views/TripJSP/TripEditJSP.jsp").forward(req, resp);
                }
            } catch (SQLException e) {
                //ERROR
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tripId = req.getParameter("tripId");
        if (tripId == null || tripId.trim().length() == 0) {
            req.setAttribute("message", "Delete" + TripDAOCons.FAIL + " cause there is no param!");
            req.getRequestDispatcher("/trip-list").include(req, resp);
        } else {
            String txtDestination = req.getParameter("txtDestination");
            String txtDepartureTime = req.getParameter("txtDepartureTime");
            String txtDriver = req.getParameter("txtDriver");
            String txtCarType = req.getParameter("txtCarType");
            String txtMaximumTickerNumber = req.getParameter("txtMaximumTickerNumber");
            String txtDepartureDate = req.getParameter("txtDepartureDate");
            if (
                    txtDestination == null || txtDestination.trim().length() == 0 ||
                            txtDepartureTime == null || txtDepartureTime.trim().length() == 0 ||
                            txtDriver == null || txtDriver.trim().length() == 0 ||
                            txtCarType == null || txtCarType.trim().length() == 0 ||
                            txtMaximumTickerNumber == null || txtMaximumTickerNumber.trim().length() == 0 ||
                            txtDepartureDate == null || txtDepartureDate.trim().length() == 0
            ) {
//                req.setAttribute("message", "Edit" + TripDAOCons.FAIL + " cause fields are empty!");
//                req.getRequestDispatcher("views/TripJSP/TripListJSP.jsp").forward(req, resp);
            } else {
                try {
                    Trip trip = Trip.builder()
                            .tripId(Integer.parseInt(tripId))
                            .carType(txtCarType)
                            .departureDate(DateUtils.convertStringToDate(txtDepartureDate))
                            .departureTime(DateUtils.convertStringToTime(txtDepartureTime))
                            .destination(txtDestination)
                            .driver(txtDriver)
                            .maximumOnlineTicketNumber(Integer.parseInt(txtMaximumTickerNumber))
                            .build();
                    System.out.println(trip);
                    iTripDAO tripDAO = new TripDAOImpl();
                    if (tripDAO.updateTrip(trip)) {
                        req.setAttribute("message", TripDAOCons.SUCCESS);
                    } else {
                        req.setAttribute("message", TripDAOCons.FAIL);
                    }
                    List<Trip> tripList = tripDAO.getAllTrip();
                    int[] years = tripDAO.getMinAndMaxYearFromTrip();
                    req.setAttribute("years", years);
                    req.setAttribute("tripList", tripList);
                    req.getRequestDispatcher("views/TripJSP/TripListJSP.jsp").forward(req, resp);
                } catch (ParseException e) {
                    req.setAttribute("message",TripDAOCons.FAIL);
                    req.getRequestDispatcher("views/common/error.jsp").forward(req, resp);
                }catch (SQLException e){
                    req.setAttribute("message","Database connection error");
                    req.getRequestDispatcher("views/common/error.jsp").forward(req, resp);
                }
            }
        }
    }
}
