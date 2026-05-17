package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.House;
import service.HouseService; 

@WebServlet(name = "HouseServlet", urlPatterns = {"/house"})
public class HouseServlet extends HttpServlet {
    
    private HouseService houseService = new HouseService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("search".equals(action)) {
            String id = request.getParameter("id").trim();
            String address = request.getParameter("address").trim();
            String areaStr = request.getParameter("area").trim();
            String type = request.getParameter("type").trim();

            HttpSession session = request.getSession();
            session.setAttribute("s_id", id);
            session.setAttribute("s_address", address);
            session.setAttribute("s_area", areaStr);
            session.setAttribute("s_type", type);

            ArrayList<House> list = houseService.searchHouses(id, address, areaStr, type);

            request.setAttribute("data", list);
            request.getRequestDispatcher("display.jsp").forward(request, response);

        } else if ("buy".equals(action)) {
            String id = request.getParameter("id");
            houseService.buyHouse(id);
            response.sendRedirect("index.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}