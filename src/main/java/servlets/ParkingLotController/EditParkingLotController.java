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

@WebServlet("/editParkingLot")
public class EditParkingLotController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ParkingLotDAOImpl lotDAO = new ParkingLotDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            List<String> list = lotDAO.getAllParkingPlace();
            ParkingLot parkingLot = lotDAO.getParkingLotById(id);
            req.setAttribute("place", list);
            req.setAttribute("parkingLot", parkingLot);
            req.getRequestDispatcher("views/ParkingLotJSP/editParkingLot.jsp").forward(req, resp);
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
        String pStatus = req.getParameter("status");
        int id = Integer.parseInt(req.getParameter("pId"));

        ParkingLot lot = ParkingLot.builder()
                .parkId(id)
                .parkName(name)
                .parkPlace(place)
                .parkArea(area)
                .parkPrice(price)
                .parkStatus(pStatus)
                .build();

        try {

            boolean check = lotDAO.updateParkingLot(lot);
            if (check) {
                resp.sendRedirect("listParkingLot");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
