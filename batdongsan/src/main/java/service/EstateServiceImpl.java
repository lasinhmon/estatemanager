package service;

import dao.EstateDAO;
import dao.EstateDAOImpl;
import model.Estate;

import java.util.ArrayList;
import java.util.List;

public class EstateServiceImpl implements EstateService {
    private EstateDAO estateDAO=new EstateDAOImpl();

    @Override
    public List<Estate> findAllEstate() {
        List<Estate>list=new ArrayList<>();
        try{
            list=estateDAO.findAllEstate();
        }catch(Exception e){
            System.err.println(e);
        }
        return list;
    }

    @Override
    public Estate findById(int id) {
        Estate estate=new Estate();
        try{
            estate=estateDAO.findById(id);
        }catch (Exception e){
            System.err.println(e);
        }
        return estate;
    }

    @Override
    public int save(Estate estate) {
        int so=-1;
        try{
            so=estateDAO.save(estate);
        }catch(Exception e){
            System.err.println(e);
        }
        return so;
    }

    @Override
    public int updatefindById(int i, Estate estate) {
        int so=-1;
        try{
            so=estateDAO.updatefindById(i,estate);
        }catch (Exception e){
            System.err.println(e);
        }
        return so;
    }

    @Override
    public int deleteById(int id) {
        int so=-1;
        try{
            so=estateDAO.deleteById(id);
        }catch (Exception e){
            System.err.println(e);
        }
        return so;
    }

    @Override
    public List<Estate> findByPidCid(int id, String cid,String price) {
        List<Estate>list=new ArrayList<>();
        try{
            list=estateDAO.findByPidCid(id,cid,price);
        }catch(Exception e){
            System.err.println(e);
        }
        return list;
    }

    @Override
    public int updateStatusEstates(int estateId) {
        int so=-1;
        try{
            so=estateDAO.updateStatusEstates(estateId);
        }catch (Exception e){
            System.err.println(e);
        }
        return so;
    }
    public int updateStatusEstates2(int estateId) {
        int so=-1;
        try{
            so=estateDAO.updateStatusEstates2(estateId);
        }catch (Exception e){
            System.err.println(e);
        }
        return so;
    }
}
