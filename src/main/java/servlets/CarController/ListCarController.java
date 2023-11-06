package servlets.CarController;

import daos.BookingOfficeDAO.BookingDAO;
import daos.BookingOfficeDAO.BookingDAOimp;
import daos.CarDAO.CarDAO;
import daos.CarDAO.CarDAOConstants;
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

@WebServlet("/listCar")
public class ListCarController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CarDAO carDAO = new CarDAOimp();
    iParkingLotDAO parkingLotDAO = new ParkingLotDAOImpl();
    BookingDAO bookingDAO = new BookingDAOimp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            String indexPage = req.getParameter("index");
            if(indexPage == null){
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            int numberOfCars = carDAO.getNumberOfCars();
            int pageSize = CarDAOConstants.PAGE_SIZE_CAR;
            int endPage = numberOfCars / pageSize;
            if(numberOfCars % pageSize != 0){
                endPage++;
            }
            List<Car> list = carDAO.pagingCar(index);
            req.setAttribute("listCars",list);
            req.setAttribute("end",endPage);

            List<ParkingLot> listPark = parkingLotDAO.getAllParkingLotByStatus("Blank");
            List<BookingOffice> listCompany = bookingDAO.getAllBooking();
            req.setAttribute("parkId", listPark);
            req.setAttribute("company", listCompany);
//            List<Car> list = carDAO.getAll();
//            req.setAttribute("listCars", list);
            req.getRequestDispatcher("views/CarJSP/listCar.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}