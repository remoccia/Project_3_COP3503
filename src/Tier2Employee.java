/**
 * The type Tier 2 employee.
 */
public class Tier2Employee extends Employee implements Printable{
    private String certification;

    /**
     * Instantiates a new Tier 2 employee.
     *
     * @param firstName     the first name
     * @param lastName      the last name
     * @param address       the address
     * @param phoneNumber   the phone number
     * @param email         the email
     * @param employeeId    the employee id
     * @param clockedIn     the clocked in
     * @param hiredDate     the hired date
     * @param certification the certification
     */
    public Tier2Employee(String firstName, String lastName, String address, String phoneNumber, String email,
                         String employeeId, String clockedIn, String hiredDate, String certification) {
        super(firstName, lastName, address, phoneNumber, email, employeeId, clockedIn, hiredDate);
        this.certification = certification;
    }

    @Override
    public String getFileData() {
        return  super.getFileData() + "," + this.certification ;
    }

    /**
     * Sets certification.
     *
     * @param certification the certification
     */
    public void setCertification(String certification) {
        this.certification = certification;
    }

    /**
     * Gets certification.
     *
     * @return the certification
     */
    public String getCertification() {
        return certification;
    }
}
