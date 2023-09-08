package tablePac;

public class Planning {
    private int planningId;
    private String recepFName;
    private int recepId;
    private String workMonth;
    private int startDay;
    private int endDay;
    private int startHour;
    private int endHour;

    public Planning(int planningId, String recepFName, int recepId, String workMonth, int startDay, int endDay, int startHour, int endHour) {
        this.planningId = planningId;
        this.recepFName = recepFName;
        this.recepId = recepId;
        this.workMonth = workMonth;
        this.startDay = startDay;
        this.endDay = endDay;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public int getPlanningId() {
        return planningId;
    }

    public void setPlanningId(int planningId) {
        this.planningId = planningId;
    }

    public String getRecepFName() {
        return recepFName;
    }

    public void setRecepFName(String recepFName) {
        this.recepFName = recepFName;
    }

    public int getRecepId() {
        return recepId;
    }

    public void setRecepId(int recepId) {
        this.recepId = recepId;
    }

    public String getWorkMonth() {
        return workMonth;
    }

    public void setWorkMonth(String workMonth) {
        this.workMonth = workMonth;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }
}
