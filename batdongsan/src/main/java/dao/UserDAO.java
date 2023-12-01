package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    public User findUserByNP(String username, String password) throws SQLException;
    public int save(User user) throws SQLException;

    public User check(User user) throws SQLException;

    List<User> findAllUser() throws SQLException;

    int deleteByUserName(String parts) throws SQLException;

    public User findByUserName(String us) throws SQLException;

    int updatefindByUser(String jsonData, User user)throws SQLException;

    int addStaff(User user) throws SQLException;
}
