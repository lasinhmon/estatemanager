package model;

public class Estate {
    private int estateId;
    private String projectId;
    private String categoryId;
    private long price;
    private String statusId;

    public Estate() {
    }

    public Estate(int estateId, String projectId, String categoryId, long price, String statusId) {
        this.estateId = estateId;
        this.projectId = projectId;
        this.categoryId = categoryId;
        this.price = price;
        this.statusId = statusId;
    }

    public int getEstateId() {
        return estateId;
    }

    public void setEstateId(int estateId) {
        this.estateId = estateId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }
}
