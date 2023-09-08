package tablePac;

import java.sql.Date;

public class Client {
    private int clId;
    private String clFName;
    private String clEmail;
    private String clCountry;
    private String clStatus;
    private String clPayMethod;
    private Double clAmtPaid;
    private Date clCheckIn;
    private Date clCheckOut;
    private int clRoomNum;

    public Client(int clId, String clFName, String clEmail, String clCountry, String clStatus, String clPayMethod, Double clAmtPaid, Date clCheckIn, Date clCheckOut, int clRoomNum) {
        this.clId = clId;
        this.clFName = clFName;
        this.clEmail = clEmail;
        this.clCountry = clCountry;
        this.clStatus = clStatus;
        this.clPayMethod = clPayMethod;
        this.clAmtPaid = clAmtPaid;
        this.clCheckIn = clCheckIn;
        this.clCheckOut = clCheckOut;
        this.clRoomNum = clRoomNum;
    }

    public int getClId() {
        return clId;
    }

    public void setClId(int clId) {
        this.clId = clId;
    }

    public String getClFName() {
        return clFName;
    }

    public void setClFName(String clFName) {
        this.clFName = clFName;
    }

    public String getClEmail() {
        return clEmail;
    }

    public void setClEmail(String clEmail) {
        this.clEmail = clEmail;
    }

    public String getClCountry() {
        return clCountry;
    }

    public void setClCountry(String clCountry) {
        this.clCountry = clCountry;
    }

    public String getClStatus() {
        return clStatus;
    }

    public void setClStatus(String clStatus) {
        this.clStatus = clStatus;
    }

    public String getClPayMethod() {
        return clPayMethod;
    }

    public void setClPayMethod(String clPayMethod) {
        this.clPayMethod = clPayMethod;
    }

    public Double getClAmtPaid() {
        return clAmtPaid;
    }

    public void setClAmtPaid(Double clAmtPaid) {
        this.clAmtPaid = clAmtPaid;
    }

    public Date getClCheckIn() {
        return clCheckIn;
    }

    public void setClCheckIn(Date clCheckIn) {
        this.clCheckIn = clCheckIn;
    }

    public Date getClCheckOut() {
        return clCheckOut;
    }

    public void setClCheckOut(Date clCheckOut) {
        this.clCheckOut = clCheckOut;
    }

    public int getClRoomNum() {
        return clRoomNum;
    }

    public void setClRoomNum(int clRoomNum) {
        this.clRoomNum = clRoomNum;
    }
}
