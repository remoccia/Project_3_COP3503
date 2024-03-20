import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * The type File handler.
 */
public class FileHandler {
    /**
     * Write data.
     *
     * @param workOrderFileName the work order file name
     * @throws IOException the io exception
     */
    public static void writeData(String workOrderFileName) throws IOException {
        logger("Writing Work Order to File");
        File file = new File("work_order.csv");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(
                "Customer ID," + "Customer First," + "Customer Last," + "TicketID," + "Ticket Created,"
                + "Workorder Created," + "Employee ID," + "Employee First," + "Employee Last,"
                + "Clocked In," + "Certification" + "\n");
        for(int i = 0; i < Project3.workOrderList.size(); i++){
            WorkOrder workOrder = Project3.workOrderList.get(i);
            fileWriter.write(workOrder.getFileData());
            fileWriter.write("\n");
            logger(workOrder.getFileData());

        }
        fileWriter.close();
        logger("Work Order File Created. Program Exiting");
    }


    /**
     * Read employee data.
     *
     * @param employeeFileName the employee file name
     * @throws IOException the io exception
     */
    public static void readEmployeeData(String employeeFileName) throws IOException {
        try {
            File file = new File(employeeFileName);
            logger("Loading Employee Data");
            Scanner fileScan = new Scanner(file);

            String header = fileScan.nextLine();

            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                String[] lineData = line.split(",");
                String employeeId = lineData[0];
                String firstName = lineData[1];
                String lastName = lineData[2];
                String email = lineData[3];
                String address = lineData[4];
                String phoneNumber = lineData[5];
                String clockedIn = lineData[6];
                String hiredDate = lineData[7];
                String employeeTier = lineData[8];
                String certification = lineData[9];
                if (employeeTier.equals("tier2")) {
                    Tier2Employee employee = new Tier2Employee(firstName, lastName, address, phoneNumber, email,
                            employeeId, clockedIn ,hiredDate, certification);

                    Project3.employeeList.add(employee);
                } else {
                    Employee employee = new Employee(employeeId, firstName, lastName, email, address, phoneNumber,
                            clockedIn, hiredDate);
                    Project3.employeeList.add(employee);

                }

            } fileScan.close();
        } catch (IOException ignored) {

        }


    }

    /**
     * Read ticket data linked list.
     *
     * @param ticketFileName the ticket file name
     * @return the linked list
     * @throws IOException the io exception
     */
    public static LinkedList<Ticket> readTicketData(String ticketFileName) throws IOException {

        LinkedList<Ticket> ticketLinkedList = new LinkedList<Ticket>();
        logger("Loading Ticket Data");
        try {
            File file = new File(ticketFileName);
            Scanner fileScanner = new Scanner(file);

            String header = fileScanner.nextLine();

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineData = line.split(",");
                String customerId = lineData[0];
                String firstName = lineData[1];
                String lastName = lineData[2];
                String email = lineData[3];
                String address = lineData[4];
                String phoneNumber = lineData[5];
                String accountNumber = lineData[6];
                String ticketId = lineData[7];
                String createdAt = lineData[8];
                Customer customer = new Customer(firstName, lastName, address, phoneNumber, email, customerId, accountNumber);
                Ticket ticket = new Ticket(customer, createdAt, ticketId);
                ticketLinkedList.add(ticket);


            }
            fileScanner.close();


        } catch (FileNotFoundException ignored) {

        }

        return ticketLinkedList;
    }

    private static void logger(String log) throws IOException {
        try {
            File file = new File("log.txt");
            FileWriter fileWriter = null;
            File logFile = new File(log);
            if (!file.exists()) {
                fileWriter = new FileWriter(file);
            } else {
                fileWriter = new FileWriter(file, true);
            }
            fileWriter.write("Log:  "+ Project3.GetDate() + "  " + log);
            fileWriter.write("\n");
            fileWriter.close();

        } catch (IOException ignored) {

        }
    }


}
