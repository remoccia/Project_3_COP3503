import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Queue;


/**
 * The type Project 3.
 */
public class Project3 {
    /**
     * The constant employeeFileName.
     */
    public static String employeeFileName = "employee_data.csv";
    /**
     * The constant tier1TicketFileName.
     */
    public static String tier1TicketFileName = "tier1_ticket_data.csv";
    /**
     * The constant tier2TicketFileName.
     */
    public static String tier2TicketFileName = "tier2_ticket_data.csv";
    /**
     * The constant workOrderFileName.
     */
    public static String workOrderFileName;
    /**
     * The constant employeeList.
     */
    public static ArrayList<Employee> employeeList = new ArrayList<Employee>();
    /**
     * The Tier 1 ticket file.
     */
    public static Queue<Ticket> tier1TicketFile;
    /**
     * The Tier 2 ticket file.
     */
    public static Queue<Ticket> tier2TicketFile;
    /**
     * The constant workOrderList.
     */
    public static ArrayList<WorkOrder> workOrderList = new ArrayList<>();


    /**
     * Get date string.
     *
     * @return the string
     */
    public static String GetDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        return (dateFormat.format(date));
    }


    /**
     * Create work orders.
     */
    public static void createWorkOrders() {

        ArrayList<Employee> tier2Employees = new ArrayList<Employee>();
        ArrayList<Employee> tier1Employees = new ArrayList<Employee>();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i) instanceof Tier2Employee) {
                tier2Employees.add(employeeList.get(i));
            } else {
                tier1Employees.add(employeeList.get(i));
            }
        }

        int amtWorkers = tier2Employees.size();
        int currentWorker = 0;
        while (!tier2TicketFile.isEmpty()) {
            Ticket ticket = tier2TicketFile.poll();
            if (currentWorker == amtWorkers) {
                currentWorker = 0;
            }
            Employee employee = tier2Employees.get(currentWorker);
            currentWorker++;
            String createdAt = GetDate();
            WorkOrder workOrder = new WorkOrder(ticket, createdAt, employee);
            workOrderList.add(workOrder);
        }
        amtWorkers = tier1Employees.size();
        currentWorker = 0;
        while (!tier1TicketFile.isEmpty()) {
            Ticket ticket = tier1TicketFile.poll();
            if (currentWorker == amtWorkers) {
                currentWorker = 0;
            }
            Employee employee = tier1Employees.get(currentWorker);
            currentWorker++;
            String createdAt = GetDate();
            WorkOrder workOrder = new WorkOrder(ticket, createdAt, employee);
            workOrderList.add(workOrder);
        }

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        try {
            System.out.println("Project 3 Starting");
            System.out.println("loading File Data");
            FileHandler.readEmployeeData(employeeFileName);
            System.out.println("Loading Ticket Data");
            System.out.println("Loading Ticket Data");

            tier1TicketFile = FileHandler.readTicketData(tier1TicketFileName);
            tier2TicketFile = FileHandler.readTicketData(tier2TicketFileName);
            createWorkOrders();
            FileHandler.writeData(workOrderFileName);
            System.out.println("Creating Work Orders\n" + "Writing Work Order Data to File\n" + "Work Orders created. " +
                    "Program exiting");
        } catch (IOException ignored) {

        }
    }
}




