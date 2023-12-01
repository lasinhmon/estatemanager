package dao;

import model.Estate;

import java.sql.SQLException;
import java.util.List;

public interface EstateDAO {
    public List<Estate> findAllEstate()throws SQLException;
    public Estate findById(int id) throws SQLException;

    public int save(Estate estate) throws SQLException;

    public int updatefindById(int i, Estate estate) throws SQLException;

    public int deleteById(int id) throws SQLException;

    public List<Estate> findByPidCid(int id, String cid,String price) throws SQLException;

    public int updateStatusEstates(int estateId) throws SQLException;
    public int updateStatusEstates2(int estateId) throws SQLException;
}
