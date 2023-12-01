package model;

public class User {
    private String userName;
    private String userPassword;
    private int rolId;
    private String phoneNum;
    public User() {
    }

    public User(String userName, String userPassword, int rolId, String phoneNum) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.rolId=rolId;
        this.phoneNum=phoneNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
