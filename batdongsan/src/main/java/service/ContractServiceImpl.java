package service;

import dao.ContractDAO;
import dao.ContractDAOImpl;
import model.Contract;

import java.util.ArrayList;
import java.util.List;

public class ContractServiceImpl implements ContractService {
    private ContractDAO contractDAO=new ContractDAOImpl();
    @Override
    public List<Contract> findAllContract() {
        List<Contract>list=new ArrayList<>();
        try{
            list=contractDAO.findAllContract();
        }catch(Exception e){
            System.err.println(e);
        }
        return list;
    }

    @Override
    public Contract findContractById(int id) {
        Contract contract=new Contract();
        try{
            contract=contractDAO.findContractById(id);
        }catch (Exception e){
            System.err.println(e);
        }
        return contract;
    }

    @Override
    public int saveContract(Contract contract) {
        int so=-1;
        try{
            so=contractDAO.saveContract(contract);
        }catch(Exception e){
            System.err.println(e);
        }
        return so;
    }

    @Override
    public int updateContractfindById(int i) {
        int so=-1;
        try{
            so=contractDAO.updateContractfindById(i);
        }catch (Exception e){
            System.err.println(e);
        }
        return so;
    }

    @Override
    public List<Contract> findContractByDate(String part) {
        List<Contract>list=new ArrayList<>();
        try{
            list=contractDAO.findContractByDate(part);
        }catch(Exception e){
            System.err.println(e);
        }
        return list;
    }

    @Override
    public List<Contract> findNewContract(String date) {
        List<Contract>list=new ArrayList<>();
        try{
            list=contractDAO.findNewContract(date);
        }catch(Exception e){
            System.err.println(e);
        }
        return list;
    }

    @Override
    public List<Contract> findContractByName(String part) {
        List<Contract>list=new ArrayList<>();
        try{
            list=contractDAO.findContractByName(part);
        }catch(Exception e){
            System.err.println(e);
        }
        return list;
    }

}
