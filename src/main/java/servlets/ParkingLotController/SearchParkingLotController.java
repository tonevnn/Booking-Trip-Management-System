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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/searchParkingLot")
public class SearchParkingLotController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ParkingLotDAOImpl lotDAO = new ParkingLotDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        try {
            String keyword = req.getParameter("keyword").trim();
            String criteria = req.getParameter("criteria");
            List<ParkingLot> list;
            if (keyword.equals("")) {
                list = lotDAO.getAllParkingLot();
            } else {
                list = lotDAO.search(keyword, criteria);
            }
            req.setAttribute("ListParkingLot", list);
            req.setAttribute("keyword", keyword);
            req.setAttribute("criteria", criteria);
            req.getRequestDispatcher("views/ParkingLotJSP/listParkingLot.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
