package dao;

import dao.util.ConnectionUtil;
import dao.util.SQLQuery;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    public List<Category> findAllCategory() throws SQLException {
        List<Category> categoryList=new ArrayList<>();
        Connection conn= ConnectionUtil.getNewConnection();
        PreparedStatement ps= conn.prepareStatement(SQLQuery.SQL_SELECT_ALL_CATEGORY);
        ResultSet rs= ps.executeQuery();
        try{
            while(rs.next()){
                String categoryId = rs.getString(1);
                String categoryName = rs.getString(2);
                Category category=new Category(categoryId,categoryName);
                categoryList.add(category);
            }
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return categoryList;
    }
}
