package dao.util;

public class SQLQuery {

    public static final String SQL_SELECT_USERS_BY_NP="select userName, userPassword, rolId, phoneNum from users where userName=? and userPassword=?";
    public static final String SQL_SELECT_ALL_PROJECT="select projectId, projectName from project";
    public static final String SQL_SELECT_ALL_CATEGORY="select categoryId, categoryName from category";
    public static final String SQL_SELECT_ALL_ESTATE="select e.estateId, p.projectName, c.categoryName, e.price, e.estateStatus from Estate e inner join Project p on p.projectId=e.projectId inner join Category c on c.categoryId=e.categoryId";
    public static final String SQL_FIND_ESTATE_BY_ID="select e.estateId, p.projectName, c.categoryName, e.price, e.estateStatus from Estate e inner join Project p on p.projectId=e.projectId inner join Category c on c.categoryId=e.categoryId where e.estateId=?";
    public static final String SQL_ADD_ESTATE="insert into Estate values (null,?,?,?,?)";
    public static final String SQL_UPDATE_BY_ID="update estate set projectId=?, categoryId=?, price=?, estateStatus=? where estateId=?";
    public static final String SQL_UPDATE_ESTATESTATUS_ID = "update estate set estateStatus='sold' where estateId=?";
    public static final String SQL_UPDATE_ESTATESTATUS_ID2 = "update estate set estateStatus='available' where estateId=?";
    public static final String SQL_DELETE_BY_ID="delete from estate where estateId=?";
    public static final String SQL_SELECT_ALL_CONTRACT = "select contractId, userName, estateId, urlContract, statusContract, dateContract, deadlineContract \n" +
            "from Contract";
    public static final String SQL_FIND_CONTRACT_BY_ID = "select contractId, u.userName, estateId, u.phoneNum, statusContract, dateContract, deadlineContract \n" +
            "from Contract c\n" +
            "inner join users u on u.userName = c.userName\n" +
            "where contractId=?";
    public static final String SQL_ADD_CONTRACT = "insert into Contract values (null,?,?,?,?,?,?)";
    public static final String SQL_UPDATE_CONTRACT_BY_ID = "update contract set statusContract='available' , deadlineContract=null where contractId=?";
    public static final String SQL_FIND_ESTATE_BY_PID_CID = "select e.estateId, p.projectName, c.categoryName, e.price," +
            " e.estateStatus from Estate e inner join Project p on p.projectId=e.projectId inner join Category c on " +
            "c.categoryId=e.categoryId where p.projectId=? AND c.categoryId=? AND e.price<=?";
    public static final String SQL_SELECT_CONTRACT_BY_DATE = "select contractId, userName, estateId, urlContract, statusContract, dateContract, deadlineContract from Contract where deadlineContract=?";
    public static final String SQL_ADD_USER = "insert into users values (?,?,3,?)";
    public static final String SQL_FIND_PROJECT_BY_ID = "select projectId, projectName from project where projectId=?";
    public static final String SQL_ADD_PROJECT = "insert into project values (null,?)";
    public static final String SQL_PROJECT_UPDATE_BY_ID = "update project set projectName=? where projectId=?";
    public static final String SQL_PROJECT_DELETE_BY_ID = "delete from project where projectId=?";
    public static final String SQL_SELECT_ALL_USER = "select userName, userPassword, rolId, phoneNum from users";
    public static final String SQL_FIND_USER_BY_ID = "select userName, userPassword, rolId, phoneNum from users where userName=?";
    public static final String SQL_DELETE_BY_USERNAME = "";
    public static final String SQL_UPDATE_BY_USERNAME = "update users set rolId=3 where userName=?";
    public static final String SQL_ADD_STAFF = "insert into users values (?,?,2,?)";
    public static final String SQL_SELECT_NEW_CONTRACT = "select contractId, userName, estateId, urlContract, statusContract, dateContract, deadlineContract from Contract where dateContract=?";
    public static final String SQL_FIND_CONTRACT_BY_NAME = "select contractId, userName, estateId, urlContract, statusContract, dateContract, deadlineContract from Contract where userName=?";
}
