package tablePac;

public class RoomBookFrequency {
    private int roomNumber;
    private int bookingFrequency;

    public RoomBookFrequency(int roomNumber, int bookingFrequency) {
        this.roomNumber = roomNumber;
        this.bookingFrequency = bookingFrequency;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getBookingFrequency() {
        return bookingFrequency;
    }

    public void setBookingFrequency(int bookingFrequency) {
        this.bookingFrequency = bookingFrequency;
    }
}
