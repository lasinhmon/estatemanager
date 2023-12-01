package dao;

import model.Contract;

import java.sql.SQLException;
import java.util.List;

public interface ContractDAO {
    public List<Contract> findAllContract()throws SQLException;
    public Contract findContractById(int id) throws SQLException;

    public int saveContract(Contract contract) throws SQLException;

    public int updateContractfindById(int i) throws SQLException;
    public List<Contract> findContractByDate(String parts)throws SQLException;

    public List<Contract> findNewContract(String date)throws SQLException;

    public List<Contract> findContractByName(String part)throws SQLException;
}
