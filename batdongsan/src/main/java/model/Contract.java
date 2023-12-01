package model;

import java.sql.Date;

public class Contract {
    private int contractId;
    private String userName;
    private int estateId;
    private String urlContract;
    private String statusContract;
    private Date dateContract;
    private Date deadlineContract;

    public Contract() {
    }

    public Contract(int contractId, String userName, int estateId, String urlContract, String statusContract, Date dateContract, Date deadlineContract) {
        this.contractId = contractId;
        this.userName = userName;
        this.estateId = estateId;
        this.urlContract = urlContract;
        this.statusContract = statusContract;
        this.dateContract = dateContract;
        this.deadlineContract = deadlineContract;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getEstateId() {
        return estateId;
    }

    public void setEstateId(int estateId) {
        this.estateId = estateId;
    }

    public String getUrlContract() {
        return urlContract;
    }

    public void setUrlContract(String urlContract) {
        this.urlContract = urlContract;
    }

    public String getStatusContract() {
        return statusContract;
    }

    public void setStatusContract(String statusContract) {
        this.statusContract = statusContract;
    }

    public Date getDateContract() {
        return dateContract;
    }

    public void setDateContract(Date dateContract) {
        this.dateContract = dateContract;
    }

    public Date getDeadlineContract() {
        return deadlineContract;
    }

    public void setDeadlineContract(Date deadlineContract) {
        this.deadlineContract = deadlineContract;
    }
}
