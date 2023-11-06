package servlets.ParkingLotController;

import daos.ParkingLotDAO.ParkingLotDAOImpl;
import entities.ParkingLot;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/addParkingLot")
public class AddParkingController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ParkingLotDAOImpl lotDAO = new ParkingLotDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        try {
            List<String> list = lotDAO.getAllParkingPlace();
            req.setAttribute("place", list);
            req.getRequestDispatcher("views/ParkingLotJSP/addParkingLot.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("pName");
        String place = req.getParameter("pPlace");
        double area = Double.parseDouble(req.getParameter("pArea"));
        double price = Double.parseDouble(req.getParameter("pPrice"));

        ParkingLot lot = ParkingLot.builder()
                .parkName(name)
                .parkPlace(place)
                .parkArea(area)
                .parkPrice(price)
                .build();

        try {

            boolean check = lotDAO.addParkingLot(lot);
            if (check) {
                resp.sendRedirect("listParkingLot");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
