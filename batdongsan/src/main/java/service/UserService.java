package service;

import model.Project;
import model.User;

import java.util.List;

public interface UserService {
    public User findUserByNP(String username, String password);

    public User check(User user);
    public int save(User user) ;

    List<User> findAllUser();

    User findByUserName(String us);

    public int deleteByUserName(String parts);

    public int updatefindByUserName(String jsonData, User user);

    public int addStaff(User user);
}
