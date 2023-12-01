package service;


import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO=new CategoryDAOImpl();
    @Override
    public List<Category> findAllCategory() {
        List<Category>list=new ArrayList<>();
        try{
            list=categoryDAO.findAllCategory();
        }catch(Exception e){
            System.err.println(e);
        }
        return list;
    }
}
