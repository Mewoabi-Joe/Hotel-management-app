package tablePac;

import java.sql.Date;

public class Employee {
    private int idEmp;
    private String firstName;
    private String lastNameEmp;
    private String emailEmp;
    private String sexEmp;
    private Date dobEmp;
    private String addressEmp;

    public Employee(int idEmp, String fNameEmp, String lNameEmp, String emailEmp, String sexEmp, Date dobEmp, String addressEmp) {
        this.idEmp = idEmp;
        this.firstName = fNameEmp;
        this.lastNameEmp = lNameEmp;
        this.emailEmp = emailEmp;
        this.sexEmp = sexEmp;
        this.dobEmp = dobEmp;
        this.addressEmp = addressEmp;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public String getFirstNameEmp() {
        return firstName;
    }

    public void setFirstNameEmp(String fNameEmp) {
        this.firstName = fNameEmp;
    }

    public String getLastNameEmp() {
        return lastNameEmp;
    }

    public void setLastNameEmp(String lNameEmp) {
        this.lastNameEmp = lNameEmp;
    }

    public String getEmailEmp() {
        return emailEmp;
    }

    public void setEmailEmp(String emailEmp) {
        this.emailEmp = emailEmp;
    }

    public String getSexEmp() {
        return sexEmp;
    }

    public void setSexEmp(String sexEmp) {
        this.sexEmp = sexEmp;
    }

    public Date getDobEmp() {
        return dobEmp;
    }

    public void setDobEmp(Date dobEmp) {
        this.dobEmp = dobEmp;
    }

    public String getAddressEmp() {
        return addressEmp;
    }

    public void setAddressEmp(String addressEmp) {
        this.addressEmp = addressEmp;
    }
}
