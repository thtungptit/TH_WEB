package service;

import java.sql.*;
import java.util.ArrayList;
import model.House;
import util.DBContext;

public class HouseService {
    private DBContext db = new DBContext();

    public ArrayList<House> searchHouses(String id, String address, String areaStr, String type) {
        ArrayList<House> list = new ArrayList<>();
        try (Connection conn = db.getConnection()) {
            StringBuilder sql = new StringBuilder("SELECT * FROM Houses WHERE 1=0");
            if (id != null && !id.isEmpty()) sql.append(" OR id = ?");
            if (address != null && !address.isEmpty()) sql.append(" OR address LIKE ?");
            if (areaStr != null && !areaStr.isEmpty()) sql.append(" OR area = ?");
            if (type != null && !type.isEmpty()) sql.append(" OR type = ?");

            PreparedStatement st = conn.prepareStatement(sql.toString());
            int index = 1;
            if (id != null && !id.isEmpty()) st.setString(index++, id);
            if (address != null && !address.isEmpty()) st.setString(index++, "%" + address + "%");
            if (areaStr != null && !areaStr.isEmpty()) st.setInt(index++, Integer.parseInt(areaStr));
            if (type != null && !type.isEmpty()) st.setString(index++, type);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new House(rs.getString("id"), rs.getString("address"), 
                                   rs.getInt("area"), rs.getString("type"), rs.getInt("sold")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void buyHouse(String id) {
        String sql = "UPDATE Houses SET sold = 1 WHERE id = ?";
        try (Connection conn = db.getConnection(); 
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}