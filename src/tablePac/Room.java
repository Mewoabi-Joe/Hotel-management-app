package tablePac;

public class Room {
        private int id;
        private int number;
        private String roomType;
        private String bedType;
        private double pricePerNight;
        private int noMaxPersons;
        private String status;

    public Room(int id, int number, String roomType, String bedType, double pricePerNight, int noMaxPersons, String status) {
        this.id = id;
        this.number = number;
        this.roomType = roomType;
        this.bedType = bedType;
        this.pricePerNight = pricePerNight;
        this.noMaxPersons = noMaxPersons;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getNoMaxPersons() {
        return noMaxPersons;
    }

    public void setNoMaxPersons(int noMaxPersons) {
        this.noMaxPersons = noMaxPersons;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
