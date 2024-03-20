/**
 * The type Work order.
 */
public class WorkOrder implements Printable{
    /**
     * The Employee.
     */
    Employee employee;
    /**
     * The Created at.
     */
    String createdAt;
    /**
     * The Ticket.
     */
    Ticket ticket;

    /**
     * Instantiates a new Work order.
     *
     * @param ticket    the ticket
     * @param createdAt the created at
     * @param employee  the employee
     */
    public WorkOrder(Ticket ticket, String createdAt, Employee employee) {
        this.employee = employee;
        this.createdAt = createdAt;
        this.ticket = ticket;

    }

    @Override
    public String getFileData() {
        return  this.getTicket().getFileData() + "," + this.getCreatedAt() + "," + this.getEmployee().getFileData();
    }

    /**
     * Gets employee.
     *
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets employee.
     *
     * @param employee the employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets ticket.
     *
     * @return the ticket
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * Sets ticket.
     *
     * @param ticket the ticket
     */
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
