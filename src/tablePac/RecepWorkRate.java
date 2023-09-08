package tablePac;

public class RecepWorkRate {
    private String firstName;
    private String lastName;
    private String email;
    private int numberOfClients;

    public RecepWorkRate(String firstName, String lastName, String email, int numberOfClients) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.numberOfClients = numberOfClients;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumberOfClients() {
        return numberOfClients;
    }

    public void setNumberOfClients(int numberOfClients) {
        this.numberOfClients = numberOfClients;
    }
}
