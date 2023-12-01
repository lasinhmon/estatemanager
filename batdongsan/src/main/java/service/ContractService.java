package service;



import model.Contract;

import java.util.List;

public interface ContractService {
    public List<Contract> findAllContract();
    public Contract findContractById(int id);
    public int saveContract(Contract contract);

    public int updateContractfindById(int i);

    public List<Contract> findContractByDate(String part);

    public List<Contract> findNewContract(String date);

    public List<Contract> findContractByName(String part);
}
