package service;


import dao.UserDAO;
import dao.UserDAOImpl;
import model.Project;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO=new UserDAOImpl();
    @Override
    public User findUserByNP(String username, String password) {
        User user=new User();
        try{
            user=userDAO.findUserByNP(username,password);
        }catch(Exception e){
            System.err.println(e);
        }
        return user;
    }

    @Override
    public User check(User user) {
        User us=new User();
        try{
            us=userDAO.check(user);
        }catch(Exception e){
            System.err.println(e);
        }
        return us;
    }
    @Override
    public int save(User user) {
        int so=-1;
        try{
            so=userDAO.save(user);
        }catch(Exception e){
            System.err.println(e);
        }
        return so;
    }

    @Override
    public List<User> findAllUser() {
        List<User>list=new ArrayList<>();
        try{
            list=userDAO.findAllUser();
        }catch(Exception e){
            System.err.println(e);
        }
        return list;
    }

    @Override
    public User findByUserName(String us) {
        User user=new User();
        try{
            user=userDAO.findByUserName(us);
        }catch (Exception e){
            System.err.println(e);
        }
        return user;
    }

    @Override
    public int deleteByUserName(String parts) {
        int so=-1;
        try{
            so=userDAO.deleteByUserName(parts);
        }catch (Exception e){
            System.err.println(e);
        }
        return so;
    }

    @Override
    public int updatefindByUserName(String jsonData, User user) {
        int so=-1;
        try{
            so=userDAO.updatefindByUser(jsonData,user);
        }catch (Exception e){
            System.err.println(e);
        }
        return so;
    }

    @Override
    public int addStaff(User user) {
        int so=-1;
        try{
            so=userDAO.addStaff(user);
        }catch(Exception e){
            System.err.println(e);
        }
        return so;
    }

}
