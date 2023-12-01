package dao;

import dao.util.ConnectionUtil;
import dao.util.SQLQuery;
import model.Contract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractDAOImpl implements ContractDAO {

    @Override
    public List<Contract> findAllContract() throws SQLException {
        List<Contract> contractList=new ArrayList<>();
        Connection conn= ConnectionUtil.getNewConnection();
        PreparedStatement ps= conn.prepareStatement(SQLQuery.SQL_SELECT_ALL_CONTRACT);
        ResultSet rs= ps.executeQuery();
        try{
            while(rs.next()){
                int contractId = rs.getInt(1);
                String userName = rs.getString(2);
                int estateId = rs.getInt(3);
                String urlContract = rs.getString(4);
                String statusContract= rs.getString(5);
                Date dateContract=rs.getDate(6);
                Date deadlineContract=rs.getDate(7);
                Contract contract=new Contract(contractId,userName,estateId,urlContract,statusContract,dateContract,deadlineContract);
                contractList.add(contract);
            }
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return contractList;
    }

    @Override
    public Contract findContractById(int id) throws SQLException {
        Contract contract=new Contract();
        Connection conn= ConnectionUtil.getNewConnection();
        PreparedStatement ps= conn.prepareStatement(SQLQuery.SQL_FIND_CONTRACT_BY_ID);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        try {
            while (rs.next()) {
                int contractId = rs.getInt(1);
                String userName = rs.getString(2);
                int estateId = rs.getInt(3);
                String urlContract = rs.getString(4);
                String statusContract= rs.getString(5);
                Date dateContract=rs.getDate(6);
                Date deadlineContract=rs.getDate(7);
                contract=new Contract(contractId,userName,estateId,urlContract,statusContract,dateContract,deadlineContract);
                return contract;
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
    public int saveContract(Contract contract) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionUtil.getNewConnection();
            ps = conn.prepareStatement(SQLQuery.SQL_ADD_CONTRACT);
            ps.setString(1, contract.getUserName());
            ps.setInt(2, contract.getEstateId());
            ps.setString(3, contract.getUrlContract());
            ps.setString(4, contract.getStatusContract());
            ps.setDate(5,contract.getDateContract());
            ps.setDate(6,contract.getDeadlineContract());

            int row = ps.executeUpdate();
            System.out.println("tao contract thanh cong");
            return row;
        }catch(SQLException e){
            System.out.println("tao contract k thanh cong");
            e.printStackTrace(System.out);
        }finally{
            ps.close();
            conn.close();
        }
        return -1;
    }

    @Override
    public int updateContractfindById(int i) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionUtil.getNewConnection();
            ps = conn.prepareStatement(SQLQuery.SQL_UPDATE_CONTRACT_BY_ID);
//            ps.setString(1, contract.getUserName());
//            ps.setInt(2, contract.getEstateId());
//            ps.setString(3, contract.getUrlContract());
//            ps.setString(4, contract.getStatusContract());
//            ps.setDate(5,contract.getDateContract());
//            ps.setDate(6,contract.getDeadlineContract());

            ps.setInt(1, i);
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
    public List<Contract> findContractByDate(String parts) throws SQLException {
        List<Contract> contractList=new ArrayList<>();
        Connection conn= ConnectionUtil.getNewConnection();
        PreparedStatement ps= conn.prepareStatement(SQLQuery.SQL_SELECT_CONTRACT_BY_DATE);
        ps.setString(1, parts);
        ResultSet rs= ps.executeQuery();
        try{
            while(rs.next()){
                int contractId = rs.getInt(1);
                String userName = rs.getString(2);
                int estateId = rs.getInt(3);
                String urlContract = rs.getString(4);
                String statusContract= rs.getString(5);
                Date dateContract=rs.getDate(6);
                Date deadlineContract=rs.getDate(7);
                Contract contract=new Contract(contractId,userName,estateId,urlContract,statusContract,dateContract,deadlineContract);
                contractList.add(contract);
            }
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return contractList;
    }

    @Override
    public List<Contract> findNewContract(String date) throws SQLException {
        List<Contract> contractList=new ArrayList<>();
        Connection conn= ConnectionUtil.getNewConnection();
        PreparedStatement ps= conn.prepareStatement(SQLQuery.SQL_SELECT_NEW_CONTRACT);
        ps.setString(1, date);
        ResultSet rs= ps.executeQuery();
        try{
            while(rs.next()){
                int contractId = rs.getInt(1);
                String userName = rs.getString(2);
                int estateId = rs.getInt(3);
                String urlContract = rs.getString(4);
                String statusContract= rs.getString(5);
                Date dateContract=rs.getDate(6);
                Date deadlineContract=rs.getDate(7);
                Contract contract=new Contract(contractId,userName,estateId,urlContract,statusContract,dateContract,deadlineContract);
                contractList.add(contract);
            }
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return contractList;
    }

    @Override
    public List<Contract> findContractByName(String part) throws SQLException {
        List<Contract> contractList=new ArrayList<>();
        Connection conn= ConnectionUtil.getNewConnection();
        PreparedStatement ps= conn.prepareStatement(SQLQuery.SQL_FIND_CONTRACT_BY_NAME);
        ps.setString(1, part);
        ResultSet rs= ps.executeQuery();
        try{
            while(rs.next()){
                int contractId = rs.getInt(1);
                String userName = rs.getString(2);
                int estateId = rs.getInt(3);
                String urlContract = rs.getString(4);
                String statusContract= rs.getString(5);
                Date dateContract=rs.getDate(6);
                Date deadlineContract=rs.getDate(7);
                Contract contract=new Contract(contractId,userName,estateId,urlContract,statusContract,dateContract,deadlineContract);
                contractList.add(contract);
            }
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return contractList;
    }
}
