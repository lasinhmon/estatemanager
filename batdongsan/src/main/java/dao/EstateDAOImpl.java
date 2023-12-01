package dao;

import dao.util.ConnectionUtil;
import dao.util.SQLQuery;
import model.Estate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstateDAOImpl implements EstateDAO {

    @Override
    public List<Estate> findAllEstate() throws SQLException {
        List<Estate> estateList=new ArrayList<>();
        Connection conn= ConnectionUtil.getNewConnection();
        PreparedStatement ps= conn.prepareStatement(SQLQuery.SQL_SELECT_ALL_ESTATE);
        ResultSet rs= ps.executeQuery();
        try{
            while(rs.next()){
                int estateId = rs.getInt(1);
                String projectId = rs.getString(2);
                String categoryId = rs.getString(3);
                long price = rs.getLong(4);
                String statusId= rs.getString(5);
                Estate estate=new Estate(estateId,projectId,categoryId,price,statusId);
                estateList.add(estate);
            }
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return estateList;
    }

    @Override
    public Estate findById(int id) throws SQLException {
        Estate estate=new Estate();
        Connection conn= ConnectionUtil.getNewConnection();
        PreparedStatement ps= conn.prepareStatement(SQLQuery.SQL_FIND_ESTATE_BY_ID);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        try {
            while (rs.next()) {
                int estateId = rs.getInt(1);
                String projectId = rs.getString(2);
                String categoryId = rs.getString(3);
                long price = rs.getLong(4);
                String statusId= rs.getString(5);
                estate = new Estate(estateId, projectId, categoryId, price, statusId);
                return estate;
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
    public int save(Estate estate) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionUtil.getNewConnection();
            ps = conn.prepareStatement(SQLQuery.SQL_ADD_ESTATE);
            ps.setString(1, estate.getProjectId());
            ps.setString(2, estate.getCategoryId());
            ps.setLong(3, estate.getPrice());
            ps.setString(4, estate.getStatusId());
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
    public int updatefindById(int i, Estate estate) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionUtil.getNewConnection();
            ps = conn.prepareStatement(SQLQuery.SQL_UPDATE_BY_ID);
            ps.setString(1, estate.getProjectId());
            ps.setString(2, estate.getCategoryId());
            ps.setLong(3, estate.getPrice());
            ps.setString(4, estate.getStatusId());
            ps.setInt(5, i);
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
    public int deleteById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionUtil.getNewConnection();
            ps = conn.prepareStatement(SQLQuery.SQL_DELETE_BY_ID);
            ps.setInt(1, id);
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
    public List<Estate> findByPidCid(int id, String cid,String pric) throws SQLException {
        List<Estate> estateList=new ArrayList<>();
        Connection conn= ConnectionUtil.getNewConnection();
        PreparedStatement ps= conn.prepareStatement(SQLQuery.SQL_FIND_ESTATE_BY_PID_CID);
        ps.setInt(1, id);
        ps.setString(2, cid);
        ps.setString(3,pric);
        ResultSet rs= ps.executeQuery();
        try{
            while(rs.next()){
                int estateId = rs.getInt(1);
                String projectId = rs.getString(2);
                String categoryId = rs.getString(3);
                long price = rs.getLong(4);
                String statusId= rs.getString(5);
                Estate estate=new Estate(estateId,projectId,categoryId,price,statusId);
                estateList.add(estate);
            }
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return estateList;
    }

    @Override
    public int updateStatusEstates(int estateId) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionUtil.getNewConnection();
            ps = conn.prepareStatement(SQLQuery.SQL_UPDATE_ESTATESTATUS_ID);
            ps.setInt(1, estateId);
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
    public int updateStatusEstates2(int estateId) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionUtil.getNewConnection();
            ps = conn.prepareStatement(SQLQuery.SQL_UPDATE_ESTATESTATUS_ID2);
            ps.setInt(1, estateId);
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
}
