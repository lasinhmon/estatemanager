package service;

import model.Estate;

import java.util.List;

public interface EstateService {
    public List<Estate> findAllEstate();
    public Estate findById(int id);
    public int save(Estate estate);

    public int updatefindById(int i, Estate estate);

    public int deleteById(int id);

    public List<Estate> findByPidCid(int id, String cid,String price);

    public int updateStatusEstates(int estateId);
    public int updateStatusEstates2(int estateId);

}
