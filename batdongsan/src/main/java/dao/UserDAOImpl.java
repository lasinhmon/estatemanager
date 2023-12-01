package dao;

import dao.util.ConnectionUtil;
import dao.util.SQLQuery;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public User findUserByNP(String username, String password) throws SQLException {
        User user=new User();
        Connection conn= ConnectionUtil.getNewConnection();
        PreparedStatement ps= conn.prepareStatement(SQLQuery.SQL_SELECT_USERS_BY_NP);
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            String userName = rs.getString(1);
            String userPassword = rs.getString(2);
            int rolId=rs.getInt(3);
            String phoneNum=rs.getString(4);
            user=new User(userName,userPassword,rolId,phoneNum);
        }
        return user;
    }

    @Override
    public int save(User user) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionUtil.getNewConnection();
            ps = conn.prepareStatement(SQLQuery.SQL_ADD_USER);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getUserPassword());
            ps.setString(3, user.getPhoneNum());
            int row = ps.executeUpdate();
            System.out.println("tao cho thanh cong");
            return row;
        }catch(SQLException e){
            System.out.println("tao cho k thanh cong");
            e.printStackTrace(System.out);
        }finally{
            ps.close();
            conn.close();
        }
        return -1;
    }

    @Override
    public User check(User user) throws SQLException {
        User us=new User();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionUtil.getNewConnection();
            ps = conn.prepareStatement(SQLQuery.SQL_SELECT_USERS_BY_NP);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getUserPassword());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String userName = rs.getString(1);
                String userPassword = rs.getString(2);
                int rolId= rs.getInt(3);
                String phoneNum=rs.getString(4);
                us = new User(userName, userPassword,rolId,phoneNum);
                return us;
            }
        }catch(SQLException e){
            System.out.println("tao cho k thanh cong");
            e.printStackTrace(System.out);
        }finally{
            ps.close();
            conn.close();
        }
        return null;
    }

    @Override
    public List<User> findAllUser() throws SQLException{
        List<User> userList=new ArrayList<>();
        Connection conn= ConnectionUtil.getNewConnection();
        PreparedStatement ps= conn.prepareStatement(SQLQuery.SQL_SELECT_ALL_USER);
        ResultSet rs= ps.executeQuery();
        try{
            while(rs.next()){
                String userName = rs.getString(1);
                String userPassword = rs.getString(2);
                int rolId = rs.getInt(3);
                String phoneNum = rs.getString(4);
                User user=new User(userName,userPassword,rolId,phoneNum);
                userList.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return userList;
    }

    @Override
    public int deleteByUserName(String parts) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionUtil.getNewConnection();
            ps = conn.prepareStatement(SQLQuery.SQL_DELETE_BY_USERNAME);
            ps.setString(1, parts);
            int row = ps.executeUpdate();
            return row;
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            ps.close();
            conn.close();
        }
        return -1;

    }

    @Override
    public User findByUserName(String us) throws SQLException{
        User estate=new User();
        Connection conn= ConnectionUtil.getNewConnection();
        PreparedStatement ps= conn.prepareStatement(SQLQuery.SQL_FIND_USER_BY_ID);
        ps.setString(1, us);
        ResultSet rs=ps.executeQuery();
        try {
            while (rs.next()) {
                String userName = rs.getString(1);
                String userPassword = rs.getString(2);
                int rolId = rs.getInt(3);
                String phoneNum = rs.getString(4);
                User user=new User(userName,userPassword,rolId,phoneNum);
                return user;
            }
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return null;
    }

    @Override
    public int updatefindByUser(String jsonData, User user) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionUtil.getNewConnection();
            ps = conn.prepareStatement(SQLQuery.SQL_UPDATE_BY_USERNAME);
            ps.setString(1, jsonData);
            int row = ps.executeUpdate();
            return row;
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            ps.close();
            conn.close();
        }
        return -1;
    }

    @Override
    public int addStaff(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionUtil.getNewConnection();
            ps = conn.prepareStatement(SQLQuery.SQL_ADD_STAFF);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getUserPassword());
            ps.setString(3, user.getPhoneNum());
            int row = ps.executeUpdate();
            System.out.println("tao cho thanh cong");
            return row;
        }catch(SQLException e){
            System.out.println("tao cho k thanh cong");
            e.printStackTrace(System.out);
        }finally{
            ps.close();
            conn.close();
        }
        return -1;
    }
}
