/**
 * The type Employee.
 */
public class Employee extends Person implements Printable {
    private String employeeId;
    private String clockedIn;
    private String hiredDate;

    /**
     * Instantiates a new Employee.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param address     the address
     * @param phoneNumber the phone number
     * @param email       the email
     * @param employeeId  the employee id
     * @param clockedIn   the clocked in
     * @param hiredDate   the hired date
     */
    public Employee(String firstName, String lastName, String address, String phoneNumber, String email, String employeeId,
                    String clockedIn, String hiredDate) {
        super(firstName, lastName, address, phoneNumber, email);
        this.employeeId = employeeId;
        this.clockedIn = clockedIn;
        this.hiredDate = hiredDate;
    }

    @Override
    public String getFileData() {
        return this.employeeId + "," + this.getFirstName() + "," + this.getLastName() + "," + this.getClockedIn();
    }

    /**
     * Sets employee id.
     *
     * @param employeeId the employee id
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Sets clocked in.
     *
     * @param clockedIn the clocked in
     */
    public void setClockedIn(String clockedIn) {
        this.clockedIn = clockedIn;
    }

    /**
     * Sets hired date.
     *
     * @param hiredDate the hired date
     */
    public void setHiredDate(String hiredDate) {
        this.hiredDate = hiredDate;
    }

    /**
     * Gets employee id.
     *
     * @return the employee id
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Gets clocked in.
     *
     * @return the clocked in
     */
    public String getClockedIn() {
        return clockedIn;
    }

    /**
     * Gets hired date.
     *
     * @return the hired date
     */
    public String getHiredDate() {
        return hiredDate;
    }

}
