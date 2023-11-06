package servlets.CarController;

import daos.BookingOfficeDAO.BookingDAO;
import daos.BookingOfficeDAO.BookingDAOimp;
import daos.CarDAO.CarDAO;
import daos.CarDAO.CarDAOimp;
import daos.ParkingLotDAO.ParkingLotDAOImpl;
import daos.ParkingLotDAO.iParkingLotDAO;
import entities.BookingOffice;
import entities.Car;
import entities.ParkingLot;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/addCar")
public class AddCarController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CarDAO carDAO = new CarDAOimp();
    iParkingLotDAO parkingLotDAO = new ParkingLotDAOImpl();
    BookingDAO bookingDAO = new BookingDAOimp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            List<ParkingLot> listPark = parkingLotDAO.getAllParkingLotByStatus("Blank");
            List<BookingOffice> listCompany = bookingDAO.getAllBooking();
            req.setAttribute("parkId", listPark);
            req.setAttribute("company", listCompany);
            req.getRequestDispatcher("views/CarJSP/addCar.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String licensePlate = req.getParameter("licensePlate");
        String carColor = req.getParameter("carColor");
        String carType = req.getParameter("carType");
        int company = Integer.parseInt(req.getParameter("company"));
        int parkId = Integer.parseInt(req.getParameter("parkId"));

        Car car = Car.builder()
                .licensePlate(licensePlate)
                .carColor(carColor)
                .carType(carType)
                .company(company)
                .parkId(parkId).build();
        try {
            List<ParkingLot> listPark = parkingLotDAO.getAllParkingLotByStatus("Blank");
            List<BookingOffice> listCompany = bookingDAO.getAllBooking();
            req.setAttribute("parkId", listPark);
            req.setAttribute("company", listCompany);
            if (carDAO.getCarByLicensePlate(licensePlate) != null) {
                req.setAttribute("ERROR", "This license plate is already existed.");
            } else {
                boolean check = carDAO.add(car);
                if (check) {
                    req.setAttribute("NOTI", "Add successfully");
                } else {
                    req.setAttribute("ERROR", "ERROR! Add failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("views/CarJSP/addCar.jsp").forward(req, resp);
    }
}
