package dao;

import model.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDAO {
    public List<Category> findAllCategory()throws SQLException;
}
